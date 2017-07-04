package dagger.poc.android.data

import android.arch.persistence.room.*
import dagger.poc.android.data.model.Answer
import io.reactivex.Flowable

/**
 * Created by Thiago on 6/26/2017.
 */

@Dao
interface AnswerRoomDbDao {

    @Query("SELECT * FROM answer "
            + "INNER JOIN user ON user.id = answer.author_id")
    fun findAll(): Flowable<List<Answer>>

    @Insert
    fun create(answer: Answer): Long

    @Delete
    fun delete(answer: Answer)

    @Update
    fun update(answer: Answer)

}