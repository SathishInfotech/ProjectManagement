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
}
