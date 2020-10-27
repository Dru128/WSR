package com.zhorateam.wsr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FunnyTextActivity : AppCompatActivity() // экран со списком шуток
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funny_text)

        var reciclerView = findViewById<RecyclerView>(R.id.resiclerView)
        reciclerView.adapter = ReciclerView()
        reciclerView.layoutManager = LinearLayoutManager(this)
    }
}