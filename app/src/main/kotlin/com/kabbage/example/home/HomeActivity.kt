package com.kabbage.example.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kabbage.example.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}