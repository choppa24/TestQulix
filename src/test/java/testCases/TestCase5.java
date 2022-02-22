package testCases;

import enums.Resources;
import framework.base.BaseTest;
import framework.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase5 extends BaseTest {
    private final int DELTA_ID = 1;
    @Test
    public void test() {
        LoggerUtility.info("TESTCASE5");
        goToListPersonForm();
        int lastId = getLastId();
        goToAddPersonForm();
        addPersonPage.sendSurname(PropertiesUtility.getStringValue(Resources.TEST.toString(), "surName" ));
        addPersonPage.sendFirstName(PropertiesUtility.getStringValue(Resources.TEST.toString(), "firstName" ));
        addPersonPage.sendPatronymic(PropertiesUtility.getStringValue(Resources.TEST.toString(), "patronymic" ));
        addPersonPage.sendPosition(PropertiesUtility.getStringValue(Resources.TEST.toString(), "truePosition" ));
        addPersonPage.clickSaveButton();
        Assert.assertEquals(lastId + DELTA_ID, getLastId(),"New user not added");
    }
}
