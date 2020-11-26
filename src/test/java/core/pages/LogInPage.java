package core.pages;

import core.BaseFunc;
import org.openqa.selenium.By;

import java.util.logging.Logger;

import static org.openqa.selenium.By.*;

public class LogInPage {
    private final By USERNAME = xpath(".//input[@id='ctl00_MainContentPlaceHolder_txtUsername']");
    private final By PASSWORD = xpath(".//input[@id='ctl00_MainContentPlaceHolder_txtPassword']");
    private final By DOMAIN = xpath(".//input[@id='ctl00_MainContentPlaceHolder_txtDomainName']");
    private final By REMEMBER = xpath(".//span[@class='fiori3-checkbox-group']");

    private final By LOGIN = xpath(".//input[@id='ctl00_MainContentPlaceHolder_btnLogin']");

    private final Logger LOGGER = Logger.getLogger(String.valueOf(this.getClass()));
    private BaseFunc baseFunc;

    private String homePageName = "SAP CPQ";
    private String homePageUrl = "https://eusb.webcomcpq.com/login.aspx";

    public LogInPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

        openHomePage();
    }

    public void openHomePage() {
        LOGGER.info("Opening home page: " + homePageName);

        baseFunc.openPage(homePageUrl);

        LOGGER.info("Home page opened successfully!");

    }

    public CatalogPage logIn(String username,String password,String domain) {

        baseFunc.sendKeys(baseFunc.findElement(USERNAME), username);
        baseFunc.sendKeys(baseFunc.findElement(PASSWORD), password);
        baseFunc.sendKeys(baseFunc.findElement(DOMAIN), domain);
        baseFunc.clickByLocator(REMEMBER);
        baseFunc.clickByLocator(LOGIN);

        return new CatalogPage(baseFunc);
    }

}
