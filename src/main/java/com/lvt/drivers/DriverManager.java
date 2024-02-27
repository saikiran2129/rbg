package com.lvt.drivers;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;



import io.appium.java_client.AppiumDriver;

public abstract class DriverManager {

 protected static final ThreadLocal<WebDriver> driver = new InheritableThreadLocal<>();
 private static final ThreadLocal<AppiumDriver> mbDriver = new InheritableThreadLocal<>();

 protected static final Logger logger = Logger.getLogger(DriverManager.class);
 public static void setMbDriver(AppiumDriver appium) {
  mbDriver.set(appium);
 }
	
 public static AppiumDriver getMbDriver(){
  return mbDriver.get();
 }
	
 public static void setIbDriver(WebDriver web) {
  driver.set(web);
 }
	
 public static WebDriver getIbDriver(){
  return driver.get();
 }	
	
 protected abstract void startService();

 protected abstract void stopService();

 protected abstract void createDriver();

 protected String platform;


 public void quitWebDriver() {
  if (driver != null) {
   getIbDriver().quit();
   setIbDriver(null);
  }
 }

 public WebDriver getWebDriver() {

  if (getIbDriver() == null) {
   createDriver();
  }

  return getIbDriver();
 }

 public void quitMobileDriver() {
  if (getMbDriver() != null) {
   getMbDriver().quit();
   setMbDriver(null);
   
  }
 }

 public AppiumDriver getMobileDriver() {
  if (getMbDriver() == null) {
   createDriver();
  }
  return getMbDriver();
 }

 public AppiumDriver getMobileDriver(String platformName) {
  this.platform = platformName; 
  if (getMbDriver() == null) {
   createDriver();
  }
  return getMbDriver();
 }
}