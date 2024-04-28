package com.romeulima.location.services;

import com.romeulima.location.domain.account.Account;
import com.romeulima.location.domain.carrental.CarRental;

import java.time.Duration;

public class CarRentalService {

    private final Double pricePerDay;
    private final Double pricePerHour;
    private final AccountService service;

    public CarRentalService(Double pricePerDay, Double pricePerHour, AccountService service){
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.service = service;
    }

    public void processAccount(CarRental carRental){
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60.0;

        double basicPayment;
        if (hours <= 12.0) {
            basicPayment = pricePerHour * Math.ceil(hours);
        } else {
            basicPayment = pricePerDay * Math.ceil(hours / 24.0);
        }

        double tax = service.generateTaxValue(basicPayment);

        carRental.setAccount(new Account(basicPayment, tax));
    }
}
