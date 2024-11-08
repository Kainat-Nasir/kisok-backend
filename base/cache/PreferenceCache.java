package com.conurets.parking_kiosk.base.cache;

import com.conurets.parking_kiosk.base.exception.ConfigurationException;
import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.base.util.PKConstants;
import com.conurets.parking_kiosk.base.util.PKUtil;
import com.conurets.parking_kiosk.persistence.entity.Preference;
import com.conurets.parking_kiosk.persistence.repository.PreferenceRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
@Component
public class PreferenceCache extends BaseCache {
    private static ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
    private PreferenceRepository preferenceRepository;
    @Autowired
    public PreferenceCache(PreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }

    /**
     * setProperties
     *
     * @param name
     * @param value
     */

    public static void setCache(String name, String value) {
        try {
            map.put(name, value);
        } catch (Exception e) {
            log.error("PreferenceCache.setCache", e.getMessage());
        }
    }

    /**
     * getProperty
     *
     * @param key
     * @return String
     */
    public static String getProperty(String key) {
        return map.get(key);
    }

    /**
     * getDoubleProperty
     *
     * @param key
     * @return Double
     */
    public static Double getDoubleProperty(String key) {
        return Double.parseDouble(getProperty(key));
    }

    /**
     * getBigDecimalProperty
     *
     * @param key
     * @return BigDecimal
     */
    public static BigDecimal getBigDecimalProperty(String key) {
        return new BigDecimal(getProperty(key));
    }

    /**
     * getIntegerProperty
     *
     * @param key
     * @return Integer
     */
    public static Integer getIntegerProperty(String key) {
        return Integer.parseInt(getProperty(key));
    }

    /**
     * getLongProperty
     *
     * @param key
     * @return Long
     */
    public static Long getLongProperty(String key) {
        return Long.parseLong(getProperty(key));
    }

    /**
     * getDecimalFormatProperty
     *
     * @param key
     * @return DecimalFormat
     */
    public static DecimalFormat getDecimalFormatProperty(String key) {
        return new DecimalFormat(getProperty(key));
    }

    /**
     * getBooleanProperty
     *
     * @param key
     * @return boolean
     */
    public static boolean getBooleanProperty(String key) {
        return PKConstants.Common.BOOLEAN_TRUE.equals(getProperty(key)) ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * Init
     */
    @PostConstruct
    public void init() {
        map = new ConcurrentHashMap<>();

        findAllPreferences();
    }

    /**
     * reloadPreference
     *
     * @return ConcurrentMap<String, String>
     * @throws PKException
     */
    public ConcurrentMap<String, String> reloadPreference() throws PKException {
        findAllPreferences();

        return map;
    }

    /**
     * findAllPreferences
     *
     * @throws PKException
     */
    private void findAllPreferences() throws PKException {
        List<Preference> preferences = preferenceRepository.findAll();

        if (PKUtil.isCollectionNotBlank(preferences)) {
            preferences.stream().map(preference -> setCache(preference)).collect(Collectors.toList());
        }
    }

    /**
     * setProperties
     *
     * @param preference
     * @return ConcurrentMap<String, String>
     */
    public static ConcurrentMap<String, String> setCache(Preference preference) throws PKException {
        setCache(preference.getName(), preference.getValue());

        return map;
    }

    /**
     * getInstance
     *
     * @param key
     * @param <T>
     * @return <T> T
     */
    public <T> T getInstance(String key) {
        try {
            String className = getProperty(key);
            return (T) Class.forName(className).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new ConfigurationException(9999, e.getMessage());
        }
    }
}