package com.jay.mvvmtest.di

import com.jay.mvvmtest.MainSearchRecyclerViewAdapter
import com.jay.mvvmtest.viewModel.MainViewModel
import com.jay.mvvmtest.model.DataModel
import com.jay.mvvmtest.model.DataModelImpl
import com.jay.mvvmtest.model.service.AfcService
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

var retrofitPart = module {
    single<AfcService> {
        Retrofit.Builder()
            .baseUrl("http://bjapi.afreecatv.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AfcService::class.java)
    }
}

var adapterPart = module {
    factory {
        MainSearchRecyclerViewAdapter()
    }
}

var modelPart = module {
    factory<DataModel> {
        DataModelImpl(get())
    }
}

var viewModelPart = module {
    viewModel {
        MainViewModel(get())
    }
}

var myDiModule = listOf(retrofitPart, adapterPart, modelPart, viewModelPart)
