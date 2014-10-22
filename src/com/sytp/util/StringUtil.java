package com.sytp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author STerOTto
 *	some operations of string 
 */
public class StringUtil
{
	private static final StringUtil _instance;
	static
	{
		_instance = new StringUtil();
	}

	public StringUtil getInstance()
	{
		return _instance;
	}

	public static String replaceBlank(String str)
	{
		//replace blank of string
		String result = "";
		if (str != null)
		{
			Pattern pattern = Pattern.compile("\\s*|\t|\r|\n");
			Matcher matcher = pattern.matcher(str);
			result = matcher.replaceAll("");
		}
		return result;
	}

}
