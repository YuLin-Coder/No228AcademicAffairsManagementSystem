package com.yuanlrc.school.common.config;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.GimpyEngine;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.google.code.kaptcha.util.Configurable;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Properties;

@SpringBootConfiguration
public class CaptchaConfig {

    @Bean(name = "captchaProducer")
    public DefaultKaptcha getKaptchaBean(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty(Constants.KAPTCHA_BORDER, "no");
        properties.setProperty(Constants.KAPTCHA_BORDER_COLOR, "105,179,90");
        properties.setProperty(Constants.KAPTCHA_BORDER_THICKNESS, "1");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "blue");
        properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, "100");
        properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, "40");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, "abcdefghjkmnpqrstwxy23456789");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "Consolas, Courier New");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "26");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, "2");
        properties.setProperty(Constants.KAPTCHA_BACKGROUND_CLR_FROM, "white");
        properties.setProperty(Constants.KAPTCHA_BACKGROUND_CLR_TO, "white");
        properties.setProperty(Constants.KAPTCHA_PRODUCER_IMPL, "white");
        properties.setProperty(Constants.KAPTCHA_OBSCURIFICATOR_IMPL, CustomObscurificator.class.getName());
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

    public static class CustomObscurificator extends Configurable implements GimpyEngine {

        @Override
        public BufferedImage getDistortedImage(BufferedImage baseImage) {
            BufferedImage distortedImage = new BufferedImage(baseImage.getWidth(),
                    baseImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graph = (Graphics2D) distortedImage.getGraphics();
            graph.drawImage(baseImage, 0, 0, null, null);
            graph.dispose();
            return distortedImage;
        }
    }

}
