package com.outsera.core.utils;

import java.io.IOException;
import java.util.logging.*;

public class LogUtils {

    private static final String LOG_FILE_NAME = "geral.log";

    private static FileHandler fileHandler;

    static {
        try {
            fileHandler = new FileHandler(LOG_FILE_NAME, true); // Anexa ao arquivo existente
            fileHandler.setFormatter(new SimpleFormatter()); // Formatação simples
            fileHandler.setLevel(Level.ALL); // Define o nível padrão
        } catch (IOException e) {
            System.err.println("Erro ao configurar o FileHandler: " + e.getMessage());
        }
    }

    public static Logger getLogger(Class<?> clazz) {
        Logger logger = Logger.getLogger(clazz.getName());
        configureLogger(logger);
        return logger;
    }

    private static void configureLogger(Logger logger) {
        if (!isHandlerAttached(logger)) {
            logger.addHandler(fileHandler); // Adiciona o manipulador de arquivo
        }
        logger.setUseParentHandlers(false); // Evita duplicação de logs no console
    }

    private static boolean isHandlerAttached(Logger logger) {
        for (Handler handler : logger.getHandlers()) {
            if (handler instanceof FileHandler) {
                return true;
            }
        }
        return false;
    }
}
