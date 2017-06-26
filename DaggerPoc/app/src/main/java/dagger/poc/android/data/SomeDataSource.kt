package dagger.poc.android.data

import dagger.poc.android.data.model.Answer
import dagger.poc.android.data.model.User

/**
 * Created by Thiago on 6/23/2017.
 */

interface SomeDataSource {
    fun getSomething()
    fun createAnswer(answer: Answer): Long
    fun getAllAnswers(): List<Answer>
    fun createUser(user: User): Long
}