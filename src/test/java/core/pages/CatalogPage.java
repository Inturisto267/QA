package core.pages;

import core.BaseFunc;
import core.helpers.ItemMapper;
import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.*;

public class CatalogPage {

    private final By CONFIGURATION = xpath(".//a[@href='/Configurator.aspx?pid=1477&cid=400']");
    private final By FAVORITES = xpath(".//a[@href='/Favorites/Favorites.aspx']");
    private final By CATALOG = xpath(".//div[@class='catalog-products fiori3-catalog-products col-md-12']");

    private BaseFunc baseFunc;

    public CatalogPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void openCategory(WebElement element) {
        baseFunc.findElement(CATALOG);
        baseFunc.clickOnWebElement(element);
    }

    public ConfigurationPage configureBundle() {
        baseFunc.clickByLocator(CONFIGURATION);

        return new ConfigurationPage(baseFunc);
    }

    public void getFavorites() throws InterruptedException {
        Thread.sleep(1500);
        baseFunc.clickByLocator(FAVORITES);
    }

    public List<Item> getCatalog(){
        ItemMapper mapper = new ItemMapper(baseFunc);
        List<Item> items = null;
        if (baseFunc.isLoaderPresent()){
            baseFunc.isElementPresent(CATALOG);
            items = mapper.mapCatalogItems();
        }

        return items;
    }

    public List<Item> getItem(){
        ItemMapper mapper = new ItemMapper(baseFunc);
        List<Item> items = null;
        if (baseFunc.isLoaderPresent()){
            baseFunc.isElementPresent(CATALOG);
            items = mapper.mapItems();
        }

        return items;
    }
}
