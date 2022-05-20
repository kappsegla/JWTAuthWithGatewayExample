package se.iths.gatewaywithservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class ConsulRegister {

	public static void main(String[] args) {
		SpringApplication.run(ConsulRegister.class, args);
	}
}
