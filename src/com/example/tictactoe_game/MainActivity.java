/*
 * Title:	Android Tic-Tac-Toe Application
 * 
 * Creator:	Blake McLeod (2102771708)
 * 
 * Brief:	Create an application for android.
 * 
 * Issues:	Moving to Landscape orientation will clear the game.
 * 			I believe JSON is required to achieve this, however given the time-frame
 * 			and depth of this assignment, we are not required to complete this part.
 * 			I had a method to overcome this without JSON however it would be very repetitive
 * 			and elementary. I would much prefer to learn JSON and implement it properly
 * 			when the time allows.
 */

package com.example.tictactoe_game;

import com.example.tictactoe_game.R;
import android.support.v7.app.ActionBarActivity;
//import android.content.SharedPreferences;
//import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity
implements OnClickListener {

	// define the variables for the widgets
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn7;
	private Button btn8;
	private Button btn9;
	private Button btnNewGame;
	private TextView lblGameMessage;
	
	// define the SharedPreferences object
	//private SharedPreferences savedValues;
	
	// define variables for the game logic
	private boolean[][] naught = new boolean[3][3];
	private boolean[][] cross = new boolean[3][3];
	private boolean currentPlayer;
	
	@Override
	public void onPause() {
		/* save the instance variables
		 * Use JSON to save and retrieve data
		Editor editor = savedValues.edit();
		editor.putBoolean("O00", naught[0][0]);
		editor.putBoolean("O01", naught[0][1]);
		editor.putBoolean("O02", naught[0][2]);
		editor.putBoolean("O10", naught[1][0]);
		editor.putBoolean("O11", naught[1][1]);
		editor.putBoolean("O12", naught[1][2]);
		editor.putBoolean("O20", naught[2][0]);
		editor.putBoolean("O21", naught[2][1]);
		editor.putBoolean("O22", naught[2][2]);
		
		editor.putBoolean("X00", cross[0][0]);
		editor.putBoolean("X01", cross[0][1]);
		editor.putBoolean("X02", cross[0][2]);
		editor.putBoolean("X10", cross[1][0]);
		editor.putBoolean("X11", cross[1][1]);
		editor.putBoolean("X12", cross[1][2]);
		editor.putBoolean("X20", cross[2][0]);
		editor.putBoolean("X21", cross[2][1]);
		editor.putBoolean("X22", cross[2][2]);
		
		
		editor.commit();*/
		super.onPause();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		/*
		naught[0][0] = savedValues.getBoolean("O00", naught[0][0]);
		naught[0][1] = savedValues.getBoolean("O01", naught[0][1]);
		naught[0][2] = savedValues.getBoolean("O02", naught[0][2]);
		naught[1][0] = savedValues.getBoolean("O10", naught[1][0]);
		naught[1][1] = savedValues.getBoolean("O11", naught[1][1]);
		naught[1][2] = savedValues.getBoolean("O12", naught[1][2]);
		naught[2][0] = savedValues.getBoolean("O20", naught[2][0]);
		naught[2][1] = savedValues.getBoolean("O21", naught[2][1]);
		naught[2][2] = savedValues.getBoolean("O22", naught[2][2]);
		
		cross[0][0] = savedValues.getBoolean("X00", cross[0][0]);
		cross[0][1] = savedValues.getBoolean("X01", cross[0][1]);
		cross[0][2] = savedValues.getBoolean("X02", cross[0][2]);
		cross[1][0] = savedValues.getBoolean("X10", cross[1][0]);
		cross[1][1] = savedValues.getBoolean("X11", cross[1][1]);
		cross[1][2] = savedValues.getBoolean("X12", cross[1][2]);
		cross[2][0] = savedValues.getBoolean("X20", cross[2][0]);
		cross[2][1] = savedValues.getBoolean("X21", cross[2][1]);
		cross[2][2] = savedValues.getBoolean("X22", cross[2][2]);*/
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.settings_activity);
        
        // Link buttons to variables
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnNewGame = (Button) findViewById(R.id.btnNewGame);
        lblGameMessage = (TextView) findViewById(R.id.lblGameMessage);
        
        // Register buttons as click handlers
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnNewGame.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onClick(View v) {		
		switch (v.getId()) {
		case R.id.btn1:
			if (currentPlayer == false) {
				naught[0][0] = true;
			}
			else {
				cross[0][0] = true;
			}
			playerMove(btn1);
			break;
		case R.id.btn2:
			if (currentPlayer == false) {
				naught[0][1] = true;
			}
			else {
				cross[0][1] = true;
			}
			playerMove(btn2);
			break;
		case R.id.btn3:
			if (currentPlayer == false) {
				naught[0][2] = true;
			}
			else {
				cross[0][2] = true;
			}
			playerMove(btn3);
			break;
		case R.id.btn4:
			if (currentPlayer == false) {
				naught[1][0] = true;
			}
			else {
				cross[1][0] = true;
			}
			playerMove(btn4);
			break;
		case R.id.btn5:
			if (currentPlayer == false) {
				naught[1][1] = true;
			}
			else {
				cross[1][1] = true;
			}
			playerMove(btn5);
			break;
		case R.id.btn6:
			if (currentPlayer == false) {
				naught[1][2] = true;
			}
			else {
				cross[1][2] = true;
			}
			playerMove(btn6);
			break;
		case R.id.btn7:
			if (currentPlayer == false) {
				naught[2][0] = true;
			}
			else {
				cross[2][0] = true;
			}
			playerMove(btn7);
			break;
		case R.id.btn8:
			if (currentPlayer == false) {
				naught[2][1] = true;
			}
			else {
				cross[2][1] = true;
			}
			playerMove(btn8);
			break;
		case R.id.btn9:
			if (currentPlayer == false) {
				naught[2][2] = true;
			}
			else {
				cross[2][2] = true;
			}
			playerMove(btn9);
			break;
		case R.id.btnNewGame:
			clearGame();
			resetButton(btn1);
			resetButton(btn2);
			resetButton(btn3);
			resetButton(btn4);
			resetButton(btn5);
			resetButton(btn6);
			resetButton(btn7);
			resetButton(btn8);
			resetButton(btn9);
			lblGameMessage.setText(R.string.blank);
			break;
		}
	}
	
	// Logic for player move
	public void playerMove(Button btn)
	{
		// Naughts turn
		if (currentPlayer == false) {
			btn.setText(R.string.nought);
			btn.setClickable(false);
			if (hasWon(naught)) {
				lblGameMessage.setText(R.string.playerOWon);
				disableBoard();
			}
		}
		
		// Crosses turn
		else if (currentPlayer == true) {
			btn.setText(R.string.cross);
			btn.setClickable(false);
			if (hasWon(cross)) {
				lblGameMessage.setText(R.string.playerXWon);
				disableBoard();
			}
		}
		
		// Change players
		currentPlayer = switchPlayers(currentPlayer);
	}
	
	// Change current player
	public boolean switchPlayers(boolean player) {
		if (player == false) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Check for winner
	// Have an array for each player
	public boolean hasWon(boolean[][] checkBoard)
	{
		// myGame[row][column]
		if (/* Row 1 */ (checkBoard[0][0] && checkBoard[0][1] && checkBoard[0][2]) ||
			/* Row 2 */ (checkBoard[1][0] && checkBoard[1][1] && checkBoard[1][2]) ||
			/* Row 3 */ (checkBoard[2][0] && checkBoard[2][1] && checkBoard[2][2]) ||
			/* Column 1 */ (checkBoard[0][0] && checkBoard[1][0] && checkBoard[2][0]) ||
			/* Column 2 */ (checkBoard[0][1] && checkBoard[1][1] && checkBoard[2][1]) ||
			/* Column 3 */ (checkBoard[0][2] && checkBoard[1][2] && checkBoard[2][2]) ||
			/* Diagonal R */ (checkBoard[0][0] && checkBoard[1][1] && checkBoard[2][2]) ||
			/* Diagonal L */ (checkBoard[0][2] && checkBoard[1][1] && checkBoard[2][0]))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

	
	// Disable game board
	public void disableBoard() {
		btn1.setClickable(false);
		btn2.setClickable(false);
		btn3.setClickable(false);
		btn4.setClickable(false);
		btn5.setClickable(false);
		btn6.setClickable(false);
		btn7.setClickable(false);
		btn8.setClickable(false);
		btn9.setClickable(false);
	}
	
	// Loop through the array to set all values to false
	public void clearGame()
	{
		// Set all buttons to false
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				naught[i][j] = false;
				cross[i][j] = false;
			}
		}
	}
	
	// Clear button text and reset to click-able
	public void resetButton(Button btn)
	{
		btn.setText(R.string.blank);
		btn.setClickable(true);
	}
}
