package com.romeulima.location.services;

public class BrazilTaxService implements AccountService{

    @Override
    public Double generateTaxValue(Double basicPayment) {
        if (basicPayment <= 100.00) {
            return basicPayment * 0.2;
        } else {
            return basicPayment * 0.15;
        }
    }
}
