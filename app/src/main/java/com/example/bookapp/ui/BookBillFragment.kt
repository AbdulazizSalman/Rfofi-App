package com.example.bookapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bookapp.R
import com.example.bookapp.databinding.FragmentBookBillBinding
import com.example.bookapp.model.BookViewModel


class BookBillFragment : Fragment() {
    private var _binding : FragmentBookBillBinding? = null
    private val binding get() =_binding!!
    private val sharedViewModel : BookViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookBillBinding.inflate(inflater,container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
            billFragment = this@BookBillFragment
        }

    }

    fun onClickPay(){
        Toast.makeText(activity,"Thanks for your purchase",Toast.LENGTH_SHORT).show()
        sharedViewModel.stateOfBook()
        sharedViewModel.setTextOfButton()
        findNavController().navigate(R.id.action_bookBillFragment_to_bookListFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}