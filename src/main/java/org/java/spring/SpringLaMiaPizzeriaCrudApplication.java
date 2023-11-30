package org.java.spring;

import org.java.spring.pojo.Pizza;
import org.java.spring.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{

	
	@Autowired
	private PizzaService pizzaService;
	
	
	//Main function
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	
	
	@Override
	public void run(String... args) throws Exception {
		
		pizzaService.save(new Pizza("Pizza Margherita", "bella pizza margherita", "https://blabla", 5.00));
		pizzaService.save(new Pizza("Pizza Mais e Ricotta", "Una pizza esotica", "https://blablablablabla", 7.00));
		pizzaService.save(new Pizza("Pizza patate e cipolla", "Gusti discutibili", "https://blablablablabla", 6.00));
		
	}

}
