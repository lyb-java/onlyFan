package com.zm.util;

import org.joda.time.DateTime;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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


	public static String getCurrentTime() {
		return DateTime.now().toString(DATATIME_FORMAT_YYYYMMDDHHMMSSSSS);
	}

	public static Long getCurrentTimes() {
		return Long.parseLong(DateTime.now().toString(DATATIME_FORMAT_YYYYMMDDHHMMSSSSS));
	}

	/**
	 * 取出一个指定长度大小的随机正整数.
	 *
	 * @param length int 设定所取出随机数的长度。length小于11
	 * @return int 返回生成的随机数。
	 */
	public static int getRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}
	/**
	 * 比较两个日期（年月日）
	 * @author liyangbin
	 * @date 2020-3-1   11:26
	 * @return
	 */
	public static int dateCompare(String dateA, String dateB,String format)throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date dateFirst = dateFormat.parse(dateA);
		Date dateLast = dateFormat.parse(dateB);
		if (dateFirst.after(dateLast)) {
			return 1;
		} else if (dateFirst.before(dateLast)) {
			return -1;
		}
		return 0;
	}

}
