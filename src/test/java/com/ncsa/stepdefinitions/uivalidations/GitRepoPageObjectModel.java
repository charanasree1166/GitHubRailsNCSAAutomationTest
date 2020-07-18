package com.ncsa.stepdefinitions.uivalidations;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitRepoPageObjectModel {

    private WebDriver webDriver;


    @FindBy(id = "your-repos-filter")
    private WebElement reposFilter;
    @FindBy(xpath = ".//*[@id='org-repositories']/div[1]/div/ul/li")
    private WebElement totalRepos;
    @FindBy(xpath = ".//*[@id='org-repositories']/div[1]/div/div[1]/div[2]/a")
    private WebElement clearFilter;

    public GitRepoPageObjectModel(WebDriver webDriver) {
        super();
        this.webDriver = webDriver;
    }

    public WebElement getReposFilter() {
        return reposFilter;
    }

    public WebElement getTotalRepos() {
        return totalRepos;
    }

    public WebElement getClearFilter() {
        return clearFilter;
    }

    public void setReposFilter(String actionString , Keys KeyAction)
    {
        this.reposFilter.sendKeys(actionString,KeyAction);
    }

}
