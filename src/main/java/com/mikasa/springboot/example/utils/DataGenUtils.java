package com.mikasa.springboot.example.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author baozhe
 * @version 2015年3月4日
 *
 */
public class DataGenUtils {

	public static synchronized String getUniqueOrderid() {
		Calendar cal = Calendar.getInstance();
		String year = String.valueOf(cal.get(Calendar.YEAR)).substring(2);
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		month = (month.length() <= 1) ? ("0" + month) : month;
		String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		day = (day.length() <= 1) ? ("0" + day) : day;
		String hour = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
		hour = (hour.length() <= 1) ? ("0" + hour) : hour;
		String minute = String.valueOf(cal.get(Calendar.MINUTE));
		minute = (minute.length() <= 1) ? ("0" + minute) : minute;
		String uniqueNumber = new StringBuffer(year).append(month).append(day).append(hour).append(minute)
				.append(String.valueOf(Math.random() * 3).substring(2, 5)).toString();

		return uniqueNumber;

	}
	
	public static String getUniqueOrderid2() {
		Calendar cal = Calendar.getInstance();
		String year = String.valueOf(cal.get(Calendar.YEAR)).substring(2);
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		month = (month.length() <= 1) ? ("0" + month) : month;
		String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		day = (day.length() <= 1) ? ("0" + day) : day;
		
		String uniqueNumber = new StringBuffer(year).append(month).append(day)
				.append(String.valueOf(Math.random() * 6).substring(2, 8)).toString();

		return uniqueNumber;

	}

	public static synchronized String getUniqueUserid() {
		String uniqueStr = DigestUtils.md5Hex(String.valueOf(System.currentTimeMillis())).toUpperCase();
		return uniqueStr;
	}

	public static synchronized String getVoucherCode() {
		return getUniqueCharAndNumr(10).trim().toUpperCase();
	}

	public static String getTicketCode() {
		return shortCode10(System.currentTimeMillis() + String.valueOf(Math.random() * 3).substring(2, 5)).toUpperCase();
	}

	public static String getProductid() {
		final String PREFIX = "SP-";
		return PREFIX + getUniqueCharAndNumr(10).trim().toUpperCase();
	}
	
	public static String getCategoryCode() {
		final String PREFIX = "SPC";
		return PREFIX + getUniqueCharAndNumr(10).trim().toUpperCase();
	}
	
	public static String getScoreProductid() {
		final String PREFIX = "LSDF-";
		return PREFIX + getUniqueCharAndNumr(10).trim().toUpperCase();
	}

	// trade by front and front
	public static String getTradeidKF() {
		final String PREFIX = "KF";
		return PREFIX + getUniqueUUID().substring(2).trim().toUpperCase();
	}

	// trade by front and front
	public static String getTradeidFF() {
		final String PREFIX = "FF";
		return PREFIX + getUniqueUUID().substring(2).trim().toUpperCase();
	}

	// trade by front and postman
	public static String getTradeidFU() {
		final String PREFIX = "FU";
		return PREFIX + getUniqueUUID().substring(2).trim().toUpperCase();
	}
	
	public static synchronized String getInventoryAllotNo() {
		final String PREFIX = "A-";
		return PREFIX + getUniqueCharAndNumr(10).trim().toUpperCase();
	}

	public static String getUniqueId(String prefix, int length) {
		return prefix + getUniqueCharAndNumr(length).trim().toUpperCase();
	}

	public static synchronized String getUniqueUUID() {
		String uuid = UUID.randomUUID().toString().toUpperCase().replace("-", "");
		return uuid;
	}

	static String getUniqueCharAndNumr(int length) {
		String val = "";

		Random random = new Random();
		for (int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字

			if ("char".equalsIgnoreCase(charOrNum)) // 字符串
			{
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
				String thisChar = String.valueOf((char) (choice + random.nextInt(26)));
				if (StringUtils.equals(thisChar.toUpperCase(), "O") || StringUtils.equals(thisChar.toUpperCase(), "L")
						|| StringUtils.equals(thisChar.toUpperCase(), "I")) {
					i--;
					continue;
				}
				val += thisChar;

			} else if ("num".equalsIgnoreCase(charOrNum)) // 数字
			{
				int thisNum = random.nextInt(10);
				if (thisNum == 0) {
					i--;
					continue;
				}
				val += String.valueOf(thisNum);
			}
		}

		return val;
	}

