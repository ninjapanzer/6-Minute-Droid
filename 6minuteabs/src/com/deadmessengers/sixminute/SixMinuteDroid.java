package com.deadmessengers.sixminute;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.TextView;

public class SixMinuteDroid extends Activity {
    /** Called when the activity is first created. */
	private Button btnclickme;
	private Button txtname;
	private DigitalClock clock;
	private TextView timer;
	private TextView Banner;
	private Button resetbutton;
	boolean exercise =  true; 
	//handles if the app neets to be reset or not. This is globalized to allow the even handles access
	private boolean getexercisestatus(){
	    	return exercise;
	    }
	private void setexercisestatus(boolean status){
	    	exercise = status;
	    }
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState){
		
	}
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txtname = (Button) findViewById(R.id.Start);  // assigns the static reference to the view object to txtname
        clock = (DigitalClock) findViewById(R.id.DigitalClock01); // assigns the static reference to the view object to DigitalClock01
        timer = (TextView) findViewById(R.id.Timer); // assigns the static reference to the view object to Timer
        timer.setTextSize(120);   //sets the timer text to 120 sq pixels
        Banner = (TextView) findViewById(R.id.Banner);
        Banner.setTextSize(25);
        
        btnclickme = (Button) findViewById(R.id.Start);
        resetbutton = (Button) findViewById(R.id.Reset);
        final workout working = new workout();
        boolean exercise =  true;
       btnclickme.setOnClickListener(new View.OnClickListener(){  
    	   //enters inline class to act as the event listener this one is similar to the onchange JS event
    	//this onclick adds a listener at the start of the workout and kills it if the exercise is done
    	@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
    		   if (getexercisestatus() == true){
    			   clock.addTextChangedListener(working);
    			   btnclickme.setText("Pause");
    			   setexercisestatus(false);
    		   }else{
    			   clock.removeTextChangedListener(working);
    			   setexercisestatus(true);
    			   btnclickme.setText("Exercise");
    		   }
			
		}
	});
       resetbutton.setOnClickListener(new View.OnClickListener() {
		
    	   //the onclick handler for reset
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			working.resetcounter();
			timer.setText(Integer.toString(working.getcounter()));
		}
	});
    }
    final class workout implements TextWatcher{
		private int counter = 0;
		
		private int getcounter(){
			return counter;
		}
		private void setcounter(int number){
			counter = number;
		}
		private void resetcounter(){
			counter = 0;
		}
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			timer.setText(Integer.toString(counter++));
	    	
	    	if (counter % 45 == 0){
					MediaPlayer mp = MediaPlayer.create(getBaseContext(), R.raw.pager5);
				    mp.start();
				}
			//unloads the event listener and resets the app in the event that 6 minutes occurs
			//unloading the handler effectivly stops the handler.
			if (counter > 360){
				resetcounter();
				setexercisestatus(true);
				clock.removeTextChangedListener(this);
			}
		}
		//unused from interface
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}
		//unused from interface
		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
}
}