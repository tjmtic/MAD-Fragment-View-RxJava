package com.kabbage.example.user

import androidx.lifecycle.MutableLiveData
import com.kabbage.example.BaseViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val userService: UserService
) : BaseViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: MutableLiveData<List<User>> get() = _users

    fun fetchUsers() = userService.getUsers()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .onErrorResumeNext {
            Timber.e(it)
            Single.just(emptyList())
        }
        .subscribe { users: List<User> -> _users.postValue(users) }
        .addTo(composite)
}