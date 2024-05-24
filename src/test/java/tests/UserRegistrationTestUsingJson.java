package tests;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.FileReader;
import java.io.IOException;

public class UserRegistrationTestUsingJson extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registrationObject;
    LoginPage loginObject;

    @Test(priority = 1)
    public void UserCanRegisterSuccessfully() {
        // Read JSON file
        String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\DataFile.json";
        JsonArray jsonArray = null;
        try {
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(new FileReader(filePath));
            jsonArray = jsonElement.getAsJsonArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(jsonArray, "JSON Array is null");

        for (JsonElement element : jsonArray) {
            JsonObject jsonObject = element.getAsJsonObject();
            String firstName = jsonObject.get("first_name").getAsString();
            String lastName = jsonObject.get("last_name").getAsString();
            String email = jsonObject.get("email").getAsString();
            String company = jsonObject.get("company").getAsString();
            String password = jsonObject.get("password").getAsString();
            int birthDay = jsonObject.get("birth_day").getAsInt();
            String birthMonth = jsonObject.get("birth_month").getAsString();
            int birthYear = jsonObject.get("birth_year").getAsInt();

            homeObject = new HomePage(driver);
            homeObject.openRegistrationPage();

            registrationObject = new UserRegistrationPage(driver);
            registrationObject.userRegistration(firstName, lastName, email, company, password,
                    String.valueOf(birthDay), birthMonth, String.valueOf(birthYear));

            System.out.println(registrationObject.successMsg.getText());
            Assert.assertTrue(registrationObject.successMsg.getText().contains("registration completed"));
            registrationObject.userLogout();
            homeObject.loginPage();
            loginObject = new LoginPage(driver);
            loginObject.UserLogin(email, password);
            System.out.println(registrationObject.logoutBtn.getText());
            Assert.assertTrue(registrationObject.logoutBtn.getText().contains("Log out"));
            registrationObject.userLogout();
        }
    }
}
