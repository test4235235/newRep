package dataset;
import org.testng.annotations.DataProvider;

public class TestDatasets {
    @DataProvider(name = "loginData")
    public Object[][] getLoginData(){
        Object[][] data = new Object[1][3];
        data[0][0] = "http://automationpractice.com/index.php";
        data[0][1] = "petr_84@interia.pl";
        data[0][2] = "Anastazy123";
        return data;
    }

    @DataProvider(name = "createNewUserData")
    public Object[][] getCreateNewUserData() {
        Object[][] data = new Object[1][3];
        data[0][0] = "http://automationpractice.com/index.php";
        data[0][1] = "resources/testData/TestData.xlsx";
        data[0][2] = "createUser";
        return data;
    }
}
