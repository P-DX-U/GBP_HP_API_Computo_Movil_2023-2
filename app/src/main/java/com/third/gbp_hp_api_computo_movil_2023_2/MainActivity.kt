package com.third.gbp_hp_api_computo_movil_2023_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.third.gbp_hp_api_computo_movil_2023_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}