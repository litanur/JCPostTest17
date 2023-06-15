package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestShop {
    static WebDriver driver;
    static LoginPage loginPage;

    @BeforeTest
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com/my-account");
    }

    @AfterTest
    public void finish(){
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        DriverSingleton.closeObjectInstance();
    }
    @Test
    public void testLogin(){
        driver.get("https://shop.demoqa.com/my-account");
        loginPage = new LoginPage();
        loginPage.login("tiqini","@tiqini123*");
        Assert.assertEquals(loginPage.getTextDashboard(),"Dashboard");
        System.out.println("Berhasil login");
    }

    @Test
    public void testInvalidLogin(){
        loginPage = new LoginPage();
        loginPage.login("testing","testing");
        Assert.assertEquals(loginPage.getErrorAccount(),"ERROR");
        System.out.println("Percobaan login dengan credentials asal - asalan, gagal. Tes berhasil.");
    }

    @Test
    public void testProduct() {
        ProductPage productPage = new ProductPage();
        productPage.product("Beige", "Large");
        Assert.assertEquals(productPage.viewCart(),"View cart");
        System.out.println("Product berhasil dipilih dan ditambahkan ke keranjang");
    }

    @Test
    public void testShowCart(){
        CartPage cartPage = new CartPage();
        cartPage.showCart();
        Assert.assertEquals(cartPage.cartNotEmpty(),"CLEAR SHOPPING CART");
        System.out.println("Terdapat produk di keranjang");
    }

    @Test
    public void testShowCheckout(){
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.checkout();
        checkoutPage.sendDataBilling(
                "Lita",
                "Nurlaelati",
                "Juara Coding",
                "Jl. Kemanggisan V",
                "Nomor 55",
                "Bekasi",
                "17117",
                "6288765412323"
        );
        Assert.assertEquals(checkoutPage.getSuccessOrder(),"Thank you. Your order has been received.");
        System.out.println("Checkout berhasil");
    }
}
