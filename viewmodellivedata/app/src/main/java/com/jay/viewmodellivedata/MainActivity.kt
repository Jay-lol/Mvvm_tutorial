package com.jay.viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jay.viewmodellivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        settingAdapter()

        viewModel.counter.observe(this, Observer {
            Log.d(TAG, "MainActivity ~ observe() $it called")
            viewModel.updateFollow(it)
        })
    }

    private fun settingAdapter() {
        val userDataList: ArrayList<UserDataList> = ArrayList()
        userDataList.add(UserDataList("e0eun_qt", "이영은", false))
        userDataList.add(UserDataList("iiveryi", "정성훈", false))
        userDataList.add(UserDataList("deep_shining_", "최석준", false))
        userDataList.add(UserDataList("g_yyuu_", "임규민", false))
        userDataList.add(UserDataList("seo._.6", "김서준", false))
        userDataList.add(UserDataList("ttingho812", "추명호", false))
        userDataList.add(UserDataList("sun_nowplaying", "김혜선", false))
        userDataList.add(UserDataList("0_haribro", "오하형", false))
        userDataList.add(UserDataList("wonbin622", "김원빈", false))
        userDataList.add(UserDataList("yang.0626", "양동욱", false))
        userDataList.add(UserDataList("galpos3_", "이수민", false))
        val adapter = UserAdapter(userDataList , viewModel)
        binding.recyclerView.adapter = adapter
    }
}