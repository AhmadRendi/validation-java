package org.example.belajarjavavalidation;

import org.example.belajarjavavalidation.grub.CreditCartPayment;
import org.example.belajarjavavalidation.grub.PaymantGrub;
import org.example.belajarjavavalidation.grub.VirtualAccountPaymant;
import org.example.belajarjavavalidation.model.Customers;
import org.example.belajarjavavalidation.model.Paymant;
import org.example.belajarjavavalidation.validation.ValidationVactory;
import org.junit.jupiter.api.Test;

public class GrubTest {


    @Test
    void testCreditCardIsSuccess() {
        ValidationVactory<Paymant> paymantValidationVactory = new ValidationVactory<>();
        Paymant paymant = new Paymant();
        paymant.setMount(900000L);
        paymant.setCreditCard("4485231113937");
        for (var value : paymantValidationVactory.validaitonWithGrub(paymant, CreditCartPayment.class)){
            System.out.println(value.getMessage());
        }
    }

    @Test
    void testVirtualAccountSuccess() {
        ValidationVactory<Paymant> paymantValidationVactory = new ValidationVactory<>();
        Paymant paymant = new Paymant();
        paymant.setVirtualAccount("934909023942");

        for(var value : paymantValidationVactory.validaitonWithGrub(paymant, VirtualAccountPaymant.class)){
            System.out.println(value.getMessage());
        }
    }


    @Test
    void testGrubSequences() {
        ValidationVactory<Paymant> paymantValidationVactory = new ValidationVactory<>();
        Paymant paymant = new Paymant();

        for (var value : paymantValidationVactory.validaitonWithGrub(paymant, PaymantGrub.class)){
            System.out.println(value.getMessage());
        }
    }

    @Test
    void testConversion() {
        ValidationVactory<Paymant> paymantValidationVactory = new ValidationVactory<>();
        Paymant paymant = new Paymant();
        paymant.setMount(90000000L);
        paymant.setCreditCard("4485231113937");

        Customers customers = new Customers();

        paymant.setCustomers(customers);

        for (var value : paymantValidationVactory.validaitonWithGrub(paymant, PaymantGrub.class)){
            System.out.println(value.getMessage());
        }
    }
}
