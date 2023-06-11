package com.third.gbp_hp_api_computo_movil_2023_2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.third.gbp_hp_api_computo_movil_2023_2.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pbConnectionMenu.visibility = View.GONE
    }

    fun clickStudents(view: View){
        val intent = Intent(this, StudentStaffReciclerView::class.java)
        val listType = Bundle()
        listType.putString("Type", "students")
        intent.putExtras(listType)
        startActivity(intent)
    }

    fun clickStaff(view: View){
        val intent = Intent(this, StudentStaffReciclerView::class.java)
        val listType = Bundle()
        listType.putString("Type", "staff")
        intent.putExtras(listType)
        startActivity(intent)
    }

}

