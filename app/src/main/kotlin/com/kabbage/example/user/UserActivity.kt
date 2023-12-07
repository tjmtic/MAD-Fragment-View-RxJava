package com.kabbage.example.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kabbage.example.R

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}