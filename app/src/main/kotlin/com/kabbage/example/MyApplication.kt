package com.kabbage.example

import android.app.Application
import android.os.StrictMode
import com.kabbage.example.dagger.AppComponent
import com.kabbage.example.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.reactivex.plugins.RxJavaPlugins
import timber.log.Timber
import javax.inject.Inject


class MyApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    internal lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        applicationInjector().inject(this)
        if (BuildConfig.DEBUG) {
            StrictMode.enableDefaults()
            Timber.plant(Timber.DebugTree())
        }
        RxJavaPlugins.setErrorHandler {
            Timber.w(it, "Unhandled exception received")
        }
    }

    private fun applicationInjector(): AndroidInjector<MyApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    override fun androidInjector() = AndroidInjector<Any> {
        dispatchingAndroidInjector.inject(it)
    }
}