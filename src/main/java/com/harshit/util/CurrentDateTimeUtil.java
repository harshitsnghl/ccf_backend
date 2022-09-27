package com.harshit.util;

import org.springframework.stereotype.Component;

@Component
public class CurrentDateTimeUtil {
	public String getCurrentDateAndTime() {
		  long millis = System.currentTimeMillis();  
	      
		    // creating a new object of the class Date  
		    java.util.Date date = new java.util.Date(millis);      
		    return date.toString(); 
	}
}
