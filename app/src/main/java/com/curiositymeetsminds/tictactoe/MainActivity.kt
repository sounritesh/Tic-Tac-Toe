package com.curiositymeetsminds.tictactoe

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val tag = "MainActivity"
    var grid = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var play = true
        var turn = true
        val bundle = bundleOf(
            Pair("button1",1),
            Pair("button2",2),
            Pair("button3",3),
            Pair("button4",4),
            Pair("button5",5),
            Pair("button6",6),
            Pair("button7",7),
            Pair("button8",8),
            Pair("button9",9)
        )

        fun checkWin (grid:String): Boolean {
            var keepPlaying = true

                if (grid.contains("XXX")) {keepPlaying = false}
                else if((grid[4] == "X" && grid[5] == "X" && grid[6] == "X") || (grid[4] == "O" && grid[5] == "O" && grid[6] == "O")) {keepPlaying = false}
                else if((grid[7] == "X" && grid[8] == "X" && grid[9] == "X") || (grid[7] == "O" && grid[8] == "O" && grid[9] == "O")) {keepPlaying = false}
                else if((grid[1] == "X" && grid[4] == "X" && grid[7] == "X") || (grid[1] == "O" && grid[4] == "O" && grid[7] == "O")) {keepPlaying = false}
                else if((grid[2] == "X" && grid[5] == "X" && grid[8] == "X") || (grid[2] == "O" && grid[5] == "O" && grid[8] == "O")) {keepPlaying = false}
                else if((grid[3] == "X" && grid[6] == "X" && grid[9] == "X") || (grid[3] == "O" && grid[6] == "O" && grid[9] == "O")) {keepPlaying = false}
                else if((grid[1] == "X" && grid[5] == "X" && grid[9] == "X") || (grid[1] == "O" && grid[5] == "O" && grid[9] == "O")) {keepPlaying = false}
                else if((grid[3] == "X" && grid[5] == "X" && grid[7] == "X") || (grid[3] == "O" && grid[5] == "O" && grid[7] == "O")) {keepPlaying = false}
                else {Log.d(tag, "checkWin: Keep Playing")}

            return keepPlaying
        }


        val listener = View.OnClickListener { v->
            val b = v as Button
            if (checkWin(grid)) {
                if (b.text.isEmpty()) {
                    if (turn) {
                        b.text = "X"
                        grid[bundle.getInt(b.text.toString())] = "X"
                        turn = false
                    } else {
                        b.text = "O"
                        grid[bundle.getInt(b.text.toString())] = "O"
                        turn = true
                    }
                } else {
                    Log.d(tag, "OnClickListener: space not free")
                }

            } else {
                textView.text = "someone wins!"
            }
            for (i in 1..9) {
                Log.d(tag,"${grid[i]},")
            }
        }
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)

//        while (play) {
//            play = checkWin(grid)
//        }
    }
}



