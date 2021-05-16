package com.vegazsdev.bobobot.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Config {

    private static final Logger logger = LoggerFactory.getLogger(Config.class);

    public static String getDefConfig(String prop) {
        FileInputStream fileInputStream = null;
        try {
            Properties getProps = new Properties();
            fileInputStream = new FileInputStream("configs/configs.prop");
            getProps.load(fileInputStream);
            return getProps.getProperty(prop);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                if (fileInputStream != null) fileInputStream.close();
            } catch (Exception exception) {
                logger.error(exception.getMessage());
            }
        }
        return null;
    }

    public void createDefConfig() {
        FileOutputStream fileOutputStream = null;
        try {
            FileTools.createFolder("configs");
            Properties saveProps = new Properties();
            saveProps.setProperty("bot-token", "1798785128:AAFyyd_GD6H2odG2T_Un5T-OcsdJgMlrcBQ");
            saveProps.setProperty("bot-username", "PriiiyoGSIs_Bot");
            saveProps.setProperty("bot-master", "1032152179");
            saveProps.setProperty("requestChat", "-1001212338973");
            saveProps.setProperty("publicChannel", "PriiiyoGSI");
            saveProps.setProperty("privateChat", "-1001401549638");
            fileOutputStream = new FileOutputStream("configs/configs.prop");
            saveProps.store(fileOutputStream, null);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            } catch (Exception exception) {
                logger.error(exception.getMessage());
            }
        }
    }
}
