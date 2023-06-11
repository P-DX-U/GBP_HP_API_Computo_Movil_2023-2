package com.third.gbp_hp_api_computo_movil_2023_2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.third.gbp_hp_api_computo_movil_2023_2.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}