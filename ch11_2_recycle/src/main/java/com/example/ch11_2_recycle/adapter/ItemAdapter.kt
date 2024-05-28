package com.example.ch11_2_recycle.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ch11_2_recycle.R
import com.example.ch11_2_recycle.model.Affirmation

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    //  ViewHolder는 RecyclerView의 단일 목록 항목 뷰를 나타내며 가능한 경우 재사용할 수 있습니다.
    class ItemViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    // onCreateViewHolder() 메서드는 RecyclerView의 새 뷰 홀더를 만들기 위해 레이아웃 관리자가 호출합니다(재사용할 수 있는 기존 뷰 홀더가 없는 경우).
    // 뷰 홀더는 단일 목록 항목 뷰를 나타냅니다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        // getString()은 Resources 클래스의 메서드이며, context를 통해 Resources 클래스의 인스턴스를 가져올 수 있습니다.
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }
}