package com.example.databindingrv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingrv.databinding.PojoItemBinding

class PojoAdapter :
    androidx.recyclerview.widget.ListAdapter<Pojo, PojoAdapter.POJOViewHolder>(POJODiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): POJOViewHolder {
        return POJOViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: POJOViewHolder, position: Int) {
        val pojoItem = getItem(position)
        holder.bind(pojoItem)
    }

    class POJOViewHolder constructor(private val binding: PojoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pojo) {
            binding.pojo = item
            binding.executePendingBindings()
        }

        //For inflating the layout in onCreateViewHolder()
        companion object {
            fun from(parent: ViewGroup): POJOViewHolder {
                val binding =
                    PojoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return POJOViewHolder(binding)
            }
        }
    }
}

class POJODiffCallback : DiffUtil.ItemCallback<Pojo>() {
    override fun areItemsTheSame(oldItem: Pojo, newItem: Pojo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pojo, newItem: Pojo): Boolean {
        return oldItem == newItem
    }
}