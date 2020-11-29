package com.jassemdev.android.plants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jassemdev.android.plants.home.HomeFragment

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.screen_container, HomeFragment())
                .commit()
        }
    }
}