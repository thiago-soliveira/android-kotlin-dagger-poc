package dagger.poc.android.injection

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.poc.android.presentation.MainActivity
import dagger.poc.android.presentation.MyFragment

/**
 * Created by Thiago on 6/14/2017.
 */

@Module
internal abstract class AndroidBindingModule {

    @ContributesAndroidInjector
    @ActivityScope
    internal abstract fun myFragment(): MyFragment

    @ContributesAndroidInjector
    @ActivityScope
    internal abstract fun mainActivity(): MainActivity

}
