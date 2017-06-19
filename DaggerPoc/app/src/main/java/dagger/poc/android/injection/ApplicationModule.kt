package dagger.poc.android.injection

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.poc.android.DaggerPocApplication

/**
 * Created by Thiago on 6/14/2017.
 */

@Module
internal abstract class ApplicationModule {

    @Binds
    internal abstract fun application(application: DaggerPocApplication): Application

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun preferences(application: Application): SharedPreferences {
            return PreferenceManager.getDefaultSharedPreferences(application)
        }
    }
}
