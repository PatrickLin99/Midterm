package com.patrick.midterm

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class MainViewModel() : ViewModel() {

    val dataReturn = MutableLiveData<String>()

//    val dataResult = MutableLiveData<PersonItem>()

    val info = MutableLiveData<List<Info>>()
    val author = MutableLiveData<String>()
    val content = MutableLiveData<String>()
    val createdTime = MutableLiveData<Long>()
    val id = MutableLiveData<String>()
    val tag = MutableLiveData<String>()
    val title =  MutableLiveData<String>()

    val mutableLivedata = MutableLiveData<MutableList<Info>>()
    val ii= mutableListOf<Info>()


    var db = FirebaseFirestore.getInstance()

    init {
        readData()
//        readDataTest()
    }

    fun readData() {
        db.collection("articles")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        Log.d("FragmentActivity", document.id + " => " + document.data)

                        author.value = document.getString("author.name")
                        content.value = document.getString("content")
                        createdTime.value = document.getLong("createdTime")
                        id.value = document.getString("id")
                        tag.value = document.getString("tag")
                        title.value = document.getString("title")
                        Log.d("test","$${title.value} ${author.value} ${content.value} ${createdTime.value} ${id.value}")

                        val qq = Info("${author.value}","${content.value}","${createdTime.value}","${id.value}","${tag.value}","${title.value}")

                        ii.add(qq)
                        mutableLivedata.value = ii

                        Log.d("test","$qq")


                    }
                } else {
                    Log.w("FragmentActivity", "Error getting documents.", task.exception)
                }
            }
    }

//    fun readDataTest(){
//
//        db.collection("articles")
//            .document("info")
//            .get()
//            .addOnSuccessListener { document ->
//                try {
//                    if (document != null) {
//
//                        document.toObject(InfoList::class.java) ?: InfoList()
//
//
//                        Log.d("test","${InfoList()}")
//
//
//                    } else {
//
//                    }
//                }catch (ex: Exception){
//                    Log.e(TAG, ex.message)
//                }
//            }.addOnFailureListener {
//                    e -> Log.e(TAG, "Error writing document", e)
//            }
//
//    }


}