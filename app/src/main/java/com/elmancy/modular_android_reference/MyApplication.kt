package com.elmancy.modular_android_reference

import android.app.Application
import com.elmancy.caching.di.StorageModule
import com.elmancy.feature.auth.di.AuthModule
import com.elmancy.feature.jsonplaceholderService.di.JsonPlaceholderModule
import com.elmancy.modular_android_reference.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(
                StorageModule().module,
                AppModule().module,
                AuthModule().module,
                JsonPlaceholderModule().module
            )
        }
    }
}