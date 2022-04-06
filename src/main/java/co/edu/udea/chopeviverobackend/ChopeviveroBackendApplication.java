package co.edu.udea.chopeviverobackend;

import co.edu.udea.chopeviverobackend.services.mosquitto.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ChopeviveroBackendApplication implements CommandLineRunner {


	@Autowired
	private MessagingService messagingService;

	@Autowired
	private ConfigurableApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(ChopeviveroBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final String topic = "/#";

		messagingService.subscribe(topic);

		//messagingService.publish(topic, "Hi\nThis is a sample message published to topic roytuts/topic/event", 0, false);

		//context.close();
	}

}
