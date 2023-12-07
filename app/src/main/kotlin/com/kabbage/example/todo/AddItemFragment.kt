package com.kabbage.example.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.kabbage.example.BaseFragment
import com.kabbage.example.R
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class AddItemFragment : BaseFragment(), HasAndroidInjector {

    @Inject
    lateinit var todoViewModel: TodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = LayoutInflater.from(context).inflate(
        R.layout.fragment_add_item,
        container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with (view) {
            findViewById<Button>(R.id.add_item_button).setOnClickListener {
                // TODO validation of some kind?
                todoViewModel.addItem(findViewById<EditText>(R.id.add_item_text).text.toString())
                findNavController().popBackStack()
            }
        }
    }

}