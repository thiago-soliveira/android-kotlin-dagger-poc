package dagger.poc.android

import android.content.SharedPreferences
import dagger.android.AndroidInjection
import dagger.poc.android.common.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var preferences: SharedPreferences

    override fun inject() {
        AndroidInjection.inject(this)
    }

    private var mTextMessage: android.widget.TextView? = null

    private val mOnNavigationItemSelectedListener = android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            dagger.poc.android.R.id.navigation_home -> {
                mTextMessage!!.setText(dagger.poc.android.R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            dagger.poc.android.R.id.navigation_dashboard -> {
                mTextMessage!!.setText(dagger.poc.android.R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            dagger.poc.android.R.id.navigation_notifications -> {
                mTextMessage!!.setText(dagger.poc.android.R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(dagger.poc.android.R.layout.activity_main)

        var selectedFragment: android.support.v4.app.Fragment = MyFragment()
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(dagger.poc.android.R.id.frame_layout, selectedFragment)
        transaction.commit()

        preferences.edit().putBoolean("test", true).apply()

    }
}
