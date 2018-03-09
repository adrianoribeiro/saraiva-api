package br.com.saraiva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.WebApplicationInitializer;

/**
 * Spring boot initializer.
 * @author Adriano
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableAsync
public class Boot extends SpringBootServletInitializer implements WebApplicationInitializer {

   public static void main(String[] args)
   {
      SpringApplication.run(Boot.class, args);
   }
}
