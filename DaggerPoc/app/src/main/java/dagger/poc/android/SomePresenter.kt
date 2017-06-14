package dagger.poc.android

import android.content.SharedPreferences
import android.util.Log
import dagger.poc.android.injection.ActivityScope
import dagger.poc.android.injection.ApplicationScope
import javax.inject.Inject

/**
 * Created by Thiago on 6/14/2017.
 */

@ActivityScope
class SomePresenter @Inject constructor(someUseCase: SomeUseCase) {

    val someUseCase = someUseCase

    fun execSomeTask() {
        someUseCase.execute()
    }
}
