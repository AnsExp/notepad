package com.notepad;

import java.io.FileInputStream;
import java.util.Properties;

public final class Language {

    private final static Properties dictionary;

    static {
        dictionary = new Properties();
        try {
            String filename = Application.getProperty("app.language", "en_US").toString() + ".properties";
            dictionary.load(new FileInputStream("src/main/resources/lang/" + filename));
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public static String getText(String key) {
        return dictionary.getProperty(key, key);
    }
}
