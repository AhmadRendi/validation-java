package org.example.belajarjavavalidation.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.example.belajarjavavalidation.grub.CreditCartPayment;
import org.example.belajarjavavalidation.grub.CustomerPayment;
import org.example.belajarjavavalidation.grub.PaymantGrub;
import org.example.belajarjavavalidation.grub.VirtualAccountPaymant;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public class Paymant {

    private Integer paymentId;

    @NotNull (groups = {Default.class ,VirtualAccountPaymant.class, CreditCartPayment.class}
            ,message = "mount can't null")
    @Range (min = 100_000L, max = 100_000_000L, message = "between range of mount 100.000 and 100.000.000")
    private Long mount;


    /*
        * jika kita ingin memvalidasi sebuah nomor untuk kartu credit atau yang semisalnya maka disarakan untuk
          menggunakan annotation LuhnCheck
     */
    @NotNull (groups = VirtualAccountPaymant.class ,message = "number of virtual account con't null")
    @LuhnCheck (groups = {VirtualAccountPaymant.class} ,message = "virtual account number not valid")
    private String virtualAccount;

    @NotNull (groups = CreditCartPayment.class, message = "number of creadit cart con't null")
    @LuhnCheck (groups = {CreditCartPayment.class} ,message = "credit card number not valid")
    private String creditCard;

    @NotNull (
            groups = {
              CustomerPayment.class
            },
            message = "customers can't blank")
    @Valid
    @ConvertGroup(from = CustomerPayment.class, to = Default.class)
    private Customers customers;


    public Paymant() {
    }

    public Paymant(Integer paymentId, Long mount, String virtualAccount, String creditCard) {
        this.paymentId = paymentId;
        this.mount = mount;
        this.virtualAccount = virtualAccount;
        this.creditCard = creditCard;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public Long getMount() {
        return mount;
    }

    public void setMount(Long mount) {
        this.mount = mount;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }
}
