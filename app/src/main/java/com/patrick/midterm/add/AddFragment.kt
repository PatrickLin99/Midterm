package com.patrick.midterm.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.patrick.midterm.MainViewModel
import com.patrick.midterm.databinding.FragmentAddArticleBinding

class AddFragment : DialogFragment() {

    private val viewModel: AddViewModel by lazy {
        ViewModelProvider(this).get(AddViewModel::class.java)}


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        init()
        val binding = FragmentAddArticleBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel


        return binding.root
    }



}