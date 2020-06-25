package com.patrick.midterm

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.patrick.midterm.databinding.ItemPublishBinding

//class MainAdapter() :
//    ListAdapter<Info, MainAdapter.MainViewHolder>(DiffCallback) {
//
//    class MainViewHolder(private var binding: ItemPublishBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(info: Info) {
//            binding.viewModel = info
//            binding.executePendingBindings()
//
//        }
//    }
//
//
//    companion object DiffCallback : DiffUtil.ItemCallback<Info>() {
//        override fun areContentsTheSame(oldItem: Info, newItem: Info): Boolean {
//            return oldItem == newItem
//        }
//
//        override fun areItemsTheSame(oldItem: Info, newItem: Info): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
//        return MainViewHolder(ItemPublishBinding().inflate(LayoutInflater.from(parent.context), parent, false)
//        )
//
//    }
//
//    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
//        val string = getItem(position)
//        holder.bind(string)
//    }
//
//}

class MainAdapter() : androidx.recyclerview.widget.ListAdapter<Info, MainAdapter.MainViewHolder>(DiffCallback) {


    class MainViewHolder(private var binding: ItemPublishBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(info: Info) {
            binding.viewModel = info
            binding.executePendingBindings()

        }
    }




    companion object DiffCallback : DiffUtil.ItemCallback<Info>() {
        override fun areContentsTheSame(oldItem: Info, newItem: Info): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: Info, newItem: Info): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemPublishBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val info = getItem(position)
        holder.bind(info)
//        holder.itemView.setOnClickListener {
//            onClickListener.onClick(images)
//        }
//        holder.bind(getItem(position))
    }

}