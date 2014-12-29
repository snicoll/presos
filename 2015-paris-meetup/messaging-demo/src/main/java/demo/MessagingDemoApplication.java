package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitMessageOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.support.MessageBuilder;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class MessagingDemoApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MessagingDemoApplication.class);

    @Autowired
    private RabbitMessageOperations messagingTemplate;

    @Override
    public void run(String... strings) throws Exception {
        logger.info("Sending message");
        messagingTemplate.send("smpQueue", MessageBuilder.withPayload("Hello Spring Meetup Paris!").build());
        logger.info("Message sent successfully");
    }

    public static void main(String[] args) {
        SpringApplication.run(MessagingDemoApplication.class, args);
    }
}
