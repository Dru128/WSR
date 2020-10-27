package com.zhorateam.wsr

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() // начальный экран
{
    var Dataset = MutableList<Item>(30) { Item() } //  "https://api.icndb.com"  от сюда брать анекдоты

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.Text).apply {
            setText(Dataset[(0 until Dataset.size).random()].funnyText)
            setOnClickListener() {// при нажатии на шутку (текст) переходим на экран со списком шуток
                val i = Intent(this@MainActivity, FunnyTextActivity::class.java)
                startActivity(i)
            }
        }
    }
}