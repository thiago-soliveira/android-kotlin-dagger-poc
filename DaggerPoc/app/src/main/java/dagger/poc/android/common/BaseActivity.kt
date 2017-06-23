package dagger.poc.android.common

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by Thiago on 6/12/2017.
 */

abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()

        super.onCreate(savedInstanceState)
    }

    abstract fun inject()
}