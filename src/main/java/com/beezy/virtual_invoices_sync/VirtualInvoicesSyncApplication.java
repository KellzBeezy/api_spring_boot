package com.beezy.virtual_invoices_sync;

import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class VirtualInvoicesSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualInvoicesSyncApplication.class, args);
	}

}
