package com.kabbage.example.dagger

import com.kabbage.example.home.HomeFragment
import com.kabbage.example.todo.AddItemFragment
import com.kabbage.example.todo.TodoListFragment
import com.kabbage.example.user.UserListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppInjectorModule {

    @ContributesAndroidInjector
    internal abstract fun contributesHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    internal abstract fun contributesTodoListFragment(): TodoListFragment

    @ContributesAndroidInjector
    internal abstract fun contributesAddItemFragment(): AddItemFragment

    @ContributesAndroidInjector
    internal abstract fun contributesUserListFragment(): UserListFragment
}