package com.aspire.utils;

import java.nio.charset.Charset;
import java.util.Random;

import com.aspire.testdata.TestData;

public class RandomNameGenerator {
	private static String randomProductName;
	
	public static String generateRandomString(){
		String source = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789";
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();

	    for(int i = 0; i < TestData.productNameStringLength; i++) {
	      int index = random.nextInt(source.length());
	      char randomChar = source.charAt(index);
	      sb.append(randomChar);
	    }
		randomProductName = sb.toString();
		return randomProductName;
	}

	public static String getRandomProductName() {
		return randomProductName;
	}

}
