package com.saravanan.springjpah2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringJpaH2Application {

    private static final Logger log =
            LoggerFactory.getLogger(SpringJpaH2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaH2Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository){
        return (args) -> {
            //load some data
            repository.save(new Customer("Mahith", "Dharma"));
            repository.save(new Customer("Pooshika", "Saravanan"));
            repository.save(new Customer("Priya", "Saravanan"));

            log.info(" Existing All customers are...");
            log.info(" -----------------------------");
            for( Customer customer : repository.findAll())
                log.info(customer.toString());

            log.info(" ");

            //System.out.println(repository.findAll());
            log.info(" Customers with given last name: ");
            log.info(" ---------------------------------");
            repository.findByLastName("Saravanan").forEach(saran ->{
                log.info(saran.toString());
            });

            log.info(" ");

        };
    }


}
