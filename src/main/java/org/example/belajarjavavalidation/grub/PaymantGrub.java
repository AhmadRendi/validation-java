package org.example.belajarjavavalidation.grub;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;


/*
    * jika kita ingin memvalidasi dari atas ke bawah dan tikak memvalidasi semua nya dan akan berhenti apabila
        terjadi error pertama maka akan langsung berhenti tanpa perlu memvalidasi semuanya
 */

@GroupSequence(
        value = {
                Default.class,
                VirtualAccountPaymant.class,
                CreditCartPayment.class
        }
)
public interface PaymantGrub {
}
