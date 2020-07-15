package com.zm.util;


import org.joda.time.DateTime;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
	/**
	 * 将某格式时间转化为指定格式时间
	 *
	 * @param time
	 * @param formatA 格式a
	 * @param formatB 格式b
	 * @return
	 * @throws ParseException
	 */
	public static String parseDate(String time,String formatA, String formatB) throws ParseException {
		if (!StringUtils.hasLength(time)) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatA);
		Date date = dateFormat.parse(time);
		DateTime dateTime = new DateTime(date);
		return dateTime.toString(formatB);
	}
}
