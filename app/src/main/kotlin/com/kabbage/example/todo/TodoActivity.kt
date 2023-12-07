package com.kabbage.example.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kabbage.example.R

class TodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}