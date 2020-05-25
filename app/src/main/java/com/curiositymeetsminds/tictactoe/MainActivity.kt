package com.curiositymeetsminds.tictactoe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tournament.setOnClickListener {
            editText.visibility = View.VISIBLE
            play.visibility = View.VISIBLE
            Toast.makeText(this, "Enter number of games.", Toast.LENGTH_LONG).show()
        }

        var numberOfGames: Int
        single.setOnClickListener(this)
        play.setOnClickListener {
            numberOfGames = editText.text.toString().toInt()
            startActivity(Intent(this,TournamentActivity(numberOfGames)::class.java))
        }

        editText.visibility = View.INVISIBLE
        play.visibility = View.INVISIBLE
    }

    override fun onClick(v: View?) {
        startActivity(Intent(this, GameActivity::class.java))
    }
}



