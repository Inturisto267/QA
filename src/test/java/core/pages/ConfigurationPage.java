package core.pages;

import core.BaseFunc;
import core.enums.Blocks;
import core.enums.Manufacturers;
import core.enums.Standards;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.*;

public class ConfigurationPage {
    private final By ADD_BUTTON = xpath(".//button[@id='addRowBtn_3173']");
    private final By POP_UP_WINDOW = xpath(".//div[@class='modal-body']");
    private final By PRODUCT_LIST = xpath(".//li");
    private final By PRODUCT_LINK = xpath(".//a");
    private final By BLOCK = xpath(".//div[@class='col-xl-3 col-md-4 col-sm-6 col-xs-12']");
    private final By BLOCK_NAME = tagName("label");
    private final By RADIO_BUTTON = xpath(".//span[@data-bind='html: displayValueWithPrices']");

    private final By FP_MANUFACTURER_BLOCK = xpath(".//div[@id='15957']");
    private final By SP_MANUFACTURER_BLOCK = xpath(".//div[@id='16194']");
    private final By FP_STANDARDS_BLOCK = xpath(".//div[@id='15976']");
    private final By SP_STANDARDS_BLOCK = xpath(".//div[@id='16189']");
    private final By DROP_DOWN = tagName("select");
    private final By DD_OPTION = tagName("option");
    private final By FP_STEEL_BLOCK = xpath(".//div[@id='16744']");
    private final By SP_STEEL_BLOCK = xpath(".//div[@id='16502']");
    private final By NOMINAL_BORE_BLOCK = xpath(".//div[@id='16160']");
    private final By NOMINAL_BORE_INPUT = xpath(".//input[@id='2851']");
    private final By SP_OUTER_DIAMETER_INPUT = xpath(".//input[@id='2968']");

    private final By AUTOCOMPLETE = xpath(".//a[@class='ui-corner-all']");
    private final By WALL_THICKNESS = xpath(".//div[@id='16440']");
    private final By WALL_THICKNESS_INPUT = xpath(".//input[@id='2928']");
    private final By UPPER_BUTTON_BLOCK = xpath(".//div[@class='fiori3-configurator-main-actions flex flex-end']");
    private final By SECONDARY_BUTTON = xpath(".//button[@class='btn btn-secondary fiori3-btn-secondary']");
    private final By BUTTON = xpath(".//span");
    private final By FAVORITES = xpath(".//a[@id='addRemoveFavorites']");
    private final By FAVORITES_NAME = xpath(".//input[@id='favoritesName']");
    private final By FAVORITES_DESCRIPTION = xpath(".//input[@id='favoritesDescription']");
    private final By FAVORITES_SAVE = xpath(".//button[@class='btn btn-primary fiori3-btn-primary']");
    private final By CATALOG = xpath(".//a[@aria-label='Каталог']");
    private final String FavoritesSave = "Сохранить";

    private final String FP_LINK_TEXT = "Труба Сварная Водогазопроводная";
    private final String FP_BUTTON_TEXT = "СТЗ";
    private final String FP_STANDARD_TEXT = "ГОСТ 3262-75";
    private final String FP_STEEL_TEXT = "09Г2С";
    private final String FP_BORE_32 = "32";
    private final String FP_WALL_THICKNESS_3_2 = "3.2";


    private final String SP_LINK_TEXT = "Труба Сварная Общего Назначения";
    private final String SP_BUTTON_TEXT = "ТАГМЕТ";
    private final String SP_STANDARD_TEXT = "ГОСТ 10705-80/ ГОСТ 10704-91";
    private final String SP_STEEL_TEXT = "Ст2пс";
    private final String SP_OUTER_DIAMETER_76 = "108";
    private final String SP_WALL_THICKNESS_3_8 = "3.8";


    private final String SAVE = "Save";


    private BaseFunc baseFunc;

