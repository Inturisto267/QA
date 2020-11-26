package model;

import org.openqa.selenium.WebElement;

public class Item {
    private WebElement link;
    private WebElement image;
    private WebElement configuration;
    private String description;

    public WebElement getLink() {
        return link;
    }

    public void setLink(WebElement link) {
        this.link = link;
    }

    public WebElement getImage() {
        return image;
    }

    public void setImage(WebElement image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WebElement getConfiguration() {
        return configuration;
    }

    public void setConfiguration(WebElement configuration) {
        this.configuration = configuration;
    }
}
