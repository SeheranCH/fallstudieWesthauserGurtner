package ch.course223.helloworldIvo.config;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private Properties properties;

    public PropertyReader(String fileURL) throws IOException {
        properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream(fileURL));
    }

    public Integer getIntProperty(String propName) {
        String propVal = properties.getProperty(propName);
        return Integer.parseInt(propVal);
    }

    public String getStringProperty(String propName) {
        String propVal = properties.getProperty(propName);

        return propVal;
    }

}

