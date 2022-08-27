package com.example.bookapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp.R
import com.example.bookapp.data.Bookload
import com.example.bookapp.model.Book
import com.example.bookapp.ui.BookListFragment
import com.example.bookapp.ui.BookListFragmentDirections

class BookAdapter():RecyclerView.Adapter<BookAdapter.BookViewHolder>() {//End BookAdapter

    private val BookSet:List<Book> = Bookload()

  class BookViewHolder(private val view: View):RecyclerView.ViewHolder(view){
      val imageView:ImageView = view.findViewById(R.id.Book_image)
  }//End BookViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
       val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return BookViewHolder(layout)
    }



    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val item = BookSet[position]
        holder.imageView.setImageResource(item.imageID)

        holder.imageView.setOnClickListener {
             val action = BookListFragmentDirections.actionBookListFragmentToBookDetailsFragment(item.imageID.toString())
            holder.itemView.findNavController().navigate(action)
        }


    }

    override fun getItemCount() = BookSet.size


}