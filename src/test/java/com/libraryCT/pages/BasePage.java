package com.libraryCT.pages;

import com.libraryCT.utilities.BrowserUtils;
import com.libraryCT.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = ".portlet-title")
    public WebElement pageSubTitle;

    @FindBy(css = ".nav-item.dropdown")
    public WebElement usernameNavDropDown;

    @FindBy(css = ".dropdown-item")
    public WebElement logOut;

    @FindBy(xpath = "//a[@href='#borrowing-books']")
    public WebElement borrowingModule;

    @FindBy(xpath = "//a[@href='#books']")
    public WebElement booksModule;

    @FindBy(xpath = "//li[@class='nav-item']")
    public List<WebElement> navbarLink;

    @FindBy(css = ".navbar-brand")
    public WebElement libraryMain;

    @FindBy(linkText = "Users")
    public WebElement users;







    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        BrowserUtils.waitForStaleElement(pageSubTitle);
        return pageSubTitle.getText();
    }

    public String getCurrentUrl(WebElement visibleOne) {
        BrowserUtils.waitForVisibility(visibleOne,3);
        return  Driver.get().getCurrentUrl();
    }

    public boolean compareSearchResults(WebElement dropdown,List<String> searchTypes){
        boolean flag=true;
        Select select = new Select(dropdown);

        for (String searchType : searchTypes) {
            select.selectByVisibleText(searchType);
            System.out.println("select.getFirstSelectedOption() = " + select.getFirstSelectedOption().getText());
            if(!select.getFirstSelectedOption().getText().equals(searchType))
                flag=false;
        }



        return flag;
    }



}
