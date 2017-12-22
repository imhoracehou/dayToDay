package com.horace.utils;

public class StringUtils {
	public static boolean isNotEmpty(String s) {
		boolean b = true;
		if (s == null)
			b = false;
		if ("".equals(s))
			b = false;
		return b;
	}
}
