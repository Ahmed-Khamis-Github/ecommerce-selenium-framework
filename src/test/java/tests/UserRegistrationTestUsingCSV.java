package tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserRegistrationTestUsingCSV extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registrationObject;

    LoginPage loginObject;


    CSVReader reader;


    @Test(priority = 1)
    public void UserCanRegisterSuccessfully() throws IOException, CsvValidationException {

        String CSV_file = System.getProperty("user.dir") + "\\src\\test\\java\\data\\DataFile.csv";
        reader = new CSVReader(new FileReader(CSV_file));
        String[] csvCell;

        while ((csvCell = reader.readNext()) != null) {
            {
                String fnName = csvCell[0];
                String lnName = csvCell[1];
                String dayOfBirth = csvCell[2];
                String monthOfBirth = csvCell[3];
                String yearOfBirth = csvCell[4];
                String email = csvCell[5];
                String companyName = csvCell[6];
                String password = csvCell[7];




                homeObject = new HomePage(driver);
                homeObject.openRegistrationPage();

                registrationObject = new UserRegistrationPage(driver);
                registrationObject.userRegistration(fnName, lnName,
                        email, companyName,
                        password, dayOfBirth, monthOfBirth, yearOfBirth);

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


}
