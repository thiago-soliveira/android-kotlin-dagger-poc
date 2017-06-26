package dagger.poc.android.domain

import android.util.Log
import dagger.poc.android.data.SomeRepository
import dagger.poc.android.injection.ActivityScope
import javax.inject.Inject

/**
 * Created by Thiago on 6/14/2017.
 */

@ActivityScope
class SomeUseCase @Inject constructor(someRepository: SomeRepository) {

    val someRepository = someRepository

    fun execute() {
        Log.d("DaggerPOC", "SomeUseCase called - instance: " + hashCode())
        Thread({
            someRepository.getSomething()
        }).start()

    }
}