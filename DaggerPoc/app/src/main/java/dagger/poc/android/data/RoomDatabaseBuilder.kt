package dagger.poc.android.data

import android.arch.persistence.room.Room
import dagger.poc.android.DaggerPocApplication
import dagger.poc.android.injection.ApplicationScope
import javax.inject.Inject

/**
 * Created by Thiago on 6/26/2017.
 */

@ApplicationScope
class RoomDatabaseBuilder @Inject constructor(application: DaggerPocApplication) {

    val db = Room.databaseBuilder(application.applicationContext, AppDatabase::class.java,
            "daggerpoc-db").build()!!

}