    public ConfigurationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void configureProduct() throws InterruptedException {

        baseFunc.isLoaderPresent();
        baseFunc.visibilityByLocator(BLOCK);

        List<WebElement> mans = new ArrayList<WebElement>();
        for (WebElement e : getBlocks()) {
            if (e.findElement(BLOCK_NAME).getText().equals(Blocks.MANUFACTURER.getBlockName())) {
                mans = e.findElements(RADIO_BUTTON);
                break;
            }
        }
        for (WebElement element : mans) {
            if (element.getText().equals(Manufacturers.CT3.getName())) {
                baseFunc.clickOnWebElement(element);
                break;
            }
        }


        baseFunc.isLoaderPresent();


        for (WebElement element : getBlocks()) {
            if (element.findElement(BLOCK_NAME).getText().equals(Blocks.DOCUMENTATION_STANDARD.getBlockName())) {
                System.out.println("good");
                baseFunc.clickOnWebElement(element.findElement(DROP_DOWN));
                List<WebElement> standards = element.findElements(DD_OPTION);
                for (WebElement e : standards) {
                    if (e.getText().equals(Standards.GOST3262_75.getStandard())) {
                        baseFunc.clickOnWebElement(e);
                        break;
                    }
                }
            }
        }

        baseFunc.isLoaderPresent();
        WebElement steel = baseFunc.findElement(FP_STEEL_BLOCK).findElement(DROP_DOWN);
        baseFunc.clickOnWebElement(steel);

        List<WebElement> steels = steel.findElements(DD_OPTION);
        for (WebElement e : steels) {
            if (e.getText().equals(FP_STEEL_TEXT)) {
                baseFunc.clickOnWebElement(e);
                break;
            }
        }

        baseFunc.isLoaderPresent();
        WebElement bore = baseFunc.findElement(NOMINAL_BORE_BLOCK).findElement(NOMINAL_BORE_INPUT);
        baseFunc.clickOnWebElement(bore);

        List<WebElement> bores = baseFunc.findElements(AUTOCOMPLETE);
        System.out.println(bores.size());
        for (WebElement e : bores) {
            System.out.println(e.getText());
            if (e.getText().equals(FP_BORE_32)) {
                baseFunc.clickOnWebElement(e);
                break;
            }
        }

        baseFunc.isLoaderPresent();
        WebElement thickness = baseFunc.findElement(WALL_THICKNESS).findElement(WALL_THICKNESS_INPUT);
        baseFunc.clickOnWebElement(thickness);

        List<WebElement> thicknesses = baseFunc.findElements(AUTOCOMPLETE);
        for (WebElement e : thicknesses) {
            System.out.println(e.getText());
            if (e.getText().equals(FP_WALL_THICKNESS_3_2)) {
                baseFunc.clickOnWebElement(e);
                break;
            }
        }

    }

    public void configureFirstProducts() throws InterruptedException {
        baseFunc.clickByLocator(ADD_BUTTON);

        List<WebElement> links = baseFunc.findElement(POP_UP_WINDOW).findElements(PRODUCT_LIST);
        for (WebElement e : links) {
            System.out.println(e.getText());
            if (e.getText().equals(FP_LINK_TEXT)) {
                e.findElement(PRODUCT_LINK).click();
                break;
            }
        }

        List<WebElement> buttons = baseFunc.findElement(FP_MANUFACTURER_BLOCK).findElements(BUTTON);
        for (WebElement e : buttons) {
            if (e.getText().equals(FP_BUTTON_TEXT)) {
                e.click();
                break;
            }
        }

        Thread.sleep(500);
        WebElement standard = baseFunc.findElement(FP_STANDARDS_BLOCK).findElement(DROP_DOWN);
        baseFunc.clickOnWebElement(standard);

        List<WebElement> standards = standard.findElements(DD_OPTION);
        for (WebElement e : standards) {
            if (e.getText().equals(FP_STANDARD_TEXT)) {
                baseFunc.clickOnWebElement(e);
                break;
            }
        }

        Thread.sleep(500);
        WebElement steel = baseFunc.findElement(FP_STEEL_BLOCK).findElement(DROP_DOWN);
        baseFunc.clickOnWebElement(steel);

        List<WebElement> steels = steel.findElements(DD_OPTION);
        for (WebElement e : steels) {
            if (e.getText().equals(FP_STEEL_TEXT)) {
                baseFunc.clickOnWebElement(e);
                break;
            }
        }

        Thread.sleep(500);
        WebElement bore = baseFunc.findElement(NOMINAL_BORE_BLOCK).findElement(NOMINAL_BORE_INPUT);
        baseFunc.clickOnWebElement(bore);

        List<WebElement> bores = baseFunc.findElements(AUTOCOMPLETE);
        System.out.println(bores.size());
        for (WebElement e : bores) {
            System.out.println(e.getText());
            if (e.getText().equals(FP_BORE_32)) {
                baseFunc.clickOnWebElement(e);
                break;
            }
        }

        Thread.sleep(500);
        WebElement thickness = baseFunc.findElement(WALL_THICKNESS).findElement(WALL_THICKNESS_INPUT);
        baseFunc.clickOnWebElement(thickness);

        List<WebElement> thicknesses = baseFunc.findElements(AUTOCOMPLETE);
        for (WebElement e : thicknesses) {
            System.out.println(e.getText());
            if (e.getText().equals(FP_WALL_THICKNESS_3_2)) {
                baseFunc.clickOnWebElement(e);
                break;
            }
        }

        List<WebElement> secondaryButtons = baseFunc.findElement(UPPER_BUTTON_BLOCK).findElements(SECONDARY_BUTTON);
        for (WebElement e : secondaryButtons) {
            System.out.println(e.getText());
            if (e.getText().equals(SAVE)) {
                baseFunc.moveToElement(e);
                baseFunc.clickOnWebElement(e);
                break;
            }
        }
    }

