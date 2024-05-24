package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    public static Properties userData = loadProperties(System.getProperty("user.dir") + "\\src\\main\\java\\data\\DataFile.properties");

    public static Properties loadProperties(String path) {
        Properties properties = new Properties();
        try (FileInputStream stream = new FileInputStream(path)) {
            properties.load(stream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }
}
