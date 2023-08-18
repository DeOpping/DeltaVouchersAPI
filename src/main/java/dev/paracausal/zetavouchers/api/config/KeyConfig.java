package dev.paracausal.zetavouchers.api.config;

import java.util.List;

public interface KeyConfig {

    boolean contains(String key);

    Object getObject(String key);

    String getString(String key);

    boolean getBoolean(String key);

    int getInt(String key);
    double getDouble(String key);

    List<String> getStringList(String key);

}
