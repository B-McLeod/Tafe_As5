package com.example.tictactoe_game;

import android.widget.Button;

public class GameLogic {
		
		boolean [][] board = new boolean[3][3];
		boolean currentPlayer;
				
		public GameLogic()
		{
			//clearGame();
		}
		
		// Loop through the array to set all values to false
		public void clearGame()
		{
			// Set all buttons to false
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					board[i][j] = false;
				}
			}
		}
		
		// Clear button text and reset to click-able
		public void resetButton(Button btn)
		{
			btn.setText(R.string.blank);
			btn.setClickable(true);
		}
		
		// Logic for player move
		public void playerMove(Button btn)
		{
			if (currentPlayer == false) {
				btn.setText(R.string.nought);
				btn.setClickable(false);
				hasWon();
			}
			else {
				btn.setText(R.string.cross);
				btn.setClickable(false);
				hasWon();
			}
			
			currentPlayer = switchPlayers(currentPlayer);
		}
		
		// Check for winner
		// Have an array for each player
		public boolean hasWon()
		{
			// myGame[row][column]
			if (/* Row 1 */ (board[0][0] && board[0][1] && board[0][2]) ||
				/* Row 2 */ (board[1][0] && board[1][1] && board[1][2]) ||
				/* Row 3 */ (board[2][0] && board[2][1] && board[2][2]) ||
				/* Column 1 */ (board[0][0] && board[1][0] && board[2][0]) ||
				/* Column 2 */ (board[0][1] && board[1][1] && board[2][1]) ||
				/* Column 3 */ (board[0][2] && board[1][2] && board[2][2]) ||
				/* Diagonal R */ (board[0][0] && board[1][1] && board[2][2]) ||
				/* Diagonal L */ (board[0][2] && board[1][1] && board[2][0]))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public boolean switchPlayers(boolean player) {
			if (player == false) {
				return true;
			}
			else {
				return false;
			}
		}
}