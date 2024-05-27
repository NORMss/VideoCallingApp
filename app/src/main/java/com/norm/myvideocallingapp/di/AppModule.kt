package com.norm.myvideocallingapp.di

import com.norm.myvideocallingapp.VideoCallingApp
import com.norm.myvideocallingapp.connect.ConnectViewModel
import com.norm.myvideocallingapp.video.VideoCallViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    factory {
        val app = androidContext().applicationContext as VideoCallingApp
        app.client
    }

    viewModelOf(::ConnectViewModel)
    viewModelOf(::VideoCallViewModel)
}