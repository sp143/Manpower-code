package com.sp.manpwr.util;

import java.sql.Date;

public class Utility {

	public static Date stringToSQLDate(String dateStr) {
		Date date = Date.valueOf(dateStr);
		return date;

	}

	public static Date utilDateToSqlDate(java.util.Date date) {
		Date sqlDate = new Date(date.getTime());
		return sqlDate;

	}

}