	static String getUniqueNumr(int length) {
		String val = "";

		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int sNum = random.nextInt(10);
			if (i == 0 && sNum == 0) {
				i--;
				continue;
			}
			val += sNum;
		}

		return val;
	}

	public static void main(String[] args) throws InterruptedException {

		System.out.println(getUniqueOrderid());
//		System.out.println(getUniqueUserid());
//		System.out.println(getUniqueUUID());
//		System.out.println(getUniqueCharAndNumr(16));
//		System.out.println(getTradeidFU());
//		System.out.println(getOrderVcode());
//		System.out.println(getIcode("18610485053" + System.currentTimeMillis()));
//		System.out.println(getTicketCode());
//		System.out.println(getTicketCode());
//		System.out.println(getTicketCode());
//		System.out.println(getTicketCode());
//		System.out.println(getTicketCode());
		//System.out.println(getUniqueOrderid2());
	}

	public static String getLogisticsOpid() {
		return getUniqueUUID();
	}

	public static int getOrderVcode() {
		return (int) ((Math.random() * 9 + 1) * 1000);
	}

	public static String getIcode(String userid) {
		return shortUrl(userid);
	}

	private static String shortUrl(String source) {
		// 可以自定义生成 MD5 加密字符传前的混合 KEY
		final String key = "%#HUYrtYj$UJE%^7";
		// 要使用生成 URL 的字符
		String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v",
				"w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		// 对传入网址进行 MD5 加密
		String hex = DigestUtils.md5Hex(key + source);

		String[] resUrl = new String[4];
		for (int i = 0; i < 4; i++) {

			// 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
			String sTempSubString = hex.substring(i * 8, i * 8 + 8);

			// 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 ,
			// 如果不用long ，则会越界
			long lHexLong = 0x3FFFFFFF & Long.parseLong(sTempSubString, 16);
			String outChars = "";
			for (int j = 0; j < 4; j++) {
				// 把得到的值与 0x0000001F 进行位与运算，取得字符数组 chars 索引
				long index = 0x0000001F & lHexLong;
				// 把取得的字符相加
				outChars += chars[(int) index];
				// 每次循环按位右移 5 位
				lHexLong = lHexLong >> 8;
			}
			// 把字符串存入对应索引的输出数组
			resUrl[i] = outChars;
		}
		Random random = new Random();
		int j = random.nextInt(4);// 产成4以内随机数
		return resUrl[j];
	}

	private static String shortCode10(String source) {
		// 可以自定义生成 MD5 加密字符传前的混合 KEY
		final String key = "%#HUYrtYj$UJE%^7";
		// 要使用生成 URL 的字符
		String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v",
				"w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		// 对传入网址进行 MD5 加密
		String hex = DigestUtils.md5Hex(key + source);

		String[] resUrl = new String[4];
		for (int i = 0; i < 4; i++) {

			// 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
			String sTempSubString = hex.substring(i * 8, i * 8 + 8);

			// 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 ,
			// 如果不用long ，则会越界
			long lHexLong = 0x3FFFFFFF & Long.parseLong(sTempSubString, 16);
			String outChars = "";
			for (int j = 0; j < 10; j++) {
				// 把得到的值与 0x0000001F 进行位与运算，取得字符数组 chars 索引
				long index = 0x0000001F & lHexLong;
				// 把取得的字符相加
				outChars += chars[(int) index];
				// 每次循环按位右移 5 位
				lHexLong = lHexLong >> 3;
			}
			// 把字符串存入对应索引的输出数组
			resUrl[i] = outChars;
		}
		Random random = new Random();
		int j = random.nextInt(4);// 产成4以内随机数
		return resUrl[j];
	}

}
