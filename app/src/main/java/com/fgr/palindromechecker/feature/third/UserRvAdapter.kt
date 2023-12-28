package com.fgr.palindromechecker.feature.third

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fgr.palindromechecker.data.response.UserResponse
import com.fgr.palindromechecker.databinding.ItemThirdScreenBinding

class UserRvAdapter(
    private val onItemClicked: (user: UserResponse) -> Unit,
) : PagingDataAdapter<UserResponse, UserRvAdapter.ViewHolder>(DIFF_CALLBACK) {

    class ViewHolder(private val binding: ItemThirdScreenBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: UserResponse, onItemClicked: () -> Unit) {
            binding.itemThirdScreenUserName.text = buildString {
                append(data.firstName)
                append(" ")
                append(data.lastName)
            }
            binding.itemThirdScreenUserImage.scaleType = ImageView.ScaleType.CENTER_CROP
            Glide.with(binding.root.context)
                .load(data.avatar)
                .into(binding.itemThirdScreenUserImage)

            binding.itemThirdScreen.setOnClickListener {
                onItemClicked()
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemThirdScreenBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data) { onItemClicked(data) }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UserResponse>() {
            override fun areItemsTheSame(oldItem: UserResponse, newItem: UserResponse): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: UserResponse,
                newItem: UserResponse
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}