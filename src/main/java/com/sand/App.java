package com.sand;

import com.sand.entity.User;
import com.sand.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner loadData(UserRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new User("Jack", "Bauer"));
            repository.save(new User("Chloe", "O'Brian"));
            repository.save(new User("Kim", "Bauer"));
            repository.save(new User("David", "Palmer"));
            repository.save(new User("Michelle", "Dessler"));

            // fetch all customers
            System.out.println("Customers found with findAll():");
            System.out.println("-------------------------------");
            for (User customer : repository.findAll()) {
                System.out.println(customer.toString());
            }
            System.out.println("");

            // fetch an individual customer by ID
            User customer = repository.findOne(1L);
            System.out.println("Customer found with findOne(1L):");
            System.out.println("--------------------------------");
            System.out.println(customer.toString());
            System.out.println("");

            // fetch customers by last name
            System.out.println("Customer found with findByLastNameStartsWithIgnoreCase('Bauer'):");
            System.out.println("--------------------------------------------");
            for (User bauer : repository
                    .findByLastNameStartsWithIgnoreCase("Bauer")) {
                System.out.println(bauer.toString());
            }
            System.out.println("");
        };
    }
}
