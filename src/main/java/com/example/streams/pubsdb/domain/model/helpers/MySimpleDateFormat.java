package com.example.streams.pubsdb.domain.model.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MySimpleDateFormat {

	private SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
	
	public Date parse(String dateAsString) {
		
		try {
			return format.parse(dateAsString);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
