package com.petshop.xss;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XSSHelper {
	//https://www.w3schools.com/java/java_regex.asp
	public static boolean checkStringContainXSS(String str) {
		if (str == null)
			return false;
		Pattern pattern = Pattern.compile("<\\s*script\\s*>", Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
		return matcher.find();
	}
}
