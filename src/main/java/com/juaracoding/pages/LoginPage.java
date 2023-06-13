package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='username']")
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//button[@name='login']")
    WebElement btnLogin;
    @FindBy(xpath = "//a[normalize-space()='Dashboard']")
    WebElement txtDashboard;
    @FindBy(xpath = "//strong[normalize-space()='ERROR']")
    WebElement txtErrorLogin;
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement btnLogout;
    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }
    public String getTextDashboard(){
        return txtDashboard.getText();
    }
    public String getErrorAccount(){
        return txtErrorLogin.getText();
    }
    public void logout(){
        btnLogout.click();
    }
}
