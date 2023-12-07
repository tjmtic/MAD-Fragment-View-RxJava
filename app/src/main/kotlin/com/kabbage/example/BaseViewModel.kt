package com.kabbage.example

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    val composite = CompositeDisposable()
    override fun onCleared() {
        composite.clear()
        super.onCleared()
    }
}