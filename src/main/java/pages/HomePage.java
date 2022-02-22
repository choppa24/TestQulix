package pages;

import elements.Button;
import elements.Label;
import enums.Resources;
import framework.base.BaseForm;
import framework.utils.DriverUtility;
import framework.utils.PropertiesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BaseForm {
    private final static By pageLocator = By.id("menu");
    private final Button personButton = new Button(By.xpath("//a[contains(@href,'employees')]"),"Person button");

    public HomePage(){
        super(new Label(pageLocator, "uniqueElement from HomePage"),"HomePage");
    }

    public void goToPersonList(){
        personButton.click();
    }
}
