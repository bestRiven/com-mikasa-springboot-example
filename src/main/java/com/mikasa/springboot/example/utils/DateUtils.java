/**
 * 
 */
package com.mikasa.springboot.example.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zy
 *
 */
public class DateUtils {

	static Logger log = LoggerFactory.getLogger(DateUtils.class);

	private static String defaultDatePattern = "yyyy-MM-dd HH:mm:ss";
	private static String defaultDateShortPattern = "yyyy-MM-dd";
	public static final String yyyyMMddHHmmss = "yyyy-MM-ddHH:mm:ss";
	public static String yyyyMMdd = "yyyyMMdd";
	public static String hhmmssSSS = "HHmmssSSS";
	public static String HHmm = "HH:mm";

	public static Date parse(String strDate) {

		if (StringUtils.isBlank(strDate)) {
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(defaultDatePattern);
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		}

		return date;
	}

	public static Date parseShort(String strDate) {

		if (StringUtils.isBlank(strDate)) {
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(defaultDateShortPattern);
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		}

		return date;
	}

	public static String parse(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(defaultDatePattern);
		return sdf.format(date);
	}

	public static String formatDate(Date date, String pattern) {
		if (date == null) {
			return "";
		}
		if (StringUtils.isBlank(pattern)) {
			pattern = yyyyMMdd;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static Long getBetweenDays(Date beginTime, Date endTime){
		if (endTime == null || beginTime == null) {
			return 0L;
		}
		return (endTime.getTime() - beginTime.getTime()) / (24*60*60*1000);
	}
	
	//当前时间周一时间  ling
		public static Date getMonday(int n) {
			Calendar cal = Calendar.getInstance();
			//n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
			cal.add(Calendar.DATE, n*7);
			//想周几，这里就传几Calendar.MONDAY（TUESDAY...）
			cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			
			 cal.set(Calendar.HOUR_OF_DAY, 0);
		     cal.set(Calendar.MINUTE, 0);
		     cal.set(Calendar.SECOND, 0);
		     cal.set(Calendar.MILLISECOND, 0);

			return cal.getTime();
		}
	
	/**
	 * 日期间隔的分钟
	 * 
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static Long getBetweenMinutes(Date beginTime, Date endTime) {
		if (endTime == null || beginTime == null) {
			return 0L;
		}
		return (endTime.getTime() - beginTime.getTime()) / (60 * 1000);
	}

	public static String parse(Date date, String pattern) {
		if (date == null) {
			return "";
		}
		if (StringUtils.isBlank(pattern)) {
			pattern = yyyyMMdd;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtils.getMonday(0));
		System.out.println(DateUtils.getMonday(1));
	}
}
