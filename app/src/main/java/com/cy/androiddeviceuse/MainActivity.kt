package com.cy.androiddeviceuse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cy.androiddeviceuse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShake.setOnClickListener {
            startActivity(Intent(MainActivity@this, ShakeActivity::class.java))
        }
    }

}