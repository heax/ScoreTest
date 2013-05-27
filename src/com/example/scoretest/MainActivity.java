package com.example.scoretest;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	

	private TextView txt;
	private int cardNumbers = 0;
	private Score scoreClass = new Score();
	private int score;   //An int that saves your total score
	private Toast toast1000, toast1500, toast2000, toast3000, toast5000, toast10000;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		
		//Create custom toasts
		LayoutInflater inflater = getLayoutInflater();
		View layout1 = inflater.inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.toast_layout_root));
		View layout2 = inflater.inflate(R.layout.toast_layout_1500,(ViewGroup) findViewById(R.id.toast_layout_1500_root));
		View layout3 = inflater.inflate(R.layout.toast_layout_1500,(ViewGroup) findViewById(R.id.toast_layout_2000_root));
		View layout4 = inflater.inflate(R.layout.toast_layout_1500,(ViewGroup) findViewById(R.id.toast_layout_3000_root));
		View layout5 = inflater.inflate(R.layout.toast_layout_1500,(ViewGroup) findViewById(R.id.toast_layout_5000_root));
		View layout6 = inflater.inflate(R.layout.toast_layout_1500,(ViewGroup) findViewById(R.id.toast_layout_10000_root));
		toast1000 = new Toast(getApplicationContext());
		toast1000.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast1000.setDuration(Toast.LENGTH_SHORT);
		toast1000.setView(layout1);
		
		toast1500 = new Toast(getApplicationContext());
		toast1500.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast1500.setDuration(Toast.LENGTH_SHORT);
		toast1500.setView(layout2);
		
		toast2000 = new Toast(getApplicationContext());
		toast2000.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast2000.setDuration(Toast.LENGTH_SHORT);
		toast2000.setView(layout3);
		
		toast3000 = new Toast(getApplicationContext());
		toast3000.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast3000.setDuration(Toast.LENGTH_SHORT);
		toast3000.setView(layout4);
		
		toast5000 = new Toast(getApplicationContext());
		toast5000.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast5000.setDuration(Toast.LENGTH_SHORT);
		toast5000.setView(layout5);
		
		toast10000 = new Toast(getApplicationContext());
		toast10000.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast10000.setDuration(Toast.LENGTH_SHORT);
		toast10000.setView(layout6);
		
		
		ImageView img1 = (ImageView) findViewById(R.id.imageView1);
		ImageView img2 = (ImageView) findViewById(R.id.imageView2);
		ImageView img3 = (ImageView) findViewById(R.id.imageView3);
		ImageView img4 = (ImageView) findViewById(R.id.imageView4);
		img1.setOnClickListener(this);
		img2.setOnClickListener(this);
		img3.setOnClickListener(this);
		img4.setOnClickListener(this);
		txt = (TextView) findViewById(R.id.textView1);		
		txt.setText("highscore");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v.equals(findViewById(R.id.imageView1))){
			Log.i("score", "kort1");
			if(cardNumbers > 3){
				cardNumbers = 1;
			} else {
				cardNumbers = cardNumbers+1;
			}
			isSet();
			}
		
		if(v.equals(findViewById(R.id.imageView2))){
			Log.i("score", "kort2");
			if(cardNumbers > 3){
				cardNumbers = 1;
			} else {
				cardNumbers = cardNumbers+1;
			}
			isSet();
			}
		
		if(v.equals(findViewById(R.id.imageView3))){
			Log.i("score", "kort3");
			if(cardNumbers > 3){
				cardNumbers = 1;
			} else {
				cardNumbers = cardNumbers+1;
			}
			isSet();
			}
		
		if(v.equals(findViewById(R.id.imageView4))){
			Log.i("score", "kort4");
			if(cardNumbers > 3){
				cardNumbers = 1;
			} else {
				cardNumbers = cardNumbers+1;
			}
			isSet();
			}
		
	}
	
	public Boolean isSet(){
		if(cardNumbers == 3){
			Log.i("score", "true");
			
			scoreClass.killOldTimer();
			scoreClass.add1000Points();
			scoreClass.startComboTimer();
			
			//Add the score you get to the total score
			score = score+scoreClass.getPoints(); 
			
			//Show custom toast based on how much points you get from your set
			if (scoreClass.getPoints() == 1000){
				toast1000.show();
			}
			
			if(scoreClass.getPoints() == 1500){
				toast1500.show();
			}
			
			if(scoreClass.getPoints() == 2000){
				toast2000.show();
			}
			
			if(scoreClass.getPoints() == 3000){
				toast3000.show();
			}
			
			if(scoreClass.getPoints() == 5000){
				toast5000.show();
			}
			
			if(scoreClass.getPoints() == 10000){
				toast10000.show();
			}
			
			
			txt.setText(Integer.toString(score));
			scoreClass.clearAll();
			return true;
		} else {
			Log.i("score", "false");
			return false;
		}
	}

	@Override
	protected void onDestroy() {
		scoreClass.killOldTimer();
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		scoreClass.killOldTimer();
		super.onPause();
	}
	
	

		

}
