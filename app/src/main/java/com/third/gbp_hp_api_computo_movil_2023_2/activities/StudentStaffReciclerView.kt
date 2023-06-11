package com.third.gbp_hp_api_computo_movil_2023_2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.third.gbp_hp_api_computo_movil_2023_2.adapters.CharactersAdapter
import com.third.gbp_hp_api_computo_movil_2023_2.databinding.ActivityListReciclerViewBinding
import com.third.gbp_hp_api_computo_movil_2023_2.databinding.CharacterListBinding
import com.third.gbp_hp_api_computo_movil_2023_2.model.CharacterDetails
import com.third.gbp_hp_api_computo_movil_2023_2.network.PotterApi
import org.w3c.dom.CharacterData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StudentStaffReciclerView : AppCompatActivity() {
    private lateinit var binding: ActivityListReciclerViewBinding
    var listType = "students"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListReciclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val bundle = intent.extras
        if (bundle!=null) {
            listType = bundle!!.getString("Type").toString()
        }

        val call = retrofit.create(PotterApi::class.java)
            .getCharacterDetail(listType)

        call.enqueue(object: Callback<ArrayList<CharacterDetails>> {
            override fun onResponse(
                call: Call<ArrayList<CharacterDetails>>,
                response: Response<ArrayList<CharacterDetails>>
            ) {
                binding.pbConnection.visibility = View.GONE

                Log.d("RESPONSE", "RespuestaRecicler> ${response.toString()}")
                Log.d("RESPONSE", "DatosRecicler> ${response.body().toString()}")
                Log.d("TypeString", listType)
                binding.rvMenu.layoutManager = LinearLayoutManager(this@StudentStaffReciclerView)
                binding.rvMenu.adapter = CharactersAdapter(this@StudentStaffReciclerView, response.body()!!, {selectedCharacter: CharacterDetails -> profileClick(selectedCharacter)})
            }

            override fun onFailure(call: Call<ArrayList<CharacterDetails>>, t: Throwable) {
                binding.pbConnection.visibility = View.GONE
                Toast.makeText(this@StudentStaffReciclerView, "No hay conexión", Toast.LENGTH_SHORT)
            }
        })
    }

    private fun profileClick(characterDetails: CharacterDetails){
        val bundle = Bundle()


    }
}

