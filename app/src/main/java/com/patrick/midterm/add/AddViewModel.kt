package com.patrick.midterm.add

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class AddViewModel() : ViewModel() {

    val author = MutableLiveData<String>()
    val content = MutableLiveData<String>()
    val createdTime = MutableLiveData<Long>()
    val id = MutableLiveData<String>()
    val tag = MutableLiveData<String>()
    val title =  MutableLiveData<String>()

    init {
        addData()
    }


    fun addData() {
        val articles = FirebaseFirestore.getInstance()
            .collection("articles")
        val document = articles.document()
        val data = hashMapOf(
            "author" to hashMapOf(
                "email" to "wayne@school.appworks.tw",
                "id" to "waynechen323",
                "name" to "AKA小安老師"
            ),
            "title" to "${title.value}",
            "content" to "${content.value}",
            "createdTime" to Calendar.getInstance()
                .timeInMillis,
            "id" to document.id,
            "tag" to "${tag.value}"
        )
        Log.d("test","$articles $document $data")
        document.set(data)
    }


}