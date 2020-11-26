package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import static java.util.logging.Logger.*;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class BaseFunc {
    private final By LOADER = xpath(".//div[@class='loaderWrap']");

    private WebDriver driver;
    private WebDriverWait wait;
    private final Logger LOGGER = getLogger(String.valueOf(this.getClass()));

    public BaseFunc() {

        LOGGER.info("Setting up driver's path.");

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        LOGGER.info("Opening new browser.");

        driver = new ChromeDriver();

        LOGGER.info("Maximizing window.");

        driver.manage().window().maximize();

        LOGGER.info("Setting up wait conditions.");

        wait = new WebDriverWait(driver, 30);

        LOGGER.info("WebDriver successfully set up for further work.");
    }

    public void openPage(String url) {
        LOGGER.info("Checking url before proceeding to web-page.");

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

        LOGGER.info("Proceeding to web-page.");

        driver.get(url);
    }

    public List<WebElement> findElements(By locator) {

        LOGGER.info("Finding all WebElements by locator.");

        return driver.findElements(locator);
    }

    public WebElement findElement(By locator) {
        LOGGER.info("Waiting for an element to appear.");

        wait.until(visibilityOfElementLocated(locator));

        LOGGER.info("Finding exact element by locator.");

        return driver.findElement(locator);
    }

    public void clickOnWebElement(WebElement webElement) {
        LOGGER.info("Waiting for WebElement clickable.");
        wait.until(visibilityOf(webElement));

        wait.until(elementToBeClickable(webElement));

        LOGGER.info("Clicking on WebElement.");

        webElement.click();

        LOGGER.info("Clicked on WebElement.");
    }

    public void clickByLocator(By locator) {
        LOGGER.info("Waiting for WebElement clickable.");
        wait.until(visibilityOf(findElement(locator)));

        wait.until(elementToBeClickable(locator));

        LOGGER.info("Clicking on WebElement.");

        findElement(locator).click();

        LOGGER.info("Clicked on WebElement.");
    }

    public boolean isElementPresent(By locator) {
        LOGGER.info("Checking for element presence.");

        try {
            wait.until(visibilityOfElementLocated(locator));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public void visibilityByLocator(By locator){
        wait.until(visibilityOfElementLocated(locator));
    }

    public boolean isLoaderPresent() {
        LOGGER.info("Checking for attribute presence.");

        try {
            wait.until(invisibilityOfElementLocated(LOADER));
            return true;

        } catch (Exception ignore) {
            return false;
        }
    }

    public void sendKeys(WebElement element, String text) {
        Actions action = new Actions(driver);
        action.sendKeys(element, text).build().perform();

    }

    public void moveToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
}
