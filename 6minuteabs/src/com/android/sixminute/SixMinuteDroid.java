package com.android.sixminute;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.test.mock.MockContext;
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
	private Button resetbutton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txtname = (Button) findViewById(R.id.Start);
        clock = (DigitalClock) findViewById(R.id.DigitalClock01);
        timer = (TextView) findViewById(R.id.Timer);
        timer.setTextSize(120);
        //txtname.setText("Your Mom");
        btnclickme = (Button) findViewById(R.id.Start);
        resetbutton = (Button) findViewById(R.id.Reset);
        //Clock thing = new Clock();
        final workout working = new workout();
       btnclickme.setOnClickListener(new View.OnClickListener(){
    	  boolean exercise =  true;
    	   @Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
    		   if (exercise == true){
    			   clock.addTextChangedListener(working);
    			   exercise = false;
    		   }else{
    			   clock.removeTextChangedListener(working);
    			   exercise = true;
    		   }
			
		}
	});
       resetbutton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			working.resetcounter();
		}
	});
    }
    final class workout implements TextWatcher{
		private int counter = 0;
		
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
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
}
}