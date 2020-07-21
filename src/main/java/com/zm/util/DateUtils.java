package com.zm.util;


import com.zm.exception.ValidateException;
import org.joda.time.DateTime;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * @author liyangbin
 * @date 2020.3.10 11:00:31
 * @remark 时间格式
 */
public class DateUtils {


	public static final String DATETIME_YYYYMMDD_HHMMSS = "yyyy年MM月dd日 HH:mm:ss";

	public static final String DATETIMEYYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";

	public static final String DATETIMEYYYYMMDD_HHMM = "yyyy-MM-dd HH:mm";
	
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
	/**
	 * 字符串按格式转换成格式化时间
	 *
	 * @author liyangbin
	 * @date 2020年7月12日
	 * @param time 时间字符串
	 * @param format 传入的时间字符串的格式
	 * @return 返回yyyyMMddHHmmssSSS格式的时间字符串
	 * @throws ValidateException
	 */
	public static String parseDate(String time, String format) throws ValidateException {
		if (!StringUtils.hasLength(time)) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = dateFormat.parse(time);
		} catch (Exception e) {
			throw new ValidateException("日期格式错误");
		}
		DateTime dateTime = new DateTime(date);
		return dateTime.toString(DATATIME_FORMAT_YYYYMMDDHHMMSSSSS);
	}

	/**
	 * 字串（UTC格式）转格式 yyyy-MM-dd HH:mm
	 *
	 * @param oldDate
	 * @return 日期
	 */
	public static String UTCDateFormat(String oldDate) {
		if(!oldDate.contains("Z")){
			return  oldDate;
		}
		Date date1 = null;
		DateFormat df2 = null;
		try {
			oldDate= oldDate.replace("Z", " UTC");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
			Date date = df.parse(oldDate);
			SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
			date1 = df1.parse(date.toString());
			df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return df2.format(date1);
	}
}
