package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductPage;
import org.openqa.selenium.WebDriver;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) {

        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com/my-account");

        LoginPage loginPage = new LoginPage();
        loginPage.login("baner","@juaracoding123(");
        delay(3);

        ProductPage productPage = new ProductPage();
        productPage.product("Beige","Large");
        delay(5);

        CartPage cartPage = new CartPage();
        cartPage.showCart();
        delay(10);

        DriverSingleton.closeObjectInstance();
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}