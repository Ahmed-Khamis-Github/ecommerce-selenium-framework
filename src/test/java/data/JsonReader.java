package data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {

    public void jsonReader(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(reader);
            JsonArray jsonArray = jsonElement.getAsJsonArray();

            for (JsonElement element : jsonArray) {
                JsonObject jsonObject = element.getAsJsonObject();
                String firstName = jsonObject.get("first_name").getAsString();
                String lastName = jsonObject.get("last_name").getAsString();
                int birthDay = jsonObject.get("birth_day").getAsInt();
                String birthMonth = jsonObject.get("birth_month").getAsString();
                int birthYear = jsonObject.get("birth_year").getAsInt();
                String email = jsonObject.get("email").getAsString();
                String company = jsonObject.get("company").getAsString();
                String password = jsonObject.get("password").getAsString();

                // Printing out the information (you can manipulate this as per your requirement)
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Birth Date: " + birthDay + " " + birthMonth + " " + birthYear);
                System.out.println("Email: " + email);
                System.out.println("Company: " + company);
                System.out.println("Password: " + password);
                System.out.println();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}