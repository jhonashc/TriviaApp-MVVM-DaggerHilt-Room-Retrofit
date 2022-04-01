package com.multi.trivia.ui.quiz.results

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.multi.trivia.R
import com.multi.trivia.databinding.FragmentResultsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultsFragment : Fragment() {

    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!

    private val args: ResultsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val result = args.result

        binding.result = result

        binding.btnPlayAgain.setOnClickListener {
//            val action = ResultsFragmentDirections.actionResultsFragmentToHomeFragment()
            findNavController().navigate(R.id.action_resultsFragment_to_homeFragment)
        }

        binding.tvGetOut.setOnClickListener {
            val action = ResultsFragmentDirections.actionResultsFragmentToWelcomeFragment()
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}