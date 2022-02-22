package testCases;

import enums.Resources;
import framework.base.BaseTest;
import framework.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 extends BaseTest {

    @Test
    public void test() {
        LoggerUtility.info("\n TESTCASE3");
        goToListPersonForm();
        goToAddPersonForm();
        addPersonPage.sendSurname(PropertiesUtility.getStringValue(Resources.TEST.toString(), "surName" ));
        addPersonPage.sendFirstName(PropertiesUtility.getStringValue(Resources.TEST.toString(), "firstName" ));
        addPersonPage.sendPatronymic(PropertiesUtility.getStringValue(Resources.TEST.toString(), "patronymic" ));
        addPersonPage.sendPosition(PropertiesUtility.getStringValue(Resources.TEST.toString(), "falsePosition" ));
        addPersonPage.clickSaveButton();
        Assert.assertTrue(addPersonPage.checkErrorPositionMessage(),"validation message did not appear");
        LoggerUtility.info("TESTCASE3 completed successfully");
    }
}

