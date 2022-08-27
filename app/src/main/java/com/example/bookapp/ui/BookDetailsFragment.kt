package com.example.bookapp.ui

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bookapp.R
import com.example.bookapp.data.Bookload
import com.example.bookapp.databinding.FragmentBookDetailsBinding
import com.example.bookapp.model.Book
import com.example.bookapp.model.BookViewModel
import com.klinker.android.link_builder.Link
import com.klinker.android.link_builder.applyLinks

class BookDetailsFragment : Fragment() {
    private var _binding : FragmentBookDetailsBinding? = null
    private val binding get() =_binding!!
    private val sharedViewModel : BookViewModel by activityViewModels()
    private lateinit var imageId:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      _binding = FragmentBookDetailsBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            detailsFragment = this@BookDetailsFragment
        }
         imageId = arguments?.get("imageId").toString()
        setData(imageId)
        setImage()
        sharedViewModel.setTextOfButton()
       linkSetUp()

    }

    fun setData(imageId:String){
        for(i in sharedViewModel.BookList){
            if(i.imageID.toString() == imageId){
                sharedViewModel.setBookName(getString(i.titleId))
                sharedViewModel.setAuthorName(getString(i.authorId))
                sharedViewModel.setDate(getString(i.dateId))
                sharedViewModel.setPage(getString(i.pageId))
                sharedViewModel.setImageId(i.imageID)
                sharedViewModel.setAbout(getString(i.aboutId))
                sharedViewModel.setPrice(i.price)
            }
        }
    }

    fun setImage(){
        binding.imageBookDetails.setImageResource(sharedViewModel.imageId.value!!)
    }

    fun onClickButton(){
        var stateOfBook:Boolean =false
        for(i in sharedViewModel.BookList){
            if(getString(i.titleId) == sharedViewModel.bookName.value)
                stateOfBook = i.stateOfBook
        }
        if (stateOfBook){

            findNavController().navigate(R.id.action_bookDetailsFragment_to_pdfBookFragment)
        }
        else
            findNavController().navigate(R.id.action_bookDetailsFragment_to_bookBillFragment)
    }

    fun linkSetUp(){
        val googleLink = Link("google it")
            .setTextColor(Color.WHITE)
            .setTextColorOfHighlightedLink(Color.CYAN)
            .setHighlightAlpha(.4f)
            .setUnderlined(true)
            .setBold(true)
        binding.googleLink.applyLinks(googleLink)
    }

    fun onClickText(){
        val Link = getString(R.string.LinkOfBook)
        val link: Uri = Uri.parse("${Link}${sharedViewModel.bookName.value}")
        val intent = Intent(Intent.ACTION_VIEW,link)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}