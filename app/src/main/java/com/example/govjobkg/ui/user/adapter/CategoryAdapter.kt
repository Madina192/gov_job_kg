package com.example.govjobkg.ui.user.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.govjobkg.databinding.ItemCategoryBinding
import com.example.govjobkg.network.models.Category

class CategoryAdapter(private val onClick: () -> Unit) : Adapter<CategoryAdapter.UserMainViewHolder>(){

    private var list = listOf<Category>()

    fun setList(categories: List<Category>) {
        list = categories
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserMainViewHolder {
        return UserMainViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: UserMainViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class UserMainViewHolder(private val binding : ItemCategoryBinding) : ViewHolder(binding.root){
        fun onBind(category: Category){
            binding.ivIcon.setImageResource(category.image)
            binding.tvTitle.text = category.title

            itemView.setOnClickListener {
                onClick()
            }
        }

    }

}