package dagger.poc.android.common

/**
 * Created by Thiago on 6/14/2017.
 */

abstract class BaseFragment : dagger.android.support.DaggerFragment() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        inject()

        super.onCreate(savedInstanceState)
    }

    abstract fun inject()

}