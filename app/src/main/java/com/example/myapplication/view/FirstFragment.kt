package com.example.myapplication.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentFirstBinding
import com.example.myapplication.viewModel.CountViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val countViewModel: CountViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }


        countViewModel.getMutableLiveData().observe(viewLifecycleOwner, Observer { item ->
            // Perform an action with the latest item data.

            Log.i("MyApp","Received " + item)
            Toast.makeText(view.context,"Received " + item,Toast.LENGTH_LONG).show()
            binding.textviewFirst.text = "Count $item" // "count " + item

        })


        binding.incrementButton.setOnClickListener {
            countViewModel.increment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}