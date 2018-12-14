package com.dream.utils;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CommonUtils {
	@SuppressWarnings("unused")
	private final static Logger logger = LoggerFactory.getLogger(CommonUtils.class);
	public static String esDocUrl = null;
	public static String esComUrl = null;
	public static String allDoc = null;
	public static Map<Integer, String> channelMap = null;
	public static Map<String, String> channelMapzn = null;
}
