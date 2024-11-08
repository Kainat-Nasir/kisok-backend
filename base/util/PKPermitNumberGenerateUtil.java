package com.conurets.parking_kiosk.base.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class PKPermitNumberGenerateUtil {

    public static int getRandom() {

        Random rand = new Random();
        int num = rand.nextInt(9000000) + 1000000;

        return num;
    }
}
