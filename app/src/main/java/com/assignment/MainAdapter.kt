package com.assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.assignment.databinding.SectionContentItemBinding
import com.assignment.databinding.SectionHeaderItemBinding
import com.assignment.model.MainModel
import com.bumptech.glide.Glide

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainAdapterVH>()  {

    private val items = mutableListOf<MainModel>()

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_CONTENT = 1
    }

//    inner class HeaderVH(private val headerBinding:SectionHeaderItemBinding):RecyclerView.ViewHolder(headerBinding.root){
//
//        private fun bind(header: MainModel.Header){
//            headerBinding.tvSecName.text = header.title
//        }
//
//    }
//
//    inner class ContentVH(private val contentBinding:SectionContentItemBinding):RecyclerView.ViewHolder(contentBinding.root){
//
//        private fun bind(content: MainModel.Content){
//            contentBinding.iv1.setImageResource(content.image_one)
//            contentBinding.iv2.setImageResource(content.image_two)
//            contentBinding.iv3.setImageResource(content.image_three)
//        }
//
//    }

    sealed class MainAdapterVH(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root){

        class HeaderVH(private val binding: SectionHeaderItemBinding):MainAdapterVH(binding){

            fun bind(item: MainModel.Header) {
                binding.tvSecName.text = item.title
            }

        }

        class ContentVH(private val binding: SectionContentItemBinding):MainAdapterVH(binding){

             fun bind(item: MainModel.Content) {
                Glide.with(binding.root.context).load(item.image_one).into(binding.iv1)
                Glide.with(binding.root.context).load(item.image_two).into(binding.iv2)
               Glide.with(itemView.context).load(item.image_three).into(binding.iv3)
            }
        }

    }

    fun setData(data: List<MainModel>) {
        items.apply {
            clear()
            addAll(data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapterVH {
        return when(viewType){
            R.layout.section_header_item->{
                MainAdapterVH.HeaderVH(SectionHeaderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            R.layout.section_content_item ->{
                MainAdapterVH.ContentVH(SectionContentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }

    }

    override fun onBindViewHolder(holder: MainAdapterVH, position: Int) {

        when(holder){
            is MainAdapterVH.HeaderVH -> holder.bind(items[position] as MainModel.Header)
            is MainAdapterVH.ContentVH -> holder.bind(items[position] as MainModel.Content)
        }

//        holder.bind(items[position])
  }

    override fun getItemCount(): Int {
       return  items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position]){
            is MainModel.Header -> R.layout.section_header_item
            is MainModel.Content -> R.layout.section_content_item
        }
    }

}