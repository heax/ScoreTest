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
	private int score;
	private Toast toast1000, toast1500;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		LayoutInflater inflater = getLayoutInflater();
		View layout1 = inflater.inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.toast_layout_root));
		View layout2 = inflater.inflate(R.layout.toast_layout_1500,(ViewGroup) findViewById(R.id.toast_layout_1500_root));
		toast1000 = new Toast(getApplicationContext());
		toast1000.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast1000.setDuration(Toast.LENGTH_SHORT);
		toast1000.setView(layout1);
		toast1500 = new Toast(getApplicationContext());
		toast1500.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast1500.setDuration(Toast.LENGTH_SHORT);
		toast1500.setView(layout2);
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
			
			scoreClass.killOldTimer(); ///Kan vi g�ra �ven om det �r f�rsta g�ngen r�knar ut combo och addar det till points �ss� �r noll f�rsta g�ngen
			scoreClass.add1000Points();
			scoreClass.startComboTimer();
			score = score+scoreClass.getPoints(); //Det k�nns lite konstigt att du har score b�de h�r och i scoreklassen kan du inte samla dem i score?
			
			//Anledningen är att jag bara vill läsa in hur mycket poäng som scoren ökas med för att kunna visa
			// custom toasts där det står hur mycket poäng man fått
			
			if(score > 1500){      //H�r visas denna alltid skall den verkligen det det �r v�l bara om scoreClass.getPoints() >1500
				
				//Tanken är ju att det ska visa olika toasts beroende på hur mycket poäng man får men uppenbarligen
				//fungerar det ju inte som det är tänkt, förstår inte varför.
				toast1500.show();
			} else {
				toast1000.show();
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
	
	

		

}
