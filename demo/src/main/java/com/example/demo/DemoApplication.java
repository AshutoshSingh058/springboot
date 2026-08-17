package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication  {

	private final  PaymentService paymentService ;

	public DemoApplication(PaymentService paymentService){
		this.paymentService = paymentService;
	}

	@Override
	public void run(String... args){
		paymentService.pay();
	}
	public static void main(String[] args) {SpringApplication.run(DemoApplication.class, args);}

}
