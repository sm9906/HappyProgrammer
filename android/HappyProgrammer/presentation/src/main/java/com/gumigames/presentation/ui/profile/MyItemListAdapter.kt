package com.gumigames.presentation.ui.profile

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gumigames.domain.model.common.ItemDto
import com.gumigames.presentation.R
import com.gumigames.presentation.databinding.ItemDogamBinding
import com.gumigames.presentation.databinding.ItemMyDogamBinding

private const val TAG = "차선호"
class MyItemListAdapter: ListAdapter<ItemDto, MyItemListAdapter.ItemListHolder>(
    ItemListComparator
) {
    companion object ItemListComparator : DiffUtil.ItemCallback<ItemDto>() {
        override fun areItemsTheSame(oldItem: ItemDto, newItem: ItemDto): Boolean {
            Log.d(TAG, "areItemsTheSame....")
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ItemDto, newItem: ItemDto): Boolean {
            Log.d(TAG, "areContentsTheSame에서 old: $oldItem -> new : $newItem ")
            return oldItem.id == newItem.id
        }
    }
    inner class ItemListHolder(private val binding: ItemMyDogamBinding): RecyclerView.ViewHolder(binding.root){
        fun bindInfo(position: Int, item : ItemDto){
            Log.d(TAG, "bindInfo: $item")
            binding.apply {
                if(item.imageBitmap!=null) imageItem.setImageBitmap(item.imageBitmap)
                else imageItem.setImageResource(R.drawable.image_tool_profile) //TODO 추후에 로딩 이미지로 바꿔라
                imageItem.setOnClickListener {
                    itemClickListner.onClick(it, position, item)
                }
                if(item.isBookmarked) imageBookmark.visibility = View.VISIBLE
                else imageBookmark.visibility = View.GONE
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListHolder {
        val binding = ItemMyDogamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemListHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemListHolder, position: Int) {
        holder.apply {
            bindInfo(position, getItem(position))
        }
    }

    //클릭 인터페이스 정의 사용하는 곳에서 만들어준다.
    interface ItemClickListener {
        fun onClick(view: View, position: Int, item: ItemDto)
    }
    //클릭리스너 선언
    lateinit var itemClickListner: ItemClickListener
}