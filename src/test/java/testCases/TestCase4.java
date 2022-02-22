package testCases;

import enums.Resources;
import framework.base.BaseTest;
import framework.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase4 extends BaseTest {

    @Test
    public void test() {
        LoggerUtility.info("\n TESTCASE4");
        goToListPersonForm();
        int lastId = getLastId();
        goToAddPersonForm();
        addPersonPage.sendSurname(PropertiesUtility.getStringValue(Resources.TEST.toString(), "surName" ));
        addPersonPage.sendFirstName(PropertiesUtility.getStringValue(Resources.TEST.toString(), "firstName" ));
        addPersonPage.sendPatronymic(PropertiesUtility.getStringValue(Resources.TEST.toString(), "patronymic" ));
        addPersonPage.sendPosition(PropertiesUtility.getStringValue(Resources.TEST.toString(), "truePosition" ));
        addPersonPage.clickCancelButton();
        Assert.assertEquals(lastId, getLastId(),"New user added");
        LoggerUtility.info("TESTCASE4 completed successfully");
    }
}
