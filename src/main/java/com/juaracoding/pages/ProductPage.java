package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Black Cross Back Maxi Dress']")
    WebElement chooseProduct;

    @FindBy(xpath = "//select[@id='pa_color']")
    WebElement colorOption;

    @FindBy(xpath = "//select[@id='pa_size']")
    WebElement sizeOption;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addToCart;

    @FindBy(xpath = "//a[normalize-space()='View cart']")
    WebElement txtCart;

    public void product(String color, String size){
        driver.get("https://shop.demoqa.com/shop");
        chooseProduct.click();
        Select selectColor = new Select(this.colorOption);
        selectColor.selectByVisibleText(color);
        selectColor.getFirstSelectedOption().getText();
        Select selectSize = new Select(this.sizeOption);
        selectSize.selectByVisibleText(size);
        selectSize.getFirstSelectedOption().getText();
        addToCart.click();
    }

    public String viewCart(){
        return txtCart.getText();
    }
}
