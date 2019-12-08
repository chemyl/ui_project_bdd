package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
// ^ - обозначение начала строки и конца - $

public class ScenarioSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    TravelPageSteps travelPageSteps = new TravelPageSteps();
    ConfigPageSteps configPageSteps = new ConfigPageSteps();

    @When("^выбран пункт меню -\"(.*)\"$")
    public void stepSelectMainMenu(String menuItem) {
        mainPageSteps.selectMenuItem(menuItem);
    }

    @When("^выбран вид страхования -\"(.*)\"$")
    public void stepSelectInsurranceType(String insurranceType) {
        mainPageSteps.selectInsuranceItem(insurranceType);
    }

    @When("Нажата кнопка онлайн регистрации")
    public void stepInsurranceBtnclick() {
        travelPageSteps.clickOnlineRegistrationBtn();
    }

    @Then("^Переходим на новую вкладку-\"(.*)\"$")
    public void getNewTabWindow(int tabNumber) {
        travelPageSteps.getNewTabWindow(tabNumber);
    }

    @When("Выбирается минимальный вид страхования")
    public void chooseMinTarif() {
        configPageSteps.continueMinTarif();
    }

    @When("Нажимается кнопка продолжить")
    public void continueBtnClick() {
        configPageSteps.continueBtnClick();
    }

    @Then("Заполняются поля: ")
    public void stepFillFields(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (key, value) -> configPageSteps.stepFillField(key, value));
    }

    @When("Нажимется кнопка подтверждения данных")
    public void confirmBtnclick() {
        configPageSteps.continueBtnClick();
    }

    @Then("^Проверяется текста ошибки\"(.*)\"$")
    public void errorMessagaCheck(String message) {
        configPageSteps.checkErrorText(message);
    }

}
