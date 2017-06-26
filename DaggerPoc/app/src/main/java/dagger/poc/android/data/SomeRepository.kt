package dagger.poc.android.data

import android.util.Log
import dagger.poc.android.data.model.Answer
import dagger.poc.android.data.model.User
import dagger.poc.android.injection.LocalQualifier
import dagger.poc.android.injection.RemoteQualifier
import dagger.poc.android.injection.ApplicationScope
import javax.inject.Inject

/**
 * Created by Thiago on 6/23/2017.
 */

@ApplicationScope
class SomeRepository @Inject constructor(@LocalQualifier val localDataSource: SomeDataSource,
                                         @RemoteQualifier val remoteDataSource: SomeDataSource){

    fun getSomething() {
        Log.d("DaggerPOC", "SomeRepository called - instance: " + hashCode())

        if (localDataSource.getAllAnswers().isEmpty()) {
            val userId = localDataSource.createUser(User())
            localDataSource.createAnswer(Answer(userId))
        }

        val allAnswers = localDataSource.getAllAnswers()

        Log.d("DaggerPOC", "SomeRepository - all answers: " + allAnswers.toString())

        localDataSource.getSomething()
        remoteDataSource.getSomething()
    }
}