package com.example.bookapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapp.data.Bookload

class BookViewModel:ViewModel() {

    var BookList:MutableList<Book> = Bookload()

    private val _bookName = MutableLiveData<String>()
    val bookName:LiveData<String> = _bookName

    private val _ahutorName = MutableLiveData<String>()
    val ahutorName:LiveData<String> = _ahutorName

    private val _date = MutableLiveData<String>()
    val date :LiveData<String> = _date

    private val _page = MutableLiveData<String>()
    val page:LiveData<String> = _page

    private val _imageId = MutableLiveData<Int>()
    val imageId:LiveData<Int> = _imageId

    private val _about = MutableLiveData<String>()
    val about:LiveData<String> = _about

    private val _price = MutableLiveData<Double>()
    val price:LiveData<Double> = _price

    private val _textOfButton = MutableLiveData<String>()
    val textOfButton:LiveData<String> = _textOfButton




    fun setBookName(bookName:String){
        _bookName.value=bookName
    }
    fun setAuthorName(AuthorName:String){
        _ahutorName.value = AuthorName
    }
    fun setDate(date:String){
        _date.value = date
    }
    fun setPage(page:String){
        _page.value = page
    }
    fun setImageId(imageId:Int){
        _imageId.value = imageId
    }
    fun setAbout(about:String){
        _about.value=about
    }
    fun setPrice(price:Double){
        _price.value = price
    }

    fun stateOfBook(){
        for(i in BookList){
            if (i.imageID == _imageId.value)
                i.stateOfBook = true
        }
    }

    fun setTextOfButton(){
        for(i in BookList){
            if (i.imageID == _imageId.value){
                if(i.stateOfBook)
                    _textOfButton.value="اقرا الكتاب"
                else
                    _textOfButton.value="اشتر الكتاب"

            }

        }

    }
}