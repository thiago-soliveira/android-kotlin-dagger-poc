package dagger.poc.android.presentation

import dagger.android.support.AndroidSupportInjection
import dagger.poc.android.R
import dagger.poc.android.common.BaseFragment
import javax.inject.Inject

class SomeFragment : BaseFragment() {

    @Inject
    lateinit var presenter : SomePresenter

    override fun inject() {
        AndroidSupportInjection.inject(this)
    }

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: android.view.LayoutInflater?,
                              container: android.view.ViewGroup?,
                              savedInstanceState: android.os.Bundle?): android.view.View? {
        return inflater!!.inflate(R.layout.fragment_my, container, false)
    }

    override fun onResume() {
        super.onResume()
        presenter.execSomeTask()
    }

}
