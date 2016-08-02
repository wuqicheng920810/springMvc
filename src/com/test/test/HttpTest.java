package com.test.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HttpTest {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String times="2016-07-28 20:59:00.0";
		SimpleDateFormat sm=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		Date date=sm.parse(times);
		System.out.println(sm.format(date));
	}

}
