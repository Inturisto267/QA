package core.helpers;

import core.BaseFunc;
import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.*;

public class ItemMapper {

    private final By CATALOG_CONTAINER = xpath(".//div[@class='categories-tabular col-xl-3 col-lg-4 col-md-6 col-sm-6 col-xs-12']");
    private final By ITEM_CONTAINER = xpath(".//div[contains(@id,'prodTabular')]");
    private final By CONFIGURE = xpath(".//div[@class='config-button tooltip-trigger']");

    private final By LINK = tagName("h3");
    private final By DESCRIPTION = tagName("p");
    private final By IMAGE = tagName("img");

    private BaseFunc baseFunc;

    public ItemMapper(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public List<Item> mapCatalogItems(){
        List<Item> items = new ArrayList<Item>();
        baseFunc.visibilityByLocator(CATALOG_CONTAINER);
        List<WebElement> elements = baseFunc.findElements(CATALOG_CONTAINER);

        for (WebElement e:elements) {
            Item item = new Item();
            item.setLink(e.findElement(LINK));
            item.setDescription(e.findElement(DESCRIPTION).getText());
            item.setImage(e.findElement(IMAGE));
            items.add(item);
        }

        return items;
    }

    public List<Item> mapItems(){
        List<Item> items = new ArrayList<Item>();
        baseFunc.visibilityByLocator(ITEM_CONTAINER);
        List<WebElement> elements = baseFunc.findElements(ITEM_CONTAINER);

        for (WebElement e:elements) {
            Item item = new Item();
            item.setLink(e.findElement(LINK));
            item.setDescription(e.findElement(DESCRIPTION).getText());
            item.setImage(e.findElement(IMAGE));
            item.setConfiguration(e.findElement(CONFIGURE));
            items.add(item);
        }

        return items;
    }




}
