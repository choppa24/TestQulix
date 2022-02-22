package pages;

import elements.Button;
import elements.Label;
import framework.base.BaseForm;
import org.openqa.selenium.By;

public class PersonListPage extends BaseForm {
    private final static By pageLocator = By.xpath("//th[text()='Имя']");
    private final Button addPersonButton = new Button(By.xpath("//button[@class='add-btn']"),"Add person button");
    private final Label lastId = new Label(By.xpath("//tbody/tr[last()]/td[1]"), "Last id");
    public PersonListPage(){
        super(new Label(pageLocator, "uniqueElement from PersonListPage"),"PersonListPage");
    }

    public void addNewPerson(){
        addPersonButton.click();
    }

    public void deletePerson(){

    }

    public int getLastId(){
        return  Integer.parseInt(lastId.getText());
    }
}
