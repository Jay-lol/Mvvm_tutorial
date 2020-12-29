package com.jay.mvvmtest.view

import android.util.Log
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
    private val TAG: String = "로그"

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
        viewModel.afcSearchResponseLiveData.observe(this, Observer { x->
            for (it in x){
                Log.d(TAG, "MainActivity ~ initDataBinding() called ${it.station?.upd}")
                Log.d(TAG, "MainActivity ~ initDataBinding() called ${it.broad}")
                mainSearchRecyclerViewAdapter.addImage("http://liveimg.afreecatv.com/${it.broad?.broad_no}_480x270.jpg?dummy=1")
            }
            mainSearchRecyclerViewAdapter.notifyDataSetChanged()
        })
    }

    override fun initAfterBinding() {
        main_activity_search_button.setOnClickListener {
            Log.d(TAG, "MainActivity ~ initAfterBinding() called")
            val list = listOf("roket0829","khm11903","yuambo", "1000song2",
                    "agi1e2shine5",
                    "boli1125",
                    "cndmsqls0901",
                    "duswn8243",
                    "godson327",
                    "jck17523",
                    "kawa2mj",
                    "kimpocinema",
                    "kxdpn1gla1",
                    "mjhdjddk77",
                    "skygkrtn",
                    "starlight20",
                    "superbsw123",
                    "tarosak",
                    "todakman1151",
                    "tprtmgjsxi",
                    "vlfvlf789",
                    "wlsrl2566",
                    "zkdnlwm")
            viewModel.getBjListSearch(list)
//            viewModel.getBjSearch(main_activity_search_text_view.text.toString())
        }
    }

}