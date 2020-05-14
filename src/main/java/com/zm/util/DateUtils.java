package com.zm.util;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author liyangbin
 * @date 2020.3.10 11:00:31
 * @remark 时间格式
 */
public class DateUtils {


	public static final String DATETIME_YYYYMMDD_HHMMSS = "yyyy年MM月dd日 HH:mm:ss";
	
	public static final String DATATIME_FORMAT_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

	public static final String DATATIME_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";


	public final static String DATETIME_FORMAT_YYYYMMDD = "yyyy-MM-dd";


	public final static String BEGIN_DATE = "1900-01-01";

	public final static String END_DATE = "2099-12-30";


	public static String getCurrentDate() {
		return LocalDate.now().toString();
	}

	public static Long getCurrentTimes() {
		return Long.parseLong(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATATIME_FORMAT_YYYYMMDDHHMMSSSSS)));
	}

	public static void main(String[] args) {
		System.out.println(DateUtils.getCurrentTimes());
		System.out.println(DateUtils.getCurrentDate());
	}
}
