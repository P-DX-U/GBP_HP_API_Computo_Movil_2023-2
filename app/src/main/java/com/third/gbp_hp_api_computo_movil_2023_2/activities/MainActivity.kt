package com.third.gbp_hp_api_computo_movil_2023_2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val call = retrofit.create(PotterApi::class.java)
            .getCharacterDetail("9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8")

        call.enqueue(object: Callback<ArrayList<CharacterDetails>> {
            override fun onResponse(
                call: Call<ArrayList<CharacterDetails>>,
                response: Response<ArrayList<CharacterDetails>>
            ) {
                binding.pbConnectionMenu.visibility = View.GONE

                Log.d("RESPONSE", "Respuesta> ${response.toString()}")
                Log.d("RESPONSE", "Datos> ${response.body().toString()}")


            }

            override fun onFailure(call: Call<ArrayList<CharacterDetails>>, t: Throwable) {
                binding.pbConnectionMenu.visibility = View.GONE
                Toast.makeText(this@MainActivity, "No hay conexión", Toast.LENGTH_SHORT)
            }


        })
    }
}

