package com.jassemdev.android.plants

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.drawToBitmap
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.jassemdev.android.plants.data.model.Plant
import com.jassemdev.android.plants.databinding.PlantItemBinding
import java.io.ByteArrayOutputStream

class PlantsListAdapter(
    private val onPlantItemClicked: (plant: Plant) -> Unit
): RecyclerView.Adapter<PlantsListAdapter.PlantsViewHolder>() {

    private val data: MutableList<Plant> = mutableListOf()

    fun setPlantItems(plants: List<Plant>) {
        data.clear()
        data.addAll(plants)
        notifyDataSetChanged()
    }

    class PlantsViewHolder(
        private val binding: PlantItemBinding,
        onPlantItemClicked: (plant: Plant) -> Unit): RecyclerView.ViewHolder(binding.root) {

        var plantItem: Plant? = null

        init {
            itemView.setOnClickListener {
                plantItem?.let { plant ->
                    onPlantItemClicked(plant)
                }
            }
        }

        fun bind(item: Plant) {
            this.plantItem = item
            binding.plantName.text = item.name
            binding.plantImage.load(item.imageUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantsViewHolder {
        val binding = PlantItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)

        return PlantsViewHolder(binding, onPlantItemClicked)
    }

    override fun onBindViewHolder(holder: PlantsViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}