package com.surveillance.utilitiy;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericKeywordsWithPage extends ApplicationKeywords {
	public static Xls_Reader workBook;
	public static int dataRowNumber;
	public static Hashtable<String, String>[][] datadrive;
	public static Hashtable<String, String> getDataFromWorkBook;

	public GenericKeywordsWithPage(String classname) {
		System.out.println("GenericKeywords class Name: " + classname);
		logger = Logger.getLogger(classname);
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/ConfigProperties/log4j.properties");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hhmmss");
		System.setProperty("current.date", classname + "_" + dateFormat.format(new Date()));
	}

	/**
	 * Method Name : openBrowser purpose : Opens the specified browser.
	 * parameters : browserName Example : firefox
	 */
	public void openBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			if (System.getProperty("os.name").equalsIgnoreCase("Linux")) {
				logger.info("openBrowser action is started");
				System.setProperty("webdriver.chrome.driver", "/webDrivers/chromedriver_Linux");
				ChromeOptions opt = new ChromeOptions();
				opt.setBinary("/usr/bin/google-chrome-stable"); // chrome binary
																// location
																// specified
																// here
				opt.addArguments("start-maximized", "--disable-gpu", "--no-sandbox", "--disable-extensions",
						"--disable-dev-shm-usage", "--headless");
				opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				opt.setExperimentalOption("useAutomationExtension", false);
				driver = new ChromeDriver(opt);
			} else if (System.getProperty("os.name").contains("mac")) {
				logger.info("openBrowser action is started");
				System.setProperty("webdriver.chrome.driver", "/webDrivers/chromedriver_mac");
			} else {
				logger.info("openBrowser action is started");
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/webDrivers/chromedriver.exe");
				/*
				 * ChromeOptions co = new ChromeOptions();
				 * co.addArguments("--remote-allow-origins=*"); driver = new
				 * ChromeDriver(co);
				 */
			}

		} else if (browserName.equalsIgnoreCase("Jenkins")) {

			logger.info("openBrowser action is started");
			System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/tools/chromedriver/chromedriver");
			ChromeOptions opt = new ChromeOptions();
			opt.setBinary("/usr/bin/google-chrome-stable"); // chrome binary
															// location
															// specified here
			opt.addArguments("start-maximized", "--disable-gpu", "--no-sandbox", "--disable-extensions",
					"--disable-dev-shm-usage", "--headless");
			opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			opt.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(opt);

		} else if (browserName.equalsIgnoreCase("IE")) {

			/*
			 * DesiredCapabilities capabilities =
			 * DesiredCapabilities.htmlUnit();
			 * capabilities.setCapability("requireWindowFocus", true);
			 * capabilities.setCapability(InternetExplorerDriver.
			 * IGNORE_ZOOM_SETTING, false);
			 * capabilities.setCapability("ie.ensureCleanSession", true);
			 */
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "/webDrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		} else if (browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "/webDrivers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/webDrivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		/*
		 * driver.manage().deleteAllCookies();
		 * System.out.println(driver.manage().window().getSize()); Dimension d =
		 * new Dimension(1936, 1056); Resize the current window to the given
		 * dimension driver.manage().window().setSize(d);
		 */
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		logger.info(browserName + " launched successfully");
	}

	/**
	 * Method Name : selectParentWindow purpose : gets back to the previous
	 * window. parameters : - Example : Example : -
	 */
	public void selectParentWindow() {

		driver.switchTo().window(parentWindowID);
		logger.debug("Switching to parent window");
		logger.info("Switching to parent window");
		logger.warn("Switching to parent window");
		logger.error("Switching to parent window");
		logger.fatal("Switching to parent window");
	}

	/**
	 * Method Name : elementFind purpose : finds the webelement based on the
	 * loactor value. parameters : element Example : Example : <xpath>,
	 * <//*[@id='tabletoolbar']>
	 */

	public WebElement elementFind(WebElement element) {

		logger.info("find element action is started");

		try {
			logger.info("find element action is complted and avialable");
		} catch (Throwable e) 
		{
			logger.info("element is not found:" + e);
		}

		return element;

	}

	/**
	 * Method Name : openURL purpose : opens the application. parameters : data
	 * Example : <http://rcovlnx0334:9001/ECSWeb/>
	 */
	public void openURL(String URL) {
		logger.info("Enter the URL action is started");
		driver.get(URL);
		logger.info(URL + " opened successfully");

	}

	/**
	 * Method Name : click purpose : clicks on the web element. parameters
	 * :element Example : Example : <xpath>,<//*[@id='tabletoolbar']>
	 */
	public void submitButton(WebElement element) {
		logger.info("click action is started");

		highlightElement(element);
		elementFind(element).submit();
		logger.info("click action is Completed");
	}

	/**
	 * Method Name : click purpose : clicks on the web element. parameters
	 * :element Example : Example : <xpath>,<//*[@id='tabletoolbar']>
	 */
	public void click(WebElement element) {
		logger.info("click action is started");

		highlightElement(element);
		elementFind(element).click();
		logger.info("click action is Completed");
	}

	/**
	 * Method Name : enterData purpose : To identify an element and enter the
	 * data parameters : locator type,locator value , data Example
	 * :<xpath>,<//input[@id='email']>,<Data>
	 */
	public void enterData(WebElement element, String data) {

		logger.info("enter data action is started");
		highlightElement(element);
		elementFind(element).sendKeys(data);
		logger.info("enter data action is Completed");
	}

	/**
	 * Method Name : enterData purpose : To identify an element and enter the
	 * data parameters : locator type,locator value , data Example
	 * :<xpath>,<//input[@id='email']>,<Data>
	 */
	public void alertclick(WebElement element) {
		logger.info("alert popwindow started");
		elementFind(element).click();
		logger.info("alert popwindow ended stared New account");
	}

	public void JSenterData(WebElement element, String data) {

		logger.info("enter data action is started");
		highlightElement(element);
		element = elementFind(element);
		// This will enable this element if element is invisible

		/*
		 * String js =
		 * "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';"
		 * ; // String js="document.getElementById('"+locatorvalue+
		 * "').style.display='block';";
		 * 
		 * // Execute the Java Script for the element which we find out
		 * ((JavascriptExecutor) driver).executeScript(js, element);
		 * element.click();
		 */

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.getElementById('elementID').setAttribute('value', 'new value for element');",
				element);
		logger.info("enter data action is Completed");
	}

	/**
	 * Method Name : highlightElement purpose : To highlight the element with
	 * red color parameters : locator type,locator value Example
	 * :<xpath>,<//input[@id='email']>
	 */
	public void highlightElement(WebElement element) {
		logger.info("highlightElement action is started");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		element = elementFind(element);
		executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
		System.out.println("highlight finished");
		logger.info("highlightElement action is Completed");

	}

	/**
	 * Method Name : SelectDropDown purpose : Selecting the values form drop
	 * based on the data parameters : locator type,locator value ,data Example :
	 * Example :<xpath>,<//input[@id='email']>,<TXTData>
	 */
	public void SelectDropDown(WebElement element, String data) {
		logger.info("SelectDropDown action is started");
		highlightElement(element);
		element = elementFind(element);
		System.out.println("Drop down is Reached");
		Select dropdown = new Select(element);
		System.out.println("Drop down selected");
		System.out.println(data);
		dropdown.selectByVisibleText(data);
		logger.info("SelectDropDown action is completed");

	}

	public void SelectDropDownByIndex(WebElement element, int index) {
		logger.info("SelectDropDown action is started");
		highlightElement(element);
		element = elementFind(element);
		System.out.println("Drop down is Reached");
		Select dropdown = new Select(element);
		System.out.println("Drop down selected");
		dropdown.selectByIndex(index);
		logger.info("SelectDropDown action is completed");

	}

	/**
	 * Method Name : SelectDropDown purpose : Selecting the values form drop
	 * based on the data parameters : locator type,locator value ,data Example :
	 * Example :<xpath>,<//input[@id='email']>,<TXTData>
	 */
	/*
	 * public void SelectALLDropDown(WebElement element, String data) {
	 * logger.info("SelectDropDown action is started");
	 * highlightElement(element); WebElement element = elementFind(element);
	 * System.out.println("Drop down is Reached"); Select dropdown = new
	 * Select(element); System.out.println("Drop down selected");
	 * System.out.println(data); dropdown.selectByVisibleText(data);
	 * logger.info("SelectDropDown action is completed");
	 * 
	 * }
	 */
	/**
	 * Method Name : verifyDropDownVisibleText purpose : checks whether "Web
	 * page data matching with expected data or not in a dropdown. parameters :
	 * locator type,locator value, data Example
	 * :<xpath>,<//input[@id='email']>,<logOff>
	 */
	public String verifyDropDownVisibleText(WebElement element, String data) throws Exception {
		logger.info("verifyDropDownVisibleText action is started");
		highlightElement(element);
		element = elementFind(element);
		Select dropdown = new Select(element);
		String elementText = dropdown.getFirstSelectedOption().getText();

		if (elementText.equals(data)) {
			System.out.println("Web page data matching with expected data");
		} else {
			throw new Exception("Data is not maching");
		}
		logger.info("verifyDropDownVisibleText action is completed");
		return elementText;
	}

	public String getDropDownVisibleText(WebElement element) throws Exception {
		logger.info("verifyDropDownVisibleText action is started");
		highlightElement(element);
		element = elementFind(element);
		Select dropdown = new Select(element);
		String elementText = dropdown.getFirstSelectedOption().getText();
		logger.info("verifyDropDownVisibleText action is completed");
		return elementText;
	}

	public void deSelectAll(WebElement element) throws Exception {
		logger.info("verifyDropDownVisibleText action is started");
		highlightElement(element);
		element = elementFind(element);
		Select dropdown = new Select(element);
		dropdown.deselectAll();

	}

	public void selectAllOptions(WebElement element) {
		logger.info("verifyDropDownVisibleText action is started");
		highlightElement(element);
		element = elementFind(element);
		Select select = new Select(element);
		select.deselectAll();

		List<WebElement> select31Options = select.getOptions();

		for (WebElement option : select31Options) {
			select.selectByVisibleText(option.getText());
		}
	}

	/**
	 * Method Name : selectWindow purpose : Selecting the window based on the
	 * title parameters : data Example : <Data>
	 */
	public void selectWindow(String title) {
		parentWindowID = driver.getWindowHandle(); // will keep current window
													// to switch back
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			String secondTitle = driver.getTitle();
			System.out.println("secondTitle :" + secondTitle);
			if (secondTitle.equals(title)) {
				break;
			}
		}
	}

	/**
	 * Method Name : pageTitle purpose : Selecting the title parameters : data
	 * Example : <Data>
	 */
	public String pageTitle() {
		logger.info("pageTitle action is Started");
		String Title = driver.getTitle();
		logger.info("pageTitle action is completed");
		return Title;
	}

	/**
	 * Method Name : verifyTitle purpose : verifying the title of window
	 * parameters : data Example : Example
	 * :<xpath>,<//input[@id='email']>,<TXTData>
	 */
	public void verifyTitle(String expectedtitle) throws Throwable {
		logger.info("verifyTitle action is Started");
		String actualtitle = driver.getTitle();
		if (actualtitle.equals(expectedtitle)) {
			System.out.println("title was matched");
		} else {
			throw new Exception("title was not matched");
		}
		logger.info("verifyTitle action is completed");
	}

	/**
	 * Method Name : selectFrame purpose : verifying the title of window
	 * parameters : data Example : Example
	 * :<xpath>,<//input[@id='email']>,<TXTData>
	 */
	public void selectFrame(String data) {

		String selectionType = data.substring(0, 3);
		String selectionValue = data.substring(3);
		if (selectionType.equals("IND")) {
			int index = Integer.parseInt(selectionValue);
			driver.switchTo().frame(index);
		} else if (selectionType.equals("NAM")) {
			driver.switchTo().frame(selectionValue);
		}

	}

	/**
	 * Method Name : checkClick purpose : checks whether the element is
	 * displayed, enabled and select or deselect the checkbox based on the data
	 * parameters : locator type,locator value, data Example
	 * :<xpath>,<//input[@id='email']>,<ON>
	 */
	public void checkClick(WebElement element, String data) {
		logger.info("checkClick action is Started");

		highlightElement(element);
		element = elementFind(element);

		if (data.equalsIgnoreCase("ON")) {
			if (element.isDisplayed() == true) {
				if (element.isEnabled() == true) {
					if (element.isSelected() == false) {

						element.click();
					} else if (element.isSelected() == true) {

					}
				}
			}

			else if (data.equalsIgnoreCase("OFF")) {
				if (element.isDisplayed() == true) {
					if (element.isEnabled() == true) {
						if (element.isSelected() == true) {
							element.click();

						}
					}
				}

				else if (element.isDisplayed() == true) {
					if (element.isEnabled() == true) {
						if (element.isSelected() == false) {

						}
					}
				}
			}
		}
		logger.info("checkClick action is completed");
	}

	/**
	 * Method Name : verifySelect purpose : Clicks the element if it is
	 * displayed and enabled. parameters : locator type,locator value Example
	 * :<xpath>,<//input[@id='email']>
	 */
	public void verifySelect(WebElement element) {
		logger.info("verifySelect action is Started");

		highlightElement(element);
		element = elementFind(element);
		if (element.isDisplayed() == true) {
			if (element.isEnabled() == true) {
				element.click();

			}
		}
		logger.info("verifySelect action is completed");
	}

	/**
	 * Method Name : clearEnter purpose : clears the previous data in the text
	 * box and enters the given data. parameters : locator type,locator value,
	 * data Example :<xpath>,<//input[@id='email']>,<xyz>
	 */
	public void clearEnter(WebElement element, String data) {
		highlightElement(element);
		element = elementFind(element);
		if (element.isDisplayed() == true) {
			if (element.isEnabled() == true) {
				element.clear();
				element.sendKeys(data);

			}
		}
		logger.info("clear and enter data is : " + data);
		logger.info("clear and enter action is completed");
	}

	/**
	 * Method Name : clearEnter purpose : clears the previous data in the text
	 * box and enters the given data. parameters : locator type,locator value,
	 * data Example :,<xyz>
	 * 
	 * @throws Throwable
	 */
	public void EntertextInAlert(String data) throws Throwable {
		System.out.println("alert text " + data);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(data);
		// String str = data;
		// Toolkit toolkit = Toolkit.getDefaultToolkit();
		// Clipboard clipboard = toolkit.getSystemClipboard();
		// StringSelection strSel = new StringSelection(str);
		// clipboard.setContents(strSel, null);
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).sendKeys("v");

		logger.info("Alert enter text action is completed");
	}

	/**
	 * Method Name : radioClick purpose : checks whether the element is
	 * displayed, enabled and select the radio button if it is not selected.
	 * parameters : locator type,locator value Example
	 * :<xpath>,<//input[@id='email']>
	 */
	public void radioClick(WebElement element) {
		// try
		// {
		// Thread.sleep(5000);
		// }
		// catch (Exception e1)
		// {
		//
		// }
		highlightElement(element);
		element = elementFind(element);
		if (element.isDisplayed() == true) {
			if (element.isEnabled() == true) {
				if (element.isSelected() == true) {
					System.out.println("radiobutton is already selected");
				} else if (element.isSelected() == false) {
					element.click();
				}
			}
		}

	}

	/**
	 * Method Name : putData purpose : gets the text present in the given
	 * location and stores it in the hashtable. parameters : locator
	 * type,locator value, data Example :<xpath>,<//input[@id='email']>,<logOff>
	 */
	public void putData(WebElement element, String data) {
		highlightElement(element);
		highlightElement(element);
		element = elementFind(element);
		String value = element.getText();
		hashtable.put(data, value);
	}

	/**
	 * Method Name : verifyText purpose : gets the text present in the given
	 * location and compares it with the data given. parameters : locator
	 * type,locator value, data Example :<xpath>,<//input[@id='email']>,<logOff>
	 */
	public String verifyText(WebElement element, String data) throws Exception {
		highlightElement(element);
		element = elementFind(element);
		String elementText = element.getText();
		System.out.println(data + "     " + elementText);
		if (elementText.equals(data)) {
			System.out.println("Web page data matching with expected data");
		} else {
			if (data.endsWith(".0")) {
				data = data.substring(0, data.length() - 1);
				if (elementText.equals(data)) {
					System.out.println("Web page data matching with expected data");
				}
			} else {
				throw new Exception("Data is not maching");
			}
		}

		return elementText;
	}

	/**
	 * Method Name : verifyText purpose : gets the text present in the given
	 * location and compares it with the data given. parameters : locator
	 * type,locator value, data Example :<xpath>,<//input[@id='email']>,<logOff>
	 */
	public boolean verifyContainsText(WebElement element, String data) throws Exception {
		boolean elemetvrify = true;
		highlightElement(element);
		element = elementFind(element);
		String elementText = element.getText();
		System.out.println(data + "     " + elementText);
		if (elementText.contains(data)) {
			System.out.println("Web page data matching with expected data");
		} else {

			throw new Exception("Data is not maching");
		}

		return elemetvrify;
	}

	/**
	 * Method Name : verify purpose : gets the text present in the given
	 * location and compares it with the data given. parameters : locator
	 * type,locator value, data Example :<xpath>,<//input[@id='email']>,<logOff>
	 */
	public String verify(WebElement element, String data) throws Exception {

		element = elementFind(element);
		String elementText = element.getText();

		if (elementText.equals(data)) {
			System.out.println("Web page data matching with expected data");
		} else {

			throw new Exception("Data is not maching");
		}

		return elementText;
	}

	/**
	 * Method Name : GetText purpose : gets the text present in the given
	 * location and compares it with the data given. parameters : locator
	 * type,locator value, data Example :<xpath>,<//input[@id='email']>,<logOff>
	 */
	public String getText(WebElement element) throws Exception {
		logger.info("getText Action started");
		element = elementFind(element);
		String elementText = element.getText();
		logger.info("GetText value is : " + elementText);
		return elementText;

	}

	// public List<String> getTextList(WebElement element) throws Exception {
	// logger.info("getText Action started");
	// List<WebElement> element = elementsFind(element);
	// List<String> elementText = element.getTextList();
	// logger.info("GetText value is : " + elementText);
	// return elementText;
	//
	// }
	public String getLinkText(WebElement element) throws Exception {
		logger.info("getText Action started");
		element = elementFind(element);
		String element2 = element.getText();
		logger.info("GetText value is : " + element2);
		return element2;
	}

	/**
	 * Method Name : verifyTextwithColon purpose : gets the text present in the
	 * given location and compares it with the data given, by removing the colon
	 * at the end. parameters : locator type,locator value, data Example
	 * :<xpath>,<//input[@id='email']>,<logOff>
	 */
	public String verifyTextwithColon(WebElement element, String data) throws Exception {
		highlightElement(element);
		element = elementFind(element);
		String elementText = element.getText();
		if (elementText.endsWith(":")) {
			elementText = elementText.split(":")[0];
		}

		if (elementText.equals(data)) {
			System.out.println("Web page data matching with expected data");
		} else {
			throw new Exception("Data is not maching");
		}

		return elementText;
	}

	/**
	 * Method Name : verifyToolTipData purpose : gets the text present on the
	 * button in the given location and compares it with the data given.
	 * parameters : locator type,locator value, data Example
	 * :<xpath>,<//input[@id='email']>,<logOff>
	 */
	public String verifyToolTipData(WebElement element, String data) throws Exception {
		highlightElement(element);
		element = elementFind(element);
		Actions tootip = new Actions(driver);
		tootip.moveToElement(element).perform();
		Thread.sleep(1000);
		String elementText = element.getAttribute("title");

		if (elementText.equals(data)) {
			System.out.println("Web page data matching with expected data");
		} else {
			throw new Exception("Data is not maching");
		}

		return elementText;
	}

	/**
	 * Method Name : Getattribute purpose : gets the text present on the button
	 * in the given location and compares it with the data given. parameters :
	 * locator type,locator value, data Example
	 * :<xpath>,<//input[@id='email']>,<logOff>
	 */
	public String getAttribute(WebElement element, String attributeKey) throws Exception {
		highlightElement(element);
		element = elementFind(element);
		String elementText = element.getAttribute(attributeKey);
		return elementText;
	}

	/**
	 * Method Name : verifyToolTipData purpose : gets the text present on the
	 * button in the given location and compares it with the data given.
	 * parameters : locator type,locator value, data Example
	 * :<xpath>,<//input[@id='email']>,<logOff>
	 */
	public void movetoElement(WebElement element) throws Exception {
		highlightElement(element);
		element = elementFind(element);
		Actions tootip = new Actions(driver);
		tootip.moveToElement(element).perform();

	}

	/**
	 * Method Name : jsClick purpose : clicks on the element usi
	/**
	 * Method Name : jsClick purpose : clicks on the element using javascript.
	 * parameters : locator type,locator value Example
	 * :<xpath>,<//input[@id='email']>
	 */
	public void jsClick(WebElement element) {
		highlightElement(element);
		element = elementFind(element);
		// This will enable this element if element is invisible

		/*
		 * String js =
		 * "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';"
		 * ; // String js="document.getElementById('"+locatorvalue+
		 * "').style.display='block';";
		 * 
		 * // Execute the Java Script for the element which we find out
		 * ((JavascriptExecutor) driver).executeScript(js, element);
		 * element.click();
		 */

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	/**
	 * Method Name : verifyAlertText purpose : gets the text present in the
	 * alert box and compares it with the data given. parameters : locator
	 * type,locator value, data Example :<xpath>,<//input[@id='email']>,<logOff>
	 */
	public void verifyAlertText(String data) {
		String actualText = driver.switchTo().alert().getText();

		if (data.equals(actualText)) {
			System.out.println("Alert Data got matched");

		} else {
			System.out.println("Alert Data not matched");
		}
	}

	public String getAlertText() {
		logger.info("getAlertText action is started");
		String actualText = driver.switchTo().alert().getText();
		logger.info("getAlertText action is completed");
		return actualText;

	}

	/**
	 * Method Name : handleAlert purpose : Based on the given data accepts or
	 * dismiss the alert. parameters : data Example : <accept>
	 */
	public void handleAlert(String data) {
		if (data.equals("accept")) {
			driver.switchTo().alert().accept();
			System.out.println("ALERT ACCPTING");
		} else if (data.equals("dismiss")) {
			driver.switchTo().alert().dismiss();

		}
	}

	/**
	 * Method Name : isSelected purpose : Based on the data and checkbox is
	 * selected or not, It throws Exception. parameters : locator type,locator
	 * value, data Example :<xpath>,<//input[@id='email']>,<selected>
	 */
	public void isSelected(WebElement element, String data) throws Throwable {
		highlightElement(element);
		element = elementFind(element);
		if (data.equals("selected")) {
			if (element.isSelected() == true) {

			} else if (element.isSelected() == false) {

				throw new Exception("webelemnt was not selected");
			}
		} else if (data.equals("deselected")) {
			if (element.isSelected() == false) {

			} else if (element.isSelected() == false) {

				throw new Exception("webelemnt was selected");
			}
		}
	}

	/**
	 * Method Name : isdisplay purpose : Based on the data and webelement is
	 * displayed or not, It throws Exception. parameters : locator type,locator
	 * value, data Example : <xpath>,<//input[@id='email']>,<true>
	 */
	public boolean isdisplay(WebElement element, String data) throws Throwable {
		highlightElement(element);
		element = elementFind(element);
		if (data.equals("display")) {
			if (element.isDisplayed() == true) {

				return true;
			} else if (element.isDisplayed() == false) {

				throw new Exception("webelemnt was not selected");
			}
		} else if (data.equals("notToDisplay")) {
			if (element.isDisplayed() == false) {

				return true;
			} else if (element.isDisplayed() == true) {

				throw new Exception("webelemnt is Displayed");
			}
		}
		return false;
	}

	/**
	 * Method Name : waiting purpose : Pauses the execution for a mentioned
	 * time. parameters : data Example : <2000>
	 */
	public void waiting(String time) throws Throwable {
		float time2 = Float.parseFloat(time);
		int timeforWait = (int) time2;

		Thread.sleep(timeforWait);

	}

	/**
	 * Method Name : dragAndDrop purpose : drags an object from source and drops
	 * it at the target(same as cut and paste). parameters : locator
	 * type,locator value, data Example :
	 * <xpath>,<//input[@id='email']>,<//input[@id='email']://input[@id='password']>
	 */
	// public void dragAndDrop(WebElement element, String sourceAndTaret) {
	// String locators[] = locatorvalue.split("::");
	// String sourcevalue = locators[0];
	//
	// String targetvalue = locators[1];
	//
	// WebElement source = elementFind(locatorindicator, sourcevalue);
	// WebElement target = elementFind(locatorindicator, targetvalue);
	// Actions action = new Actions(driver);
	// action.dragAndDrop(source, target).perform();
	//
	// }

	/**
	 * Method Name : rightClick purpose : Right clicks on the given element.
	 * parameters : locator type,locator value Example :
	 * <xpath>,<//input[@id='email']>
	 */
	public void rightClick(WebElement element) {
		element = elementFind(element);
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * Method Name : waitForInvisible purpose : waits for the element until it
	 * is visible upto a maximum time of 30 seconds . parameters : locator value
	 * Example : <//input[@id='email']>
	 */
	public void waitForInvisible(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));

		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		}
	}

	/**
	 * Method Name : clickForAlert purpose : clicks on the element in alert box
	 * if alert is displayed . parameters : locator type,locator value Example :
	 * <xpath>,<//input[@id='email']>
	 */
	public void clickForAlert(WebElement element) {
		try {
			click(element);
		} catch (Exception e1) {
			System.out.println("Alert is not displaying");
		}

	}

	/**
	 * Method Name : docCreationConfig purpose : parameters : locator
	 * type,locator value, data Example : <xpath>,<//input[@id='email']>,<>
	 */

	/**
	 * Method Name : clearAndTabout purpose : clears the data in the text box.
	 * parameters : locator type,locator value Example :
	 * <xpath>,<//input[@id='email']>
	 */
	public void clearAndTabout(WebElement element) {
		highlightElement(element);
		element = elementFind(element);
		element.clear();
		System.out.println("Data Cleared");
		try {
			// element.sendKeys(Keys.TAB);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void Tabout(WebElement element) {
		highlightElement(element);
		element = elementFind(element);
		try {
			element.sendKeys(Keys.TAB);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Method Name : closeWindow purpose : closes the browser. parameters : -
	 * Example : -
	 */
	public void closeWindow() {
		driver.close();
	}

	/**
	 * Method Name : closeWindow purpose : closes the browser. parameters : -
	 * Example : -
	 */
	public void quitWindow() {
		driver.quit();
	}

	/**
	 * Method Name : BrowserSettings purpose : parameters : - Example : -
	 */
	public boolean BrowserSettings() {
		return true;
	}

	public static String TimeStampFolder() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd/");
		String format = dateFormat.format(new Date());

		return format;

	}

	public static String TimeStamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		String format = dateFormat.format(new Date());

		return format;

	}

	public void keyEnter() {
		// driver.findElement(By.id("Value")).sendKeys(Keys.ENTER);
		Actions action = new Actions(driver);
		// action.sendKeys(Keys.ENTER).build().perform();
		action.sendKeys(Keys.TAB).build().perform();
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This will scroll down the page by 1000 pixel vertical
		js.executeScript("window.scrollBy(0,1000)");
	}

	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This will scroll up the page by 1000 pixel vertical
		js.executeScript("window.scrollBy(0,-1000)");
	}

	public void scrollElementfound(WebElement element) throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Find element and store in variable "Element"
		WebElement Element = elementFind(element);

		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	// Page refresh
	public void refreshURL() {
		driver.navigate().refresh();
	}

	public void fileDownload() {
		String downloadFilepath = (System.getProperty("user.dir") + "/Downlods/" + GenericKeywords.TimeStampFolder());
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--test-type");
		options.addArguments("--disable-extensions"); // to disable browser
														// extension popup
		// options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	}

	public boolean isEnabled(WebElement element) {
		logger.info("isEnabled action is started");
		highlightElement(element);
		Boolean Element = elementFind(element).isEnabled();
		logger.info("isEnabled action is Completed");
		return Element;
	}

	public boolean isDisplayed(WebElement element) {
		logger.info("isDisplaed action is started");
		highlightElement(element);
		Boolean Element = elementFind(element).isDisplayed();
		logger.info("isDisplaed action is Completed");
		return Element;
	}

	public void waitForPageLoad() {

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				System.out.println("Current Window State       : "
						+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

	// public WebElement searchForElement(String replaceData)
	// {
	// driver.findElement(By.xpath(""));
	// }
	//

	/**
	 * Method Name : dragAndDrop purpose : drags an object from source and drops
	 * it at the target(same as cut and paste). parameters : locator
	 * type,locator value, data Example :
	 * <xpath>,<//input[@id='email']>,<//input[@id='email']://input[@id='password']>
	 */
	public void dragAndDrop(WebElement source, WebElement target) {

		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();

	}

}