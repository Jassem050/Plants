package com.jassemdev.android.plants.home

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.memory.MemoryCache
import com.google.android.flexbox.*
import com.jassemdev.android.plants.*
import com.jassemdev.android.plants.R
import com.jassemdev.android.plants.data.DefaultPlantsRepository
import com.jassemdev.android.plants.data.getPlantsService
import com.jassemdev.android.plants.data.source.remote.PlantsRemoteDataSource
import com.jassemdev.android.plants.databinding.FragmentHomeBinding
import com.jassemdev.android.plants.detail.DetailsFragment
import com.jassemdev.android.plants.di.viewmodel.AppViewModelFactory
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG = "HomeFragment"


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentHomeBinding

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        binding.plantList.apply{
            adapter = PlantsListAdapter { plant ->
                parentFragmentManager.beginTransaction()
                    .replace(R.id.screen_container, DetailsFragment.newInstance(plant))
                    .addToBackStack(null)
                    .commit()
            }
            layoutManager = FlexboxLayoutManager(context).apply {
                flexDirection = FlexDirection.ROW
                flexWrap = FlexWrap.WRAP
                justifyContent = JustifyContent.SPACE_EVENLY
            }
        }


        viewModel.data.observe(viewLifecycleOwner, Observer { plants ->
            (binding.plantList.adapter as PlantsListAdapter).setPlantItems(plants)
        })

        return binding.root
    }

    override fun onAttach(context: Context) {
        (requireActivity().applicationContext as PlantsApplication)
            .applicationComponent.inject(this)
        super.onAttach(context)
    }
}