package com.kabbage.example.dagger

import com.kabbage.example.BuildConfig
import com.kabbage.example.todo.TodoService
import com.kabbage.example.todo.TodoViewModel
import com.kabbage.example.user.UserService
import com.kabbage.example.user.UserViewModel
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideTodoViewModel(todoService: TodoService): TodoViewModel =
        TodoViewModel(todoService)

    @Provides
    internal fun provideTodoService(retrofit: Retrofit): TodoService =
        retrofit.create(TodoService::class.java)

    @Provides
    @Singleton
    internal fun provideUserViewModel(userService: UserService): UserViewModel =
        UserViewModel(userService)

    @Provides
    internal fun provideUserService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)

    @Provides
    @Singleton
    internal fun provideRetrofit(
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .build()
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        return clientBuilder.build()
    }

    @Provides
    @Singleton
    internal fun provideMoshi(): Moshi = Moshi.Builder().build()
}