    public void configureSecondProduct() throws InterruptedException {
        baseFunc.clickByLocator(ADD_BUTTON);

        List<WebElement> links = baseFunc.findElement(POP_UP_WINDOW).findElements(PRODUCT_LIST);
        for (WebElement e : links) {
            System.out.println(e.getText());
            if (e.getText().equals(SP_LINK_TEXT)) {
                e.findElement(PRODUCT_LINK).click();
                break;
            }
        }

        List<WebElement> buttons = baseFunc.findElement(SP_MANUFACTURER_BLOCK).findElements(BUTTON);
        for (WebElement e : buttons) {
            if (e.getText().equals(SP_BUTTON_TEXT)) {
                e.click();
                break;
            }
        }

        Thread.sleep(500);
        WebElement standard = baseFunc.findElement(SP_STANDARDS_BLOCK).findElement(DROP_DOWN);
        baseFunc.clickOnWebElement(standard);

        List<WebElement> standards = standard.findElements(DD_OPTION);
        for (WebElement e : standards) {
            if (e.getText().equals(SP_STANDARD_TEXT)) {
                baseFunc.clickOnWebElement(e);
                break;
            }
        }

        Thread.sleep(500);
        WebElement steel = baseFunc.findElement(SP_STEEL_BLOCK).findElement(DROP_DOWN);
        baseFunc.clickOnWebElement(steel);

        List<WebElement> steels = steel.findElements(DD_OPTION);
        for (WebElement e : steels) {
            if (e.getText().equals(SP_STEEL_TEXT)) {
                baseFunc.clickOnWebElement(e);
                break;
            }
        }

        Thread.sleep(500);
        WebElement diameter = baseFunc.findElement(SP_OUTER_DIAMETER_INPUT);
        baseFunc.clickOnWebElement(diameter);

        List<WebElement> diameters = baseFunc.findElements(AUTOCOMPLETE);
        System.out.println(diameters.size());
        for (WebElement e : diameters) {
            System.out.println(e.getText());
            if (e.getText().equals(SP_OUTER_DIAMETER_76)) {
                baseFunc.clickOnWebElement(e);
                break;
            }
        }

        Thread.sleep(500);
        WebElement thickness = baseFunc.findElement(WALL_THICKNESS_INPUT);
        baseFunc.clickOnWebElement(thickness);

        List<WebElement> thicknesses = baseFunc.findElements(AUTOCOMPLETE);
        for (WebElement e : thicknesses) {
            System.out.println(e.getText());
            if (e.getText().equals(SP_WALL_THICKNESS_3_8)) {
                baseFunc.clickOnWebElement(e);
                break;
            }
        }

        List<WebElement> secondaryButtons = baseFunc.findElement(UPPER_BUTTON_BLOCK).findElements(SECONDARY_BUTTON);
        for (WebElement e : secondaryButtons) {
            System.out.println(e.getText());
            if (e.getText().equals(SAVE)) {
                baseFunc.moveToElement(e);
                baseFunc.clickOnWebElement(e);
                break;
            }
        }

        baseFunc.clickByLocator(FAVORITES);
        baseFunc.sendKeys(baseFunc.findElement(FAVORITES_NAME), "Тест");
        baseFunc.sendKeys(baseFunc.findElement(FAVORITES_DESCRIPTION), "Первый");

        List<WebElement> popUpButtons = baseFunc.findElements(FAVORITES_SAVE);
        for (WebElement e : popUpButtons) {
            System.out.println(e.getText());
            if (e.getText().equals(FavoritesSave)) {
                baseFunc.clickOnWebElement(e);
                break;
            }
        }
    }

    public CatalogPage navigateToCatalog() {
        baseFunc.clickByLocator(CATALOG);
        return new CatalogPage(baseFunc);
    }

    public List<WebElement> getBlocks() {
        baseFunc.visibilityByLocator(BLOCK);
        return baseFunc.findElements(BLOCK);
    }
}
