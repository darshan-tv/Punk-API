package utils;

import java.io.*;
import java.util.Properties;

public class ConfigReader {
    private static InputStream inputStream;
    private static String fileName;
    private static ConfigReader configReader;

    private ConfigReader(String fileName) {
        this.fileName = fileName;
    }

    public static ConfigReader getInstance(String fileName) {
        if (configReader == null) {
            configReader = new ConfigReader(fileName);
        }
        return configReader;
    }

    public Properties ReadConfigFile() throws IOException {
        Properties prop = new Properties();
        try {
            String dir = System.getProperty("user.dir");
            inputStream = new BufferedInputStream(new FileInputStream(dir+"/configs/"+this.fileName));

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + this.fileName + "' not found in the classpath");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            inputStream.close();
        }
        return prop;
    }
}
