package dagger.poc.android

import android.util.Log
import dagger.poc.android.injection.ActivityScope
import javax.inject.Inject

/**
 * Created by Thiago on 6/14/2017.
 */

@ActivityScope
class SomeUseCase @Inject constructor() {

    fun execute() {
        Log.d("DaggerPOC", "Some use case executed - instance: " + hashCode())
    }
}