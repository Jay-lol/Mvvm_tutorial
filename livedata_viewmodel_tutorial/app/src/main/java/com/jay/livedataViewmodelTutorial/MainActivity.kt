package com.jay.livedataViewmodelTutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jay.livedataViewmodelTutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_keyboard_backspace_24)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        settingAdapter()

        viewModel.counter.observe(this, Observer {
            viewModel._following.setValue("팔로잉 " + it + "명")
        })
    }

    private fun settingAdapter() {
        val userDataList: ArrayList<UserDataList> = ArrayList()
        userDataList.add(UserDataList("e0eun_qt", "이영은"))
        userDataList.add(UserDataList("iiveryi", "정성훈"))
        userDataList.add(UserDataList("deep_shining_", "최석준"))
        userDataList.add(UserDataList("g_yyuu_", "임규민"))
        userDataList.add(UserDataList("seo._.6", "김서준"))
        userDataList.add(UserDataList("ttingho812", "추명호"))
        userDataList.add(UserDataList("sun_nowplaying", "김혜선"))
        userDataList.add(UserDataList("0_haribro", "오하형"))
        userDataList.add(UserDataList("wonbin622", "김원빈"))
        userDataList.add(UserDataList("yang.0626", "양동욱"))
        userDataList.add(UserDataList("galpos3_", "이수민"))
        val adapter = UserAdapter(applicationContext, userDataList)
        binding.recyclerView.adapter = adapter
    }
}