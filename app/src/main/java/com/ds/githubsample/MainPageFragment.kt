package com.ds.githubsample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton

/**
 * A simple [Fragment] subclass.
 */
class MainPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main_page, container, false)

        view.findViewById<MaterialButton>(R.id.click_me_btn).setOnClickListener {
            Toast.makeText(requireContext(), "Clicked!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_mainPageFragment_to_resultsFragment)
        }

        return view
    }


}
