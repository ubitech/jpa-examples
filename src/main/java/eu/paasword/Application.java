package eu.paasword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({
    "eu.pearl.services", 
    "eu.pearl.filter",
    "eu.pearl.rest"
})
@EntityScan({"eu.paasword.model"})
@EnableJpaRepositories({"eu.paasword.dao"})
@EnableAutoConfiguration
@SpringBootApplication

/**
 *
 * @author Panagiotis Gouvas (pgouvas@ubitech.eu)
 */
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
