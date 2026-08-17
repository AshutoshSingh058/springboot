package com.example.demo;

public class Stripe implements PaymentService{

    @Override
    public void pay(){
        System.out.println("Pay by stripe");
    }

}
