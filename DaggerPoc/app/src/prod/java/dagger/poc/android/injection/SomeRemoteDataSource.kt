package dagger.poc.android.injection

import android.util.Log
import dagger.poc.android.data.SomeDataSource
import javax.inject.Inject

/**
 * Created by Thiago on 6/23/2017.
 */
class SomeRemoteDataSource @Inject constructor() : SomeDataSource {

    override fun getSomething() {
        Log.d("DaggerPOC", "SomeRemoteDataSource called - instance: " + hashCode())
    }

}