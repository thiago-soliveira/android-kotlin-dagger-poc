package dagger.poc.android.common

/**
 * Created by Thiago on 6/14/2017.
 */

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by Thiago on 6/12/2017.
 */
open abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()

        super.onCreate(savedInstanceState)
    }

    abstract fun inject()
}