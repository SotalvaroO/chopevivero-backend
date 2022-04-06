package co.edu.udea.chopeviverobackend;

import co.edu.udea.chopeviverobackend.services.mosquitto.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ChopeviveroBackendApplication {


    public static void main(String[] args) {
        SpringApplication.run(ChopeviveroBackendApplication.class, args);
    }


}
