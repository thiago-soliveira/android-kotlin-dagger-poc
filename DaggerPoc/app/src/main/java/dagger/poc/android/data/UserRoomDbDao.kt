package dagger.poc.android.data

import android.arch.persistence.room.*
import dagger.poc.android.data.model.Answer
import dagger.poc.android.data.model.User

/**
 * Created by Thiago on 6/26/2017.
 */

@Dao
interface UserRoomDbDao {

    @Insert
    fun create(user: User): Long

}