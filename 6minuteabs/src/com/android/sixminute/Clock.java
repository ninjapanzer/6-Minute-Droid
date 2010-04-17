package com.android.sixminute;

import java.util.Date;




public final class Clock {
	public static void main (String arg[]){
		long count = 0, oldcount = 0;
		Date now = new Date();
		
		long start = now.getTime();
		long startSeconds = start/1000;
		
		startSeconds = (long) Math.floor((double)startSeconds);
		
		long ourSeconds, our;
		
		while(count < 60)
		{
			now = new Date();
			our = now.getTime();
			ourSeconds = our / 1000;
			ourSeconds = (long) Math.floor((double)ourSeconds);
			count = ourSeconds - startSeconds;
			if(count != oldcount) 
			{
			System.out.println(count);
			oldcount = count;
			}
			
		}
	}
	public Clock(){
		
	}








}
