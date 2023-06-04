package com.third.gbp_hp_api_computo_movil_2023_2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.third.gbp_hp_api_computo_movil_2023_2.adapters.CharactersAdapter
import com.third.gbp_hp_api_computo_movil_2023_2.databinding.ActivityListReciclerViewBinding
import com.third.gbp_hp_api_computo_movil_2023_2.databinding.ActivityMainBinding
import com.third.gbp_hp_api_computo_movil_2023_2.model.CharacterDetails
import com.third.gbp_hp_api_computo_movil_2023_2.network.PotterApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var binding2: ActivityListReciclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding2 = ActivityListReciclerViewBinding.inflate(layoutInflater)
        setContentView(binding2.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val call = retrofit.create(PotterApi::class.java)
            .getCharacterDetail("students")

        call.enqueue(object: Callback<ArrayList<CharacterDetails>> {
            override fun onResponse(
                call: Call<ArrayList<CharacterDetails>>,
                response: Response<ArrayList<CharacterDetails>>
            ) {
                binding2.pbConnection.visibility = View.GONE

                Log.d("RESPONSE", "RespuestaRecicler> ${response.toString()}")
                Log.d("RESPONSE", "DatosRecicler> ${response.body().toString()}")
                binding2.rvMenu.layoutManager = LinearLayoutManager(this@MainActivity)
                binding2.rvMenu.adapter = CharactersAdapter(this@MainActivity, response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<CharacterDetails>>, t: Throwable) {
                binding2.pbConnection.visibility = View.GONE
                Toast.makeText(this@MainActivity, "No hay conexión", Toast.LENGTH_SHORT)
            }


        })
    }



}

