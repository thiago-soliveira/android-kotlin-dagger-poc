package dagger.poc.android.presentation

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import dagger.poc.android.R

class MainActivity : dagger.poc.android.common.BaseActivity() {

    @javax.inject.Inject
    lateinit var preferences: android.content.SharedPreferences

    override fun inject() {
        dagger.android.AndroidInjection.inject(this)
    }

    private var mTextMessage: android.widget.TextView? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                mTextMessage!!.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                mTextMessage!!.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                mTextMessage!!.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(dagger.poc.android.R.layout.activity_main)

        var selectedFragment: Fragment = SomeFragment()
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(dagger.poc.android.R.id.frame_layout, selectedFragment)
        transaction.commit()

        preferences.edit().putBoolean("test", true).apply()

    }
}
