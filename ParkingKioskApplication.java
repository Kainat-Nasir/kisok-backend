package com.conurets.parking_kiosk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.conurets.parking_kiosk"})
public class ParkingKioskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingKioskApplication.class, args);
	}

}
