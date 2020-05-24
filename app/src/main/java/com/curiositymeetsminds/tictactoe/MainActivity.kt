package com.curiositymeetsminds.tictactoe

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        single.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        startActivity(Intent(this, GameActivity::class.java))
    }
}



