package dagger.poc.android

import dagger.android.support.AndroidSupportInjection
import dagger.poc.android.common.BaseFragment
import javax.inject.Inject

class MyFragment : BaseFragment() {

    @Inject
    lateinit var presenter : SomePresenter

    override fun inject() {
        AndroidSupportInjection.inject(this)
    }

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: android.view.LayoutInflater?, container: android.view.ViewGroup?,
                              savedInstanceState: android.os.Bundle?): android.view.View? {
        return inflater!!.inflate(dagger.poc.android.R.layout.fragment_my, container, false)
    }

    override fun onResume() {
        super.onResume()
        presenter.execSomeTask()
    }

}