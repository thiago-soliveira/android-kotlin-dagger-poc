package dagger.poc.android.presentation

import dagger.poc.android.domain.SomeUseCase
import dagger.poc.android.injection.ActivityScope
import javax.inject.Inject

/**
 * Created by Thiago on 6/14/2017.
 */

@ActivityScope
class SomePresenter @Inject constructor(val someUseCase: SomeUseCase) {

    fun execSomeTask() {
        android.util.Log.d("DaggerPOC", "SomePresenter called - instance: " + hashCode())
        someUseCase.execute()
    }
}
