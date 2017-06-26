package dagger.poc.android.data

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import dagger.poc.android.data.model.Answer
import dagger.poc.android.data.model.User

/**
 * Created by Thiago on 6/26/2017.
 */

@Database(entities = arrayOf(Answer::class, User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun answerDao(): AnswerRoomDbDao
    abstract fun userDao(): UserRoomDbDao

}