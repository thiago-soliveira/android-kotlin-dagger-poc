package dagger.poc.android.common

import android.os.Bundle
import dagger.android.support.DaggerFragment

/**
 * Created by Thiago on 6/14/2017.
 */

abstract class BaseFragment : DaggerFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()

        super.onCreate(savedInstanceState)
    }

    abstract fun inject()

}