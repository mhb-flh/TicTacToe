package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.Button

class firstPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)

        val twoPlayer=findViewById<Button>(R.id.twoPlayer)
        val singlePlayer=findViewById<Button>(R.id.singlePlayer)

        singlePlayer.setOnClickListener(View.OnClickListener { view ->
            val intent = Intent(this,single_player::class.java)
            startActivity(intent)
        })

        twoPlayer.setOnClickListener(View.OnClickListener { view ->

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        })

    }
}