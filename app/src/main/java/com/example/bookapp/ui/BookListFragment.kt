package com.example.bookapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp.R
import com.example.bookapp.adapter.BookAdapter
import com.example.bookapp.databinding.FragmentBookListBinding


class BookListFragment : Fragment() {

    private var _binding : FragmentBookListBinding? = null
    private val binding get() =_binding!!

    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookListBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        recyclerView.adapter = BookAdapter()
        recyclerView.layoutManager = GridLayoutManager(context,2)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}