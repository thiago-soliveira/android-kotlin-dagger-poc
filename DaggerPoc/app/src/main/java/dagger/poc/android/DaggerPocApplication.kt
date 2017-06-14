package dagger.poc.android

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import dagger.poc.android.injection.DaggerApplicationComponent

/**
 * Created by Thiago on 6/12/2017.
 */
class DaggerPocApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().create(this)
    }

    override fun onCreate() {
        super.onCreate()
    }
}