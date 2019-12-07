//
//import pages.ConfigPolyPage;
//import pages.MainPage;
//import pages.TravelInsurancePage;
//import steps.BaseSteps;
//
//public class RefactorPOMTest extends BaseSteps {
//
////    @Test
////    @Ignore
//    public void testInsurance() throws Exception {
//        driver.get(targetUrl);                                            //переход на baseUrl
//        MainPage mainPage = new MainPage(driver);                       //инициализация главной страницы
//        mainPage.selectMenuItem("Страхование");               //выбор из блока меню "Страхование"
//        mainPage.selectInsuranceItem("Страхование путешественников");   //из блока "Страхование" выбрать "Страхование путешественников"
//
//        TravelInsurancePage travelPage = new TravelInsurancePage(driver);   //инициализация страницы "Страховака для путешественников"
//        travelPage.onlineIssueBtn.click();                                  //нажать на кнопку подверждения онлайн
//                                   //переключение на другую открывшуюся вкладку
//
//        ConfigPolyPage configPage = new ConfigPolyPage(driver);         //в конструкторе зашито ожидание элемента
//        configPage.insuranceSumm.click();                               //выбор минимального тарифа
//        configPage.continueBtn.click();                                 //продолжение
//
//        configPage.fillField(configPage.surNameInsurant, "Pupkin");
//        configPage.fillField(configPage.nameInsurant, "Pupkin");
//        configPage.fillField(configPage.birthDateInsurant, "02051995");
//        configPage.fillField(configPage.surNamePolicyHolder, "Лушевич");
//        configPage.fillField(configPage.namePolicyHolder, "Виктор");
//        configPage.fillField(configPage.middleNamePolicyHolder, "Иакович");
//        configPage.fillField(configPage.birthDatePolicyHolder, "01071980");
//        configPage.fillField(configPage.docSeriesPolicyHolder, "4515");
//        configPage.fillField(configPage.docNumberPolicyHolder, "253636");
//        configPage.fillField(configPage.docIssueDate, "18122015");
//        configPage.fillField(configPage.docIssuePlace, "ОУМВД по гор. Москве р-ну Коньково");
//
//        configPage.confirmBtn.click();                                            //нажать кнопку подтверждения (заполненны все поля)
//        configPage.checkFieldErrorMessage("Заполнены не все обязательные поля");  // проверка возвращаемой ошибки
//    }
//}
//
