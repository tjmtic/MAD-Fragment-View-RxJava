package com.kabbage.example.dagger

import android.content.Context
import com.kabbage.example.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    AppInjectorModule::class
])
interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}