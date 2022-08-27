package com.example.bookapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import com.example.bookapp.R
import com.example.bookapp.databinding.FragmentPdfBookBinding
import com.example.bookapp.model.BookViewModel
import com.github.barteksc.pdfviewer.PDFView


class PdfBookFragment : Fragment() {
    lateinit var pdfview: PDFView
    private var _binding : FragmentPdfBookBinding? = null
    private val binding get() =_binding!!
    private val sharedViewModel : BookViewModel by activityViewModels()
    private lateinit var bookName:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =FragmentPdfBookBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pdfview = binding.pdfView

        chooseBook(sharedViewModel.bookName.value)

    }

     fun chooseBook(BookName:String?){
        when(BookName){
            getString(R.string.title1) ->  pdfview.fromAsset("book1.pdf").load()
            getString(R.string.title2) ->  pdfview.fromAsset("book2.pdf").load()
            getString(R.string.title3) ->  pdfview.fromAsset("book3.pdf").load()
            getString(R.string.title4) ->  pdfview.fromAsset("book4.pdf").load()
            getString(R.string.title5) ->  pdfview.fromAsset("book5.pdf").load()
            getString(R.string.title6) ->  pdfview.fromAsset("book6.pdf").load()
            getString(R.string.title7) ->  pdfview.fromAsset("book7.pdf").load()
            getString(R.string.title8) ->  pdfview.fromAsset("book8.pdf").load()
            getString(R.string.title9) ->  pdfview.fromAsset("book9.pdf").load()
            getString(R.string.title10) ->  pdfview.fromAsset("book10.pdf").load()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}