package com.freelancerLink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //BaseTimeEntity 활성화
@SpringBootApplication
public class FreelancerLinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreelancerLinkApplication.class, args);
	}
}
