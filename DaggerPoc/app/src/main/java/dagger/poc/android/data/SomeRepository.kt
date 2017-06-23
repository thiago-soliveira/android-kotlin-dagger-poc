package dagger.poc.android.data

import android.util.Log
import dagger.poc.android.injection.LocalDataSource
import dagger.poc.android.injection.RemoteDataSource
import dagger.poc.android.injection.ApplicationScope
import javax.inject.Inject

/**
 * Created by Thiago on 6/23/2017.
 */

@ApplicationScope
class SomeRepository @Inject constructor(@LocalDataSource val localDataSource: SomeDataSource,
                                         @RemoteDataSource val remoteDataSource: SomeDataSource){

    fun getSomething() {
        Log.d("DaggerPOC", "SomeRepository called - instance: " + hashCode())
        localDataSource.getSomething()
        remoteDataSource.getSomething()
    }
}