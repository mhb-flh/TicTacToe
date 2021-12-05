package com.example.tictactoe

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    private var player1winsCounts = 0
    private var player2winsCounts = 0

    private var active_player = 1
    var cell_id = 0
    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restart = findViewById<Button>(R.id.btnReset)
        restart.setOnClickListener {
            restartBoard()
            restartResult()
        }

    }

    fun button_clicked(view: View) {
        val button_selected = view as Button
        when (button_selected.id) {
            R.id.button1 -> cell_id = 1
            R.id.button2 -> cell_id = 2
            R.id.button3 -> cell_id = 3
            R.id.button4 -> cell_id = 4
            R.id.button5 -> cell_id = 5
            R.id.button6 -> cell_id = 6
            R.id.button7 -> cell_id = 7
            R.id.button8 -> cell_id = 8
            R.id.button9 -> cell_id = 9
        }

        play_game(cell_id, button_selected)
    }

    fun play_game(cell_id: Int, button_selected: Button) {

        if (active_player == 1) {
            button_selected.text = "X"
            button_selected.setBackgroundColor(Color.MAGENTA)
            player1.add(cell_id)
            active_player = 2
//            autoPlay()

        } else if (active_player == 2) {
            button_selected.text = "O"
            button_selected.setBackgroundColor(Color.CYAN)
            player2.add(cell_id)
            active_player = 1
        }
        button_selected.isEnabled = false
        findWinner()
    }


    private fun findWinner() {
        var winner = -1

        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))
            winner = 1
        else if (player2.contains(1) && player2.contains(2) && player2.contains(3))
            winner = 2

        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6))
            winner = 1
        else if (player2.contains(4) && player2.contains(5) && player2.contains(6))
            winner = 2

        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9))
            winner = 1
        else if (player2.contains(7) && player2.contains(8) && player2.contains(9))
            winner = 2

        //column 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7))
            winner = 1
        else if (player2.contains(1) && player2.contains(4) && player2.contains(7))
            winner = 2

        //column 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8))
            winner = 1
        else if (player2.contains(2) && player2.contains(5) && player2.contains(8))
            winner = 2

        //column 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9))
            winner = 1
        else if (player2.contains(3) && player2.contains(6) && player2.contains(9))
            winner = 2

        //middle
        if (player1.contains(1) && player1.contains(5) && player1.contains(9))
            winner = 1
        else if (player2.contains(1) && player2.contains(5) && player2.contains(9))
            winner = 2

        //middle
        if (player1.contains(3) && player1.contains(5) && player1.contains(7))
            winner = 1
        else if (player2.contains(3) && player2.contains(5) && player2.contains(7))
            winner = 2



        if (winner == 1) {
            player1winsCounts += 1
            var showPlayer1Count=findViewById<Button>(R.id.wonCountPlayer1)
            showPlayer1Count.text= player1winsCounts.toString()
            restartBoard()
        } else if (winner == 2) {
            player2winsCounts += 1
            var showPlayer2Count=findViewById<Button>(R.id.wonCountPlayer2)
            showPlayer2Count.text=player2winsCounts.toString()
            restartBoard()
        }
    }

    fun restartBoard() {
        player1.clear()
        player2.clear()
        for (cellId in 1..9) {
            var button_selected: Button?
            val button1 = findViewById<Button>(R.id.button1)
            val button2 = findViewById<Button>(R.id.button2)
            val button3 = findViewById<Button>(R.id.button3)
            val button4 = findViewById<Button>(R.id.button4)
            val button5 = findViewById<Button>(R.id.button5)
            val button6 = findViewById<Button>(R.id.button6)
            val button7 = findViewById<Button>(R.id.button7)
            val button8 = findViewById<Button>(R.id.button8)
            val button9 = findViewById<Button>(R.id.button9)
            button_selected = when (cellId) {

                1 -> button1
                2 -> button2
                3 -> button3
                4 -> button4
                5 -> button5
                6 -> button6
                7 -> button7
                8 -> button8
                9 -> button9
                else -> {
                    button1
                }
            }
            button_selected.text = ""
            button_selected.setBackgroundColor(Color.WHITE)
            button_selected.isEnabled = true
        }

    }

    fun restartResult(){
        var showPlayer1Count=findViewById<Button>(R.id.wonCountPlayer1)
        var showPlayer2Count=findViewById<Button>(R.id.wonCountPlayer2)
        showPlayer1Count.text=""
        showPlayer2Count.text=""
        player1winsCounts=0
        player2winsCounts=0
    }


}