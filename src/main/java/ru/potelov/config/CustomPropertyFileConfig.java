package ru.potelov.config;

import org.apache.deltaspike.core.api.config.PropertyFileConfig;

public class CustomPropertyFileConfig implements PropertyFileConfig {

    @Override
    public String getPropertyFileName() {
        return "META-INF/apache-deltaspike.properties";
    }

    @Override
    public boolean isOptional() {
        return false;
    }
}
