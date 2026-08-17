package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Razorpay implements PaymentService{

    @Override
    public void pay(){
        System.out.println("Pay by Razorpay");
    }
}
