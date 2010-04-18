package com.android.sixminute;

import android.app.Activity;
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
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txtname = (Button) findViewById(R.id.Start);
        clock = (DigitalClock) findViewById(R.id.DigitalClock01);
        timer = (TextView) findViewById(R.id.Timer);
        //txtname.setText("Your Mom");
        btnclickme = (Button) findViewById(R.id.Start);
       btnclickme.setOnClickListener(new View.OnClickListener(){
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//txtname.setText("No Your Mom");
			//clock.setText("0.0.0");
			txtname.setText(clock.getText());
			clock.addTextChangedListener(new TextWatcher() {
				
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {
					
					CharSequence time = clock.getText();
					time = time.subSequence(time.length()- 5, time.length()-3);
					//txtname.setText(time);
					//timer.setHeight(50);
					//timer.setWidth(50);
					timer.setTextSize(80);
					timer.setText(time);
					
					
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