package com.notepad;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public final class Application {

    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/application.properties"));
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public static Object getProperty(String key, Object defaultValue) {
        return properties.getOrDefault(key, defaultValue);
    }

    public static void setProperty(String key, Object value) {
        properties.setProperty(key, value.toString());
    }

    public static void storeProperties() {
        try (OutputStream out = new FileOutputStream("src/main/resources/application.properties")) {
            properties.store(out, "Application Settings");
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
