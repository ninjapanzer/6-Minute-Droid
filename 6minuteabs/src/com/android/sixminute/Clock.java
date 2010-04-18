package com.android.sixminute;

import java.util.Date;




public final class Clock {
	public static void main (String arg[]){
		long count = 0, oldcount = 0, ourSeconds, our;
		int minutes = 0;
		
		
		while (minutes < 6)
		{
		Date now = new Date();
		
		long start = now.getTime();
		long startSeconds = start/1000;
		
		startSeconds = (long) Math.floor((double)startSeconds);
		
			while(count < 60)
			{
				now = new Date();
				our = now.getTime();
				ourSeconds = our / 1000;
				ourSeconds = (long) Math.floor((double)ourSeconds);
				count = ourSeconds - startSeconds;
				
				if(count != oldcount) 
				{
					if (count > 9)
					{
						System.out.println(minutes + ":" + count);
					}
					else
					{
						System.out.println(minutes + ":0" + count);
					}
				oldcount = ourSeconds;
				}
			}
			count = 0;
			minutes = minutes + 1;
		}
	}
	public Clock(){
		
	}








}
