package com.example.tictactoe_game;

import com.example.tictactoe_game.R;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity
implements OnClickListener {
	
	GameLogic myLogic = new GameLogic();

	// Create variables
	Button btn1;
	Button btn2;
	Button btn3;
	Button btn4;
	Button btn5;
	Button btn6;
	Button btn7;
	Button btn8;
	Button btn9;
	Button btnNewGame;
	TextView lblGameMessage;
	
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
			myLogic.playerMove(btn1);
			break;
		case R.id.btn2:
			myLogic.playerMove(btn2);
			break;
		case R.id.btn3:
			myLogic.playerMove(btn3);
			break;
		case R.id.btn4:
			myLogic.playerMove(btn4);
			break;
		case R.id.btn5:
			myLogic.playerMove(btn5);
			break;
		case R.id.btn6:
			myLogic.playerMove(btn6);
			break;
		case R.id.btn7:
			myLogic.playerMove(btn7);
			break;
		case R.id.btn8:
			myLogic.playerMove(btn8);
			break;
		case R.id.btn9:
			myLogic.playerMove(btn9);
			break;
		case R.id.btnNewGame:
			myLogic.clearGame();
			myLogic.resetButton(btn1);
			myLogic.resetButton(btn2);
			myLogic.resetButton(btn3);
			myLogic.resetButton(btn4);
			myLogic.resetButton(btn5);
			myLogic.resetButton(btn6);
			myLogic.resetButton(btn7);
			myLogic.resetButton(btn8);
			myLogic.resetButton(btn9);
			break;
		}
	}
}
