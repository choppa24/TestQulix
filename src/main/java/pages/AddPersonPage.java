package pages;

import elements.Button;
import elements.Input;
import elements.Label;
import framework.base.BaseForm;
import org.openqa.selenium.By;

public class AddPersonPage extends BaseForm {
    private final String INSERTION_POINT = "''";
    private final static By pageLocator = By.xpath("//label[contains(text(),'добавления персон')]");
    private final Label title = new Label(By.xpath("//label[contains(text(),'добавления персон')]"),"Title");
    private final Label surName = new Label(By.xpath("//label[text()='Фамилия']"),"Surname");
    private final Input surNameInput = new Input(By.name("surname"),"Surname input");
    private final Label firstName = new Label(By.xpath("//label[text()='Имя']"),"First name");
    private final Input firstNameInput = new Input(By.name("name"),"Surname input");
    private final Label patronymic = new Label(By.xpath("//label[text()='Отчество']"),"Second name");
    private final Input patronymicInput = new Input(By.name("secondName"),"Second name input");
    private final Label position = new Label(By.xpath("//label[text()='Должность']"),"Position");
    private final Input positionInput = new Input(By.name("position"),"Position input");
    private final Button saveButton = new Button(By.xpath("//input[@value='Сохранить']"),"Save button");
    private final Button cancelButton = new Button(By.xpath("//button[text()='Отмена']"),"Cancel button");
    private final String saveField = "//td[text()='']";
    private final Label errorPositionMessage = new Label(By.xpath("//label[contains(text(),'Должность содержит недопустимый символ')]"),"errorPositionMessage");

    public AddPersonPage(){
        super(new Label(pageLocator, "uniqueElement from AddPersonPage"),"AddPersonPage");
    }

    public boolean isTitleDisplayed(){
        return title.isDisplayed();
    }

    public boolean isElementsDisplayed(){
        return surName.isDisplayed() && surNameInput.isDisplayed() && firstName.isDisplayed() && firstNameInput.isDisplayed() &&
                patronymic.isDisplayed() && patronymicInput.isDisplayed() && position.isDisplayed()
                && positionInput.isDisplayed() && saveButton.isDisplayed() && cancelButton.isDisplayed();
    }

    public void sendSurname(String surname){
        surNameInput.sendStringKey(surname);
    }

    public void sendFirstName(String firstName){
        firstNameInput.sendStringKey(firstName);
    }

    public void sendPatronymic(String patronymic){
        patronymicInput.sendStringKey(patronymic);
    }

    public void sendPosition(String position){
        positionInput.sendStringKey(position);
    }

    public void clickSaveButton(){
        saveButton.click();
    }

    public boolean checkPerson(String surname, String firstName, String patronymic){
        Label surNameLabel = new Label(By.xpath(saveField.substring(0,saveField.indexOf(INSERTION_POINT)+1) + surname +
                saveField.substring(saveField.indexOf(INSERTION_POINT)+1)),"surNameLabel");
        Label firstNameLabel = new Label(By.xpath(saveField.substring(0,saveField.indexOf(INSERTION_POINT)+1) + firstName +
                saveField.substring(saveField.indexOf(INSERTION_POINT)+1)),"firstNameLabel");
        Label patronymicLabel = new Label(By.xpath(saveField.substring(0,saveField.indexOf(INSERTION_POINT)+1) + patronymic +
                saveField.substring(saveField.indexOf(INSERTION_POINT)+1)),"patronymicLabel");
        return surNameLabel.isDisplayed() && firstNameLabel.isDisplayed() && patronymicLabel.isDisplayed();
    }

    public boolean checkErrorPositionMessage(){
        return errorPositionMessage.isDisplayed();
    }

    public void clickCancelButton(){
        cancelButton.click();
    }
}
