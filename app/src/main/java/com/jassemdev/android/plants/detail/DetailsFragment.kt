package com.jassemdev.android.plants.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.annotation.ExperimentalCoilApi
import coil.load
import coil.size.Scale
import coil.transition.CrossfadeTransition
import com.jassemdev.android.plants.R
import com.jassemdev.android.plants.data.getPlantsService
import com.jassemdev.android.plants.data.model.Plant
import com.jassemdev.android.plants.databinding.FragmentDetailsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val PLANT = "plantId"
private const val TAG = "DetailsFragment"
private const val IMG_URL = "imgByteArray"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel: DetailsViewModel

    private var plant: Plant? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            plant = it.getParcelable(PLANT)
        }
    }

    @ExperimentalCoilApi
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
//        val detailsRepository = DetailsRepository(getPlantsService())
//        val viewModelFactory = DetailsViewModelFactory(detailsRepository)
//        viewModel = ViewModelProvider(this, viewModelFactory)[DetailsViewModel::class.java]

        bindViews(plant)

        binding.detailTopAppBar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
        return binding.root
    }


    @ExperimentalCoilApi
    fun bindViews(plant: Plant?) {
        plant?.let { plantItem ->
            binding.detailToolbarImage.load(plantItem.imageUrl) {
                crossfade(true)
                placeholder(R.drawable.plant_placeholder)
                transition(CrossfadeTransition())
                scale(Scale.FILL)
            }
            binding.detailTopAppBar.title = plantItem.name
            binding.detailContent.apply {
                slugInfo.text = plantItem.slug
                scientificNameInfo.text = plantItem.scientificName
                yearInfo.text = plantItem.year
                bibliographyInfo.text = plantItem.bibliography
                authorInfo.text = plantItem.author
                familyNameInfo.text = plantItem.familyName
                familyInfo.text = plantItem.family
                genusInfo.text = plantItem.genus
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(plant: Plant) =
                DetailsFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(PLANT, plant)
                    }
                }
    }

}