package com.conurets.parking_kiosk.base.util;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
public class PKDoubleFormatUtil {

    public static final Double formatDouble(Double number,int decimalPlaces){
        Double ans = 0D;
        // Create a BigDecimal from the double value
        BigDecimal bd = new BigDecimal(number);

        // Round the BigDecimal to the specified number of decimal places
        bd = bd.setScale(decimalPlaces, RoundingMode.HALF_UP);

        ans = bd.doubleValue();
        return ans;
    }
}
