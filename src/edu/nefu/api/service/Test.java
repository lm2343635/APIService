package edu.nefu.api.service;

import java.util.Date;

public class Test 
{
	public static void main(String[] args) {
		Date date=new Date();
		long timeInterval=date.getTime();
		System.out.println(timeInterval);
		System.out.println(new Date(timeInterval));
	}

}
