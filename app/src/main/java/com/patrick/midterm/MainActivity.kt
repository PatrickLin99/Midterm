package com.patrick.midterm

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.patrick.midterm.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.HashMap


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)}

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


//        binding.lifecycleOwner = this
//        binding.viewModel = viewModel
//
//        val adapter = MainAdapter()
//        binding.recyclerPublisher.adapter = adapter

//        viewModel.mutableLivedata.observe(this, androidx.lifecycle.Observer {
//            it?.let {
//                adapter.submitList(it)
//            }
//        })



//        var db = FirebaseFirestore.getInstance()
//
//        val user: MutableMap<String, Any> = HashMap()
//        user["first"] = "Alan"
//        user["middle"] = "Mathison"
//        user["last"] = "Turing"
//        user["born"] = 1912
//
//        // Create a new user with a first, middle, and last name
//        db.collection("users")
//            .add(user)
//            .addOnSuccessListener { documentReference ->
//            Log.d("FragmentActivity", "DocumentSnapshot added with ID: " + documentReference.id) }
//            .addOnFailureListener { e -> Log.w("FragmentActivity", "Error adding document", e) }
//
//        db.collection("users")
//            .get()
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    for (document in task.result!!) {
//                        Log.d("FragmentActivity", document.id + " => " + document.data)
//                    }
//                } else {
//                    Log.w("FragmentActivity", "Error getting documents.", task.exception)
//                }
//            }

//        viewModel.dataReturn.observe(this, androidx.lifecycle.Observer {
//            it?.let {
//                addData()
//                viewModel.readData()
//            }
//        })

//        floatingActionButton.setOnClickListener {
//            Log.d("click","click")
//            findNavController(R.id.nav_host_fragment).navigate(R.id.addFragment)
//        }


    }


    fun addData() {
        val articles = FirebaseFirestore.getInstance()
            .collection("articles")
        val document = articles.document()
        val data = hashMapOf(
            "author" to hashMapOf(
            "email" to "wayne@school.appworks.tw",
            "id" to "waynechen323",
            "name" to "AKA小安老師"),
            "title" to "IU「亂穿」竟美出新境界！笑稱自己品味奇怪　網笑：靠顏值撐住女神氣場",
            "content" to "南韓歌手IU（李知恩）無論在歌唱方面或是近期的戲劇作品 都有亮眼的成績，但俗話說人無完美、美玉微瑕，曾再跟工作人員的互動影片中坦言 自己品味很奇怪，近日在IG上分享了宛如「媽媽們青春時代的玉女歌手」超復古穿搭 造型，卻意外美出新境界。",
            "createdTime" to Calendar.getInstance()
            .timeInMillis,
        "id" to document.id,
        "tag" to "Beauty"
        )
        Log.d("test","$articles $document $data")
        document.set(data)
    }
}
