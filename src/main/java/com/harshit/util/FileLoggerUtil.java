package com.harshit.util;

import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class FileLoggerUtil {
	private final CurrentDateTimeUtil currentDateTimeUtil;

	public void logRegistration(String email,Boolean status){
    try {
      FileWriter myWriter = new FileWriter("../soar.log");
      myWriter.write("[" + currentDateTimeUtil.getCurrentDateAndTime() + "] " + email + " was" + (status? " ":" not ") + "registered successfully\n");
      myWriter.close();
      log.debug("[" + currentDateTimeUtil.getCurrentDateAndTime() + "] " + email + " was" + (status? " ":" not ") + "registered successfully\n");
    } catch (IOException e) {
      log.error("An error occurred.");
    }
  }
	

	public void logLogin(String email, Boolean status) {
		try {
			FileWriter myWriter = new FileWriter("../soar.log", true);
			myWriter.write("[" + currentDateTimeUtil.getCurrentDateAndTime() + "] " + email + " was" + (status? " ":" not ") + "logged in successfully\n");
			myWriter.close();
			log.debug("[" + currentDateTimeUtil.getCurrentDateAndTime() + "] " + email + " was" + (status? " ":" not ") + "loggen in successfully\n");
		} catch (IOException e) {
			log.error("An error occurred.");
		}
	}
}