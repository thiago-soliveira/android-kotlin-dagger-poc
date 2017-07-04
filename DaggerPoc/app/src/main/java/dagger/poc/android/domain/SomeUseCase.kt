package dagger.poc.android.domain

import android.util.Log
import dagger.poc.android.data.SomeRepository
import dagger.poc.android.data.model.Answer
import dagger.poc.android.data.model.User
import dagger.poc.android.injection.ActivityScope
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by Thiago on 6/14/2017.
 */

@ActivityScope
class SomeUseCase @Inject constructor(val someRepository: SomeRepository) {

    fun execute(user: User): Flowable<List<Answer>> {
        Log.d("DaggerPOC", "SomeUseCase called - instance: " + hashCode())

        return someRepository.getAllAnswers().observeOn(AndroidSchedulers.mainThread())
    }
}