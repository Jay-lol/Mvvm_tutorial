package com.jay.mvvmtest.view

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.jay.mvvmtest.BaseKotlinActivity
import com.jay.mvvmtest.MainSearchRecyclerViewAdapter
import com.jay.mvvmtest.R
import com.jay.mvvmtest.databinding.ActivityMainBinding
import com.jay.mvvmtest.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseKotlinActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutResourceId: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel by viewModel()

    private val mainSearchRecyclerViewAdapter : MainSearchRecyclerViewAdapter by inject()

    override fun initStartView() {
        main_activity_search_recycler_view.run {
            adapter = mainSearchRecyclerViewAdapter
            layoutManager = StaggeredGridLayoutManager(3, 1).apply {
                gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
                orientation = StaggeredGridLayoutManager.VERTICAL
            }
            setHasFixedSize(true)
        }
    }

    override fun initDataBinding() {
        viewModel.afcSearchResponseLiveData.observe(this, Observer {
            mainSearchRecyclerViewAdapter.addImage("http://liveimg.afreecatv.com/229095284_480x270.jpg?dummy=1")
            mainSearchRecyclerViewAdapter.notifyDataSetChanged()
        })
    }

    override fun initAfterBinding() {
        main_activity_search_button.setOnClickListener {
            viewModel.getBjSearch(main_activity_search_text_view.text.toString())
        }
    }

}