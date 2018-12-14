package com.dream.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timeutil {

	public static String dateStr(Long timeStamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(new Date(timeStamp));
		return dateStr;
	}
}
