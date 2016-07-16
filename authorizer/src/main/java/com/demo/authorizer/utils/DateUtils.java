package com.demo.authorizer.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Date parseStringtoDateddmmyyyy(String dateAsString) {
	Date resdate = null;
	if (dateAsString != null && !dateAsString.trim().equals("")) {
	    try {
		DateFormat sourceFormat = new SimpleDateFormat("dd-MM-yyyy");
		resdate = sourceFormat.parse(dateAsString);
		return resdate;
	    } catch (ParseException e) {
		e.printStackTrace();
	    }
	}
	return resdate;
    }

    public static String parseDatetoStringddmmyyy(Date date) {
	if (date != null) {
	    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	    String resultDate = df.format(df);
	    return resultDate;
	} else {
	    return "";
	}
    }
}
