package tests;

import core.BaseFunc;
import core.pages.CatalogPage;
import core.pages.ConfigurationPage;
import core.pages.LogInPage;
import model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FirstTest {

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void catalogInfoCheck() throws InterruptedException {
        String username = "kirils.celebijs@clarity.cx";
        String password = "Kiril726@";
        String domain = "claritylabs";

        LogInPage logInPage = new LogInPage(baseFunc);

        CatalogPage catalogPage = logInPage.logIn(username, password, domain);

        List<Item> catalogItems = catalogPage.getCatalog();
        Assertions.assertEquals("Продукт гибкой конфигурации", catalogItems.get(0).getDescription());
        Assertions.assertEquals("Свободная Конфигурация", catalogItems.get(0).getLink().getText());
        Assertions.assertNotEquals(catalogItems.get(0).getImage().getAttribute("src"), "https://eusb.webcomcpq.com/Cached/v-636886008570000000/mt/CLARITYLABS/images/noimage.gif/");


        Assertions.assertEquals("High Tech Hardware", catalogItems.get(1).getDescription());
        Assertions.assertEquals("Hardware", catalogItems.get(1).getLink().getText());
        Assertions.assertNotEquals(catalogItems.get(1).getImage().getAttribute("src"), "https://eusb.webcomcpq.com/Cached/v-636886008570000000/mt/CLARITYLABS/images/noimage.gif/");

        Assertions.assertEquals("", catalogItems.get(2).getDescription());
        Assertions.assertEquals("Электросварные Прямошовные", catalogItems.get(2).getLink().getText());
        Assertions.assertNotEquals(catalogItems.get(2).getImage().getAttribute("src"), "https://eusb.webcomcpq.com/Cached/v-636886008570000000/mt/CLARITYLABS/images/noimage.gif/");

        Assertions.assertEquals("", catalogItems.get(3).getDescription());
        Assertions.assertEquals("Бесшовные Горячедеформированные", catalogItems.get(3).getLink().getText());
        Assertions.assertNotEquals(catalogItems.get(3).getImage().getAttribute("src"), "https://eusb.webcomcpq.com/Cached/v-636886008570000000/mt/CLARITYLABS/images/noimage.gif/");

        Assertions.assertEquals("", catalogItems.get(4).getDescription());
        Assertions.assertEquals("Холоднодеформированные", catalogItems.get(4).getLink().getText());
        Assertions.assertNotEquals(catalogItems.get(4).getImage().getAttribute("src"), "https://eusb.webcomcpq.com/Cached/v-636886008570000000/mt/CLARITYLABS/images/noimage.gif/");

        Assertions.assertEquals("", catalogItems.get(5).getDescription());
        Assertions.assertEquals("Нержавеющие трубы", catalogItems.get(5).getLink().getText());
        Assertions.assertNotEquals(catalogItems.get(5).getImage().getAttribute("src"), "https://eusb.webcomcpq.com/Cached/v-636886008570000000/mt/CLARITYLABS/images/noimage.gif/");

        Assertions.assertEquals("", catalogItems.get(6).getDescription());
        Assertions.assertEquals("Трубы класса Премиум", catalogItems.get(6).getLink().getText());
        Assertions.assertNotEquals(catalogItems.get(6).getImage().getAttribute("src"), "https://eusb.webcomcpq.com/Cached/v-636886008570000000/mt/CLARITYLABS/images/noimage.gif/");

        Assertions.assertEquals("", catalogItems.get(7).getDescription());
        Assertions.assertEquals("Трубы большого диаметра (ТБД)", catalogItems.get(7).getLink().getText());
        Assertions.assertNotEquals(catalogItems.get(7).getImage().getAttribute("src"), "https://eusb.webcomcpq.com/Cached/v-636886008570000000/mt/CLARITYLABS/images/noimage.gif/");
        Assertions.assertEquals("", catalogItems.get(7).getDescription());

        Assertions.assertEquals("", catalogItems.get(8).getDescription());
        Assertions.assertEquals("Трубы", catalogItems.get(8).getLink().getText());
//        Assertions.assertNotEquals(catalogItems.get(8).getImage().getAttribute("src"), "https://eusb.webcomcpq.com/Cached/v-636886008570000000/mt/CLARITYLABS/images/noimage.gif/");

        Assertions.assertEquals("", catalogItems.get(9).getDescription());
        Assertions.assertEquals("IT Project Examples", catalogItems.get(9).getLink().getText());
//        Assertions.assertNotEquals(catalogItems.get(9).getImage().getAttribute("src"), "https://eusb.webcomcpq.com/Cached/v-636886008570000000/mt/CLARITYLABS/images/noimage.gif/");

        Assertions.assertEquals("Test", catalogItems.get(10).getDescription());
        Assertions.assertEquals("test_test", catalogItems.get(10).getLink().getText());
//        Assertions.assertNotEquals(catalogItems.get(10).getImage().getAttribute("src"), "https://eusb.webcomcpq.com/Cached/v-636886008570000000/mt/CLARITYLABS/images/noimage.gif/");

        Assertions.assertEquals("", catalogItems.get(11).getDescription());
        Assertions.assertEquals("NLMK EU Strip", catalogItems.get(11).getLink().getText());
//        Assertions.assertNotEquals(catalogItems.get(11).getImage().getAttribute("src"), "https://eusb.webcomcpq.com/Cached/v-636886008570000000/mt/CLARITYLABS/images/noimage.gif/");

        Assertions.assertEquals("", catalogItems.get(12).getDescription());
        Assertions.assertEquals("TESTCAT", catalogItems.get(12).getLink().getText());
//        Assertions.assertNotEquals(catalogItems.get(12).getImage().getAttribute("src"), "https://eusb.webcomcpq.com/Cached/v-636886008570000000/mt/CLARITYLABS/images/noimage.gif/");

        catalogPage.openCategory(catalogItems.get(2).getLink());


//        ConfigurationPage configurationPage = catalogPage.configureBundle();
//        configurationPage.configureFirstProducts();
//        configurationPage.configureSecondProduct();
//        configurationPage.navigateToCatalog();
//        catalogPage.getFavorites();

        List<Item> subCategoryItems = catalogPage.getCatalog();
        Assertions.assertEquals("Электросварные Прямошовные", subCategoryItems.get(3).getDescription());
        Assertions.assertEquals("Оцинкованные", subCategoryItems.get(3).getLink().getText());
        Assertions.assertNotEquals(subCategoryItems.get(3).getImage().getAttribute("src"), "https://eusb.webcomcpq.com/Cached/v-636886008570000000/mt/CLARITYLABS/images/noimage.gif/");
        catalogPage.openCategory(subCategoryItems.get(3).getLink());

        List<Item> subSubCategoryItems = catalogPage.getCatalog();
        Assertions.assertEquals("Электросварные Прямошовные. Оцинкованные", subSubCategoryItems.get(0).getDescription());
        Assertions.assertEquals("Водогазопроводные (ВГП)", subSubCategoryItems.get(0).getLink().getText());
        Assertions.assertNotEquals(subSubCategoryItems.get(0).getImage().getAttribute("src"), "https://eusb.webcomcpq.com/Cached/v-636886008570000000/mt/CLARITYLABS/images/noimage.gif/");
        catalogPage.openCategory(subSubCategoryItems.get(0).getLink());

        List<Item> items = catalogPage.getItem();
        Assertions.assertEquals("Труба Сварная Водозагопроводная Оцинкованная", items.get(0).getDescription());
        Assertions.assertEquals("Труба Сварная Водозагопроводная Оцинкованная", items.get(0).getLink().getText());
        Assertions.assertNotEquals(items.get(0).getImage().getAttribute("src"), "https://eusb.webcomcpq.com/Cached/v-636886008570000000/mt/CLARITYLABS/images/noimage.gif/");
        catalogPage.openCategory(items.get(0).getConfiguration());
        ConfigurationPage configurationPage = new ConfigurationPage(baseFunc);
        configurationPage.configureProduct();

    }
}
