package com.zhorateam.wsr

import android.content.ClipData
import android.content.Context.CLIPBOARD_SERVICE
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView


class ReciclerView(): RecyclerView.Adapter<ReciclerView.FunnyViewHolder>()
{

    var Dataset = MutableList<Item>(30) { Item() } // список со всеми шутками

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FunnyViewHolder
    {
        val View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return FunnyViewHolder(View)
    }

    override fun onBindViewHolder(holder: FunnyViewHolder, position: Int)
    {
        holder.onBing(Dataset[position])
    }

    override fun getItemCount(): Int = Dataset.size

    inner class FunnyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var FunnyText = itemView.findViewById<TextView>(R.id.FunnyText)
        var button_like = itemView.findViewById<Button>(R.id.like)
        var button_diselike = itemView.findViewById<Button>(R.id.diselike)

        fun onBing(item: Item)
        {
            FunnyText.text = item.funnyText

            button_like.setOnClickListener(){// при нажатии кнопки лайк - текст копирует в буфер обмена
                Log.d("debag", "Clicked_button_like")
                Toast.makeText(/**контекст*/, "шутка скопирована в буфер обмена!", Toast.LENGTH_LONG).show()

            }

            button_diselike.setOnClickListener(){// при нажатии кнопки дизлайк - удаляется элемент массива с этой шуткой
                Log.d("debag", "Clicked_button_diselike")
                Dataset.removeAt(/**номер в массиве*/)
                notifyDataSetChanged()
            }
        }
    }
}

