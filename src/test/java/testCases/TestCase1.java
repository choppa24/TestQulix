package testCases;

import framework.base.BaseTest;
import framework.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest {

    @Test
    public void test() {
        LoggerUtility.info("TESTCASE1");
        goToListPersonForm();
        goToAddPersonForm();
        Assert.assertTrue(addPersonPage.isElementsDisplayed(),"Not all items displayed.");
    }
}
