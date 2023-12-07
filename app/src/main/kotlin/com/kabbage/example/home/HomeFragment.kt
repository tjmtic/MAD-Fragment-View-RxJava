package com.kabbage.example.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.kabbage.example.BaseFragment
import com.kabbage.example.R

class HomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = LayoutInflater.from(context).inflate(
        R.layout.fragment_home,
        container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.users_button).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_user_graph)
        }

        view.findViewById<Button>(R.id.todos_button).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_todo_graph)
        }
    }
}