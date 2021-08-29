package com.vtiger.vd.genericUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

/**
 * This class contains Java generic libraries
 * 
 * @author Vidyadhara
 *
 */

public class JavaUtility {

	/**
	 * This method is used to generate the integer number randomly with the boundary
	 * value of 0 to 1000
	 * 
	 * @return
	 */

	public int getRandomNumber() {
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		return randomNum;
	}

	/**
	 * This method is used to get the local system date and time
	 * 
	 * @return
	 */
	public String getSystemDate() {
		Date date = new Date();
		String SystemDateAndTime = date.toString();
		return SystemDateAndTime;
	}

	/**
	 * this method is used to get the current System date with format YYYY-MM-DD
	 * 
	 * @return
	 */
	public String getSystemDate_YYYY_MM__DD() {
		Date date = new Date();
		String systemDateAndTime = date.toString();
		System.out.println(systemDateAndTime);
		String[] arr = systemDateAndTime.split(" ");
		String DD = arr[2];
		String YYYY = arr[5];
		int MM = date.getMonth() + 1;

		String finalFormat = YYYY + "-" + MM + "-" + DD;
		return finalFormat;
	}

	/**
	 * this method is used to pass Virtual Key to Operating system
	 * 
	 * @throws Throwable
	 */
	public void pressVirtualEnterKey() throws Throwable {

		Robot rc = new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	}

}
