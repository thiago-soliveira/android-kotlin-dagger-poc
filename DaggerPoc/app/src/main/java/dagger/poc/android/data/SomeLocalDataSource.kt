package dagger.poc.android.data

import android.util.Log
import javax.inject.Inject

/**
 * Created by Thiago on 6/23/2017.
 */
class SomeLocalDataSource @Inject constructor() : SomeDataSource {

    override fun getSomething() {
        Log.d("DaggerPOC", "SomeLocalDataSource called - instance: " + hashCode())
    }
}