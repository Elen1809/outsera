package com.outsera.core.utils;

import java.io.IOException;
import java.util.logging.*;

public class LogUtils {

    private static final String LOG_FILE_NAME = "geral.log";

    // Criação do FileHandler compartilhado
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

    /**
     * Retorna um logger específico para a classe.
     *
     * @param clazz A classe que está chamando o logger.
     * @return Um logger configurado para a classe.
     */
    public static Logger getLogger(Class<?> clazz) {
        Logger logger = Logger.getLogger(clazz.getName());
        configureLogger(logger);
        return logger;
    }

    /**
     * Configura o logger com o FileHandler e remove os manipuladores padrão.
     *
     * @param logger O logger a ser configurado.
     */
    private static void configureLogger(Logger logger) {
        if (!isHandlerAttached(logger)) {
            logger.addHandler(fileHandler); // Adiciona o manipulador de arquivo
        }
        logger.setUseParentHandlers(false); // Evita duplicação de logs no console
    }

    /**
     * Verifica se o FileHandler já está associado ao logger.
     *
     * @param logger O logger a ser verificado.
     * @return true se o FileHandler já estiver associado, caso contrário, false.
     */
    private static boolean isHandlerAttached(Logger logger) {
        for (Handler handler : logger.getHandlers()) {
            if (handler instanceof FileHandler) {
                return true;
            }
        }
        return false;
    }
}
