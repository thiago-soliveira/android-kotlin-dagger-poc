package dagger.poc.android.injection

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.poc.android.DaggerPocApplication

/**
 * Created by Thiago on 6/12/2017.
 */

@ApplicationScope
@Component(modules = arrayOf(
        ApplicationModule::class,
        AndroidBindingModule::class,
        AndroidSupportInjectionModule::class,
        DatasourceModule::class)
)
interface ApplicationComponent : AndroidInjector<DaggerPocApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DaggerPocApplication>()

}