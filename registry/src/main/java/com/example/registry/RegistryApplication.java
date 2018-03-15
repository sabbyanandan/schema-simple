package com.example.registry;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;
import org.springframework.cloud.stream.schema.server.EnableSchemaRegistryServer;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableSchemaRegistryServer
@EnableSchemaRegistryClient
@EnableBinding(Source.class)
@RestController
public class RegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistryApplication.class, args);
	}

	@Autowired
    private Source source;

	@RequestMapping(value = "/messages", method = RequestMethod.POST)
    public String sendMessage(){
        User user = new User();
        user.setName("Joe");
        user.setFavoriteColor("Blue");
		source.output().send(MessageBuilder.withPayload(user).build());
		return "ok";
    }
}
