package dagger.poc.android.injection

import android.util.Log
import dagger.poc.android.data.SomeDataSource
import dagger.poc.android.data.model.Answer
import dagger.poc.android.data.model.User
import javax.inject.Inject

/**
 * Created by Thiago on 6/23/2017.
 */
class SomeFakeDataSource @Inject constructor() : SomeDataSource {

    override fun createAnswer(answer: Answer): Long {
        return 0
    }

    override fun getAllAnswers(): List<Answer> {
        return arrayListOf(Answer(0))
    }

    override fun createUser(user: User): Long {
        return 0
    }

    override fun getSomething() {
        Log.d("DaggerPOC", "SomeFakeDataSource called - instance: " + hashCode())
    }
}