package com.example.randomfilmk

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.gson.Gson
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

var count: Int = 0
val number_films = 8

lateinit var movies : Array<String>;
//val r = Random()
var r_list = (0..(number_films-1)).shuffled()
//var r =

class MainActivity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        Log.d("mytag", "onStart()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("mytag", "onStop()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movies = resources.getStringArray(R.array.movies)
        Log.d("mytag", movies[0])
        // открываем файл
        val movies_stream = resources.openRawResource(R.raw.movies)

        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("name", "Vasya")
        editor.apply()
        Log.d("mytag", "name:" + pref.getString("name", ""))
    }

    fun onNextClick(view: View) {
        // TODO: сделать так, чтобы фильмы не повторялись
        val tvTitle = findViewById<TextView>(R.id.title)
        if (count < r_list.size) {
            var r = r_list[count]
            count++
            tvTitle.text = movies[r]
        } else {
            tvTitle.text = "movies are over"
        }
    }

    fun onClearClick(view: View) {
        // TODO: определить функцию onClearClick
        r_list = (0..(number_films - 1)).shuffled()
        count = 0
    }
}