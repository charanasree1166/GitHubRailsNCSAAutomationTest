package com.ncsa.stepdefinitions.datavalidation;

import com.ncsa.automation.models.Gitrepo;
import com.ncsa.automation.models.Item;
import com.ncsa.automation.models.Language;
import com.ncsa.stepdefinitions.uivalidations.GitRepoPageObjectModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class ValidateDataFromRest {

    RestTemplate restTemplate;
    ResponseEntity<Gitrepo> result;
    ResponseEntity<Language> languageResponseEntity;
    List<Item> itemsList = new ArrayList<>();
    List<MediaType> acceptMediaType = new ArrayList();
    WebDriver driver;
    GitRepoPageObjectModel page;

    @Given("^service \"([^\"]*)\" endpoint for github api for rails comprehensive \"([^\"]*)\" and type \"([^\"]*)\"")
    public void givenGetAPI(String endPoint , String scenarioName , String type){
        System.out.println("Test for Scenario" + scenarioName );
        System.out.println("Call to Endpoint " + endPoint + "started");
    }
    @When("^call GET api endpoint via github api: \"([^\"]*)\" for rails comprehensive testing")
    public void whenCallGetApi(String gitHubRepoUrl){

        System.out.println("GitHubRepo URL:" + gitHubRepoUrl);
        Gitrepo  gitRepoResponse = null;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept((Arrays.asList(MediaType.valueOf("application/vnd.github.mercy-preview+json"))));
        headers.setContentType(MediaType.valueOf("application/vnd.github.mercy-preview+json"));
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        try {
           result = restTemplate.exchange(gitHubRepoUrl, HttpMethod.GET, entity, Gitrepo.class);
            if (Optional.ofNullable(result).isPresent()) {
                itemsList = result.getBody().getItems();
            }
        }catch(HttpClientErrorException e){
                System.out.println("HTTP Exception" + e.getMessage());
        }catch(RestClientException restex){
            System.out.println("Rest Exception" + restex.getMessage());
        }catch(Exception ex){
            System.out.println("Generic Exception" + ex.getMessage());
            throw ex;
        }

        Assert.assertTrue(itemsList.size() <= 30);
    }
    @Then("^verify api response status code: \"([^\"]*)\" for rails comprehensive testing")
    public void thenValidateResponse(String statusCode){
        Assert.assertEquals(result.getStatusCode() , statusCode);
    }

    /*
    *********** Scenario #2
    */

    @Given("^service \"([^\"]*)\" endpoint for github api for language comprehensive \"([^\"]*)\" and type \"([^\"]*)\"")
    public void languageGetAPI(String endPoint , String scenarioName , String type){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://github.com/rails");
        page = PageFactory.initElements(driver, GitRepoPageObjectModel.class);
    }
    @When("^GET api endpoint via github api: \"([^\"]*)\" for rails comprehensive testing")
    public void callLanguageGetApi(String gitHubRepoUrl){

        System.out.println("GitHubRepo URL:" + gitHubRepoUrl);
        Gitrepo  gitRepoResponse = null;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept((Arrays.asList(MediaType.valueOf("application/vnd.github.mercy-preview+json"))));
        headers.setContentType(MediaType.valueOf("application/vnd.github.mercy-preview+json"));
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        try {
            languageResponseEntity = restTemplate.exchange(gitHubRepoUrl, HttpMethod.GET, entity, Language.class);

            }catch(HttpClientErrorException e){
            System.out.println("HTTP Exception" + e.getMessage());
        }catch(RestClientException restex){
            System.out.println("Rest Exception" + restex.getMessage());
        }catch(Exception ex){
            System.out.println("Generic Exception" + ex.getMessage());
            throw ex;
        }

        Assert.assertNotNull(languageResponseEntity.getBody());

        WebElement mySelectElement = driver.findElement (By.xpath(".//*[@id='js-pjax-container']/div/div/div[2]/div/form/div/div[2]/details[2]/details-menu/div[2]/label[3]/span"));
        System.out.println("menu item" + mySelectElement.getText());
    }
    @Then("^verify api response status code: \"([^\"]*)\" for language comprehensive testing")
    public void validateLanguageResponse(String statusCode){
       Assert.assertEquals(languageResponseEntity.getStatusCode() , statusCode);
    }

    /*
    * Scenario #3
     */

    @Given("^User is on the github.com/rails page")
    public void givenOnRailsPage(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://github.com/rails");
        page = PageFactory.initElements(driver, GitRepoPageObjectModel.class);
    }
    @When("^User searches for a repository name")
    public void whenOnRailsPage(){
        page.setReposFilter("homepage" , Keys.ENTER);
    }
    @Then("^User should be able to see the repository in the result set")
    public void thenOnRailsPage(){
        List<WebElement> liElements = driver.findElements(By.xpath(".//*[@id='org-repositories']/div[1]/div/ul/li"));
        Assert.assertNotNull(liElements);
        Assert.assertTrue(liElements.size() <= 30);
    }
}
