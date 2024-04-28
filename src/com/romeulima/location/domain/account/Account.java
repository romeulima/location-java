package com.romeulima.location.domain.account;

public class Account {

    private Double basicPayment;
    private Double tax;

    public Account(){
    }

    public Account(Double basicPayment, Double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    public Double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(Double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotalPayment() {
        return this.basicPayment + this.tax;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Pagamento basico: ");
        builder.append(this.basicPayment + "\n");
        builder.append("Imposto: ");
        builder.append(this.tax + "\n");
        builder.append("Pagamento total: ");
        builder.append(this.getTotalPayment());

        return builder.toString();
    }
}
