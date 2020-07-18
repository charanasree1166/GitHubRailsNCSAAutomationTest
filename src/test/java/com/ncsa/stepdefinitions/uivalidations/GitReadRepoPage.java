package com.ncsa.stepdefinitions.uivalidations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class GitReadRepoPage {

    WebDriver driver;
    GitRepoPageObjectModel page;


    @BeforeTest
    public void beforeTest()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://github.com/rails");
        page = PageFactory.initElements(driver,GitRepoPageObjectModel.class);
    }
    @Test
    public void repoFilter(){

        page.setReposFilter("homepage" , Keys.ENTER);
     }
    @Test
    public void totalReposPerPage() throws InterruptedException {

        List<WebElement> liElements = driver.findElements(By.xpath(".//*[@id='org-repositories']/div[1]/div/ul/li"));
        System.out.println("list of elements" + liElements.size());
        Assert.assertNotNull(liElements);
        Assert.assertTrue(liElements.size() <= 30);

    }
    @Test
    public void clearRepoFilter() throws InterruptedException {
        page.setReposFilter("homepage" , Keys.ENTER);

        page.getClearFilter().click();
    }

/*    @AfterTest
    public void afterTest()
    {
        //driver.quit();
    }*/
}
