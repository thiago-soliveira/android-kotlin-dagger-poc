package dagger.poc.android.injection;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.poc.android.DaggerPocApplication;

/**
 * Created by Thiago on 6/14/2017.
 */

@Module
abstract class ApplicationModule {

    @Binds
    abstract Application application(DaggerPocApplication application);

    @Provides
    static SharedPreferences preferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
