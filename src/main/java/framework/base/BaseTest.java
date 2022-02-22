package framework.base;

import enums.Resources;
import framework.utils.DriverUtility;
import framework.utils.LoggerUtility;
import framework.utils.PropertiesUtility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AddPersonPage;
import pages.HomePage;
import pages.PersonListPage;

public class BaseTest {
    protected AddPersonPage addPersonPage;
    protected PersonListPage personListPage;
    protected  HomePage homePage;
    protected int id;

    @BeforeMethod
    public void setDriver() {
        DriverUtility.setDriver();
    }


    public int getLastId(){
       return personListPage.getLastId();
    }

    public void goToListPersonForm(){
        DriverUtility.get((PropertiesUtility.getStringValue(Resources.CONFIG.toString(),"homeUrl")));
        homePage  = new HomePage();
        Assert.assertTrue(homePage.isUniqueElementDisplayed(),"Home page is not open.");
        homePage.goToPersonList();
        personListPage = new PersonListPage();
        Assert.assertTrue(personListPage.isUniqueElementDisplayed(),"Person list is not open.");

    }

    public void goToAddPersonForm(){
        personListPage.addNewPerson();
        addPersonPage = new AddPersonPage();
        Assert.assertTrue(addPersonPage.isUniqueElementDisplayed(),"Add person form is not open.");
    }

    @AfterMethod
    public void quit(){
        LoggerUtility.info("Driver quit");
        DriverUtility.quit();
        DriverUtility.refresh();
    }
}
