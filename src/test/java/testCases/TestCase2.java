package testCases;

import enums.Resources;
import framework.base.BaseTest;
import framework.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 extends BaseTest {

    @Test
    public void test() {
        LoggerUtility.info("\n TESTCASE2");
        goToListPersonForm();
        goToAddPersonForm();
        addPersonPage.sendSurname(PropertiesUtility.getStringValue(Resources.TEST.toString(), "surName" ));
        addPersonPage.sendFirstName(PropertiesUtility.getStringValue(Resources.TEST.toString(), "firstName" ));
        addPersonPage.sendPatronymic(PropertiesUtility.getStringValue(Resources.TEST.toString(), "patronymic" ));
        addPersonPage.sendPosition(PropertiesUtility.getStringValue(Resources.TEST.toString(), "truePosition" ));
        addPersonPage.clickSaveButton();
        Assert.assertTrue(addPersonPage.checkPerson(PropertiesUtility.getStringValue(Resources.TEST.toString(), "surName" ),
                PropertiesUtility.getStringValue(Resources.TEST.toString(), "firstName" ),
                PropertiesUtility.getStringValue(Resources.TEST.toString(), "patronymic" )),"person not saved");
        LoggerUtility.info("TESTCASE2 completed successfully");
    }
}
