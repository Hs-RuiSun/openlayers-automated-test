package com.cgi.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

public class LoginPage extends PageObject{
    @FindBy(id="username")
    private WebElement username;
    
    @FindBy(id="password")
    private WebElement password;
    
    @FindBy(id="remember")
    private WebElement remember;
    
    @FindBy(xpath="//*[@id=\"formLogin\"]/div[2]/div[5]/div[1]/button")
    private WebElement submit;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public void enter(String username, String password) {
        this.username.clear();
        this.username.sendKeys(username);
        this.password.clear();
        this.password.sendKeys(password);
    }
    
    public void rememberMe() {
        this.remember.click();
    }
    
    public void login() {
        this.submit.click();
    }
    
    public void lostPassword() {
        
    }

    public void signUp() {
        
    }
}
