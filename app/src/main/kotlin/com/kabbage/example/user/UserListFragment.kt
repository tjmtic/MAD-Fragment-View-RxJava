package com.kabbage.example.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kabbage.example.BaseFragment
import com.kabbage.example.R
import javax.inject.Inject

class UserListFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: UserViewModel
    private val usersObserver = Observer(::renderUsers)

    private val adapter by lazy { UserListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = LayoutInflater.from(context).inflate(
        R.layout.fragment_user_list,
        container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userListView = view.findViewById<RecyclerView>(R.id.user_list)
        userListView.adapter = adapter
        userListView.layoutManager = LinearLayoutManager(requireContext())

        setupObservers()
        viewModel.fetchUsers()

        view.findViewById<Button>(R.id.refresh_button).setOnClickListener {
            viewModel.fetchUsers()
        }
    }

    private fun setupObservers() = with(viewModel) {
        users.observe(viewLifecycleOwner, usersObserver)
    }

    private fun renderUsers(users: List<User>) {
        adapter.apply {
            userList = users
            notifyItemRangeChanged(0, users.size)
        }
    }
}