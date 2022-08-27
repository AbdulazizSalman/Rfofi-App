package com.example.bookapp.data

import com.example.bookapp.R
import com.example.bookapp.model.Book




    fun Bookload():MutableList<Book>{
        return listOf(
            Book(R.string.title1,R.string.author1,R.string.date1,R.string.page1,R.drawable.pic1,R.string.about1,false,120.0),
            Book(R.string.title2,R.string.author2,R.string.date2,R.string.page2,R.drawable.pic2,R.string.about2,false,100.0),
            Book(R.string.title3,R.string.author3,R.string.date3,R.string.page3,R.drawable.pic3,R.string.about3,false,59.0),
            Book(R.string.title4,R.string.author4,R.string.date4,R.string.page4,R.drawable.pic4,R.string.about4,false,32.0),
            Book(R.string.title5,R.string.author5,R.string.date5,R.string.page5,R.drawable.pic5,R.string.about5,false,110.0),
            Book(R.string.title6,R.string.author6,R.string.date6,R.string.page6,R.drawable.pic6,R.string.about6,false,150.0),
            Book(R.string.title7,R.string.author7,R.string.date7,R.string.page7,R.drawable.pic7,R.string.about7,false,55.0),
            Book(R.string.title8,R.string.author8,R.string.date8,R.string.page8,R.drawable.pic8,R.string.about8,false,40.0),
            Book(R.string.title9,R.string.author9,R.string.date9,R.string.page9,R.drawable.pic9,R.string.about9,false,90.0),
            Book(R.string.title10,R.string.author10,R.string.date10,R.string.page10,R.drawable.pic10,R.string.about10,false,79.0)
        ) as MutableList<Book>

    }
