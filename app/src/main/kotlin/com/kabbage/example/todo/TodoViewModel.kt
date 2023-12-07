package com.kabbage.example.todo

import androidx.lifecycle.MutableLiveData
import com.kabbage.example.BaseViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * See https://jsonplaceholder.typicode.com/guide/ for information regarding API contracts.
 */
class TodoViewModel @Inject constructor(
    private val todoService: TodoService
) : BaseViewModel() {

    private val _todos = MutableLiveData<List<Todo>>(emptyList())
    val todos: MutableLiveData<List<Todo>> get() = _todos

    /**
     * Performs GET operation to load content into list.
     */
    fun fetchItems() = todoService.getTodos()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .onErrorResumeNext {
            Timber.e(it)
            Single.just(emptyList())
        }
        .subscribe { todos: List<Todo> -> _todos.postValue(todos) }
        .addTo(composite)

    fun addItem(title: String) {
        // TODO Need a POST operation here to add an item to the list.
    }

    fun removeItem(index: Int) {
        // TODO Need a DELETE operation here to remove an item from the list.
    }
}