package utils;

import java.io.IOException;
import java.util.Properties;

public class Constants {
    private static Properties prop;

    static {
        try {
            prop = ConfigReader.getInstance("main.properties").ReadConfigFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String baseUrl = prop.getProperty("baseUrl");
    public static String getAllBeersPath = "beers";
    public static String getBrewedBeforeDatePath = "beers?brewed_before=";
    public static String getBeerAbvGrt = "beers?abv_gt=";
    public static String getBeerPagination = "beers?page=";



}
