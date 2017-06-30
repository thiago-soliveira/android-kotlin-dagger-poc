package dagger.poc.android.data

import android.util.Log
import dagger.poc.android.data.model.Answer
import dagger.poc.android.data.model.User
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Thiago on 6/23/2017.
 */
class SomeLocalDataSource @Inject constructor(roomDb: RoomDatabaseBuilder) : SomeDataSource {

    val answerDbDao = roomDb.db.answerDao()
    val userDbDao = roomDb.db.userDao()

    override fun createUser(user: User): Long {
        return userDbDao.create(user)
    }

    override fun createAnswer(answer: Answer): Long {
        return answerDbDao.create(answer)
    }

    override fun getAllAnswers(): Flowable<List<Answer>> {
        return answerDbDao.findAll()
    }

    override fun getSomething() {
        Log.d("DaggerPOC", "SomeLocalDataSource called - instance: " + hashCode())
    }
}