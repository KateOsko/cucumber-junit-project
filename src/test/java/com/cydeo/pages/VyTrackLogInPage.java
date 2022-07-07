package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackLogInPage {

    public VyTrackLogInPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id="prependedInput")
    public WebElement usernameVy;

    @FindBy(id="prependedInput2")
    public WebElement passwordVy;

    @FindBy(id="_submit")
    public WebElement logInBtn;

    public void login(String username, String password){
        usernameVy.sendKeys(username);
        passwordVy.sendKeys(password);
        logInBtn.click();
    }

    }

