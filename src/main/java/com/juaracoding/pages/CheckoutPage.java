package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckoutPage {
    private WebDriver driver;
    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Proceed to checkout']")
    WebElement checkoutBtn;

    @FindBy(xpath = "//input[@id='billing_first_name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='billing_last_name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='billing_company']")
    WebElement companyName;

    @FindBy(xpath = "//span[@id='select2-billing_country-container']")
    WebElement countryOption;

    @FindBy(className = "#select2-billing_country-result-lsew-ID")
    List<WebElement> countryName;

    @FindBy(xpath = "//input[@id='billing_address_1']")
    WebElement addressOne;

    @FindBy(xpath = "//input[@id='billing_address_2']")
    WebElement addressTwo;

    @FindBy(xpath = "//input[@id='billing_city']")
    WebElement cityName;

    @FindBy(xpath = "//span[@id='select2-billing_state-container']")
    WebElement provinceOption;

    @FindBy(className = "#select2-billing_state-result-i48a-JB")
    List<WebElement> provinceName;

    @FindBy(xpath = "//input[@id='billing_postcode']")
    WebElement postalCode;

    @FindBy(xpath = "//input[@id='billing_phone']")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@id='billing_email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='terms']")
    WebElement agreeBtn;

    @FindBy(xpath = "//button[@id='place_order']")
    WebElement placeOrderBtn;

    @FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
    WebElement thankYou;

    public void checkout(){
        checkoutBtn.click();
    }

    public void sendDataBilling(
        String firstName,
        String lastName,
        String companyName,
        String addressOne,
        String addressTwo,
        String cityName,
        String postalCode,
        String phoneNumber) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
        this.companyName.clear();
        this.companyName.sendKeys(companyName);
        this.countryOption.click();
        this.countryName.add(countryOption);
        this.countryOption.click();
        System.out.println("Pilihan negara: " + this.countryOption.getText());
        this.addressOne.clear();
        this.addressOne.sendKeys(addressOne);
        this.addressTwo.clear();
        this.addressTwo.sendKeys(addressTwo);
        this.cityName.clear();
        this.cityName.sendKeys(cityName);
        this.provinceOption.click();
        this.provinceName.add(provinceOption);
        this.provinceOption.click();
        System.out.println("Pilihan provinsi: " + this.provinceOption.getText());
        this.postalCode.clear();
        this.postalCode.sendKeys(postalCode);
        this.phoneNumber.clear();
        this.phoneNumber.sendKeys(phoneNumber);
        if (!this.agreeBtn.isSelected()) this.agreeBtn.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        this.placeOrderBtn.click();
    }

    public String getSuccessOrder(){
        return thankYou.getText();
    }
}
