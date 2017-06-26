package dagger.poc.android.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Thiago on 6/26/2017.
 */

@Entity(foreignKeys = arrayOf(
        ForeignKey(entity = User::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("author_id")))
)
data class Answer constructor(@ColumnInfo(name = "author_id") var authorId: Long = 0) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

}