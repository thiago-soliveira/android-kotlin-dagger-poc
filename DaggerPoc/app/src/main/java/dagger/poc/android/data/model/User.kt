package dagger.poc.android.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Thiago on 6/26/2017.
 */

@Entity
class User {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

}