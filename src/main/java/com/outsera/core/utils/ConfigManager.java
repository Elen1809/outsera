package com.outsera.core.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(fis); // Carrega o arquivo config.properties
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao carregar o arquivo config.properties.");
        }
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public static String getRequiredProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Propriedade obrigatória não encontrada: " + key);
        }
        return value;
    }
}