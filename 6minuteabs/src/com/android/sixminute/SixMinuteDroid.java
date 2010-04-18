package com.android.sixminute;

import android.app.Activity;
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
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txtname = (Button) findViewById(R.id.Start);
        clock = (DigitalClock) findViewById(R.id.DigitalClock01);
        timer = (TextView) findViewById(R.id.Timer);
        //txtname.setText("Your Mom");
        btnclickme = (Button) findViewById(R.id.Start);
        Clock thing = new Clock();
       btnclickme.setOnClickListener(new View.OnClickListener(){
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//txtname.setText("No Your Mom");
			//clock.setText("0.0.0");
			txtname.setText(clock.getText());
			CharSequence time = clock.getText();
			time = time.subSequence(time.length()- 5, time.length()-3);
			int sec = Integer.parseInt(time.toString());
			final int secstart = sec;
			
			clock.addTextChangedListener(new TextWatcher() {
				int counter = 0;
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {
					//CharSequence time = clock.getText();
					//time = time.subSequence(time.length()- 5, time.length()-3);
					//time = clock.getText();
					//time = time.subSequence(time.length()- 5, time.length()-3);
					//txtname.setText(time);
					//timer.setHeight(50);
					//timer.setWidth(50);
					timer.setTextSize(80);
					//int newtime = Integer.parseInt(time.toString()) - secstart;
					//timer.setText(Integer.toString(newtime));
					timer.setText(Integer.toString(counter++));
					MockContext context = new MockContext();
					if (counter == 5){
						MediaPlayer mp = MediaPlayer.create(context, R.raw.pager5);
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
			});
			//txtname.setText("Who talks like that");
		}
	});
    }
}