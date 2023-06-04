package com.third.gbp_hp_api_computo_movil_2023_2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.third.gbp_hp_api_computo_movil_2023_2.activities.list_reciclerView
import com.third.gbp_hp_api_computo_movil_2023_2.databinding.ActivityListReciclerViewBinding
import com.third.gbp_hp_api_computo_movil_2023_2.databinding.CharacterListBinding
import com.third.gbp_hp_api_computo_movil_2023_2.model.CharacterDetails

class CharactersAdapter(private var context: Context, private var characters: ArrayList<CharacterDetails>): RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {
    class ViewHolder(view: CharacterListBinding): RecyclerView.ViewHolder(view.root){
        var ivThumbnail = view.ivThumbnail
        var tvName = view.tvName
        var tvActor = view.tvActor
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CharacterListBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(characters[position].image)
            .into(holder.ivThumbnail)
        holder.itemView.setOnClickListener{
        }
        holder.tvName.text = characters[position].name
        holder.tvActor.text = characters[position].actor

    }

    override fun getItemCount(): Int = characters.size
    }


