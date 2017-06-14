package dagger.poc.android.common

import android.os.Bundle
import dagger.android.support.DaggerFragment

/**
 * Created by Thiago on 6/14/2017.
 */
open abstract class BaseFragment : dagger.android.support.DaggerFragment() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        inject()

        super.onCreate(savedInstanceState)
    }

    abstract fun inject()

}