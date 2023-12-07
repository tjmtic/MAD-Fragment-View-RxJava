package com.kabbage.example.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kabbage.example.BaseFragment
import com.kabbage.example.R
import javax.inject.Inject

class TodoListFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: TodoViewModel

    private val adapter by lazy { TodoListAdapter() }
    private val todosObserver = Observer(::renderTodos)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = LayoutInflater.from(context).inflate(
        R.layout.fragment_todo_list,
        container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val todoListView = view.findViewById<RecyclerView>(R.id.todo_list)
        todoListView.adapter = adapter
        todoListView.layoutManager = LinearLayoutManager(requireContext())

        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            findNavController().navigate(R.id.action_todoListFragment_to_addItemFragment)
        }
        setupObservers()
        viewModel.fetchItems()
    }

    private fun setupObservers() = with(viewModel) {
        todos.observe(viewLifecycleOwner, todosObserver)
    }

    private fun renderTodos(todos: List<Todo>) {
        adapter.apply {
            todoList = todos
            notifyItemRangeChanged(0, todos.size)
        }
    }
}