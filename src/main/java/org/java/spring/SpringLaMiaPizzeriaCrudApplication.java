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
		
		pizzaService.save(new Pizza("Pizza Margherita", "Una bellissima pizza margherita adatta a tutti grandi e piccoli", "https://upload.wikimedia.org/wikipedia/commons/c/c8/Pizza_Margherita_stu_spivack.jpg", 5.00));
		pizzaService.save(new Pizza("Pizza Mais e Ricotta", "Una pizza esotica  adatta ai veri degustatori, un pizzico di dolce misto col salato", "https://www.ricettedalmondo.it/images/foto-ricette/p/29294-pizza-mimosa.jpg", 7.00));
		pizzaService.save(new Pizza("Pizza patate e cipolla", "Sicuramente devi avere dei gusti discutibili, ma in ogni caso da Pizzeria da Aldo sei libero di fare schif.. coff coff, di mangiare!", "https://www.youcookit.net/it/wp-content/uploads/2021/06/pizza-patate-cipolle-rosmarino-07.jpg", 6.00));
		
	}

}
