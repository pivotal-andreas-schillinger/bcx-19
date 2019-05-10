package com.example.bic.iotdemo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import com.bosch.iot.things.client.ThingsClientFactory;
import com.bosch.iot.things.client.configuration.CommonConfiguration;
import com.bosch.iot.things.client.configuration.CredentialsAuthenticationConfiguration;
import com.bosch.iot.things.client.messaging.MessagingProviders;
import com.bosch.iot.things.client.messaging.ThingsWsMessagingProviderConfiguration;
import com.bosch.iot.things.clientapi.ThingsClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	private final static String username = "";
	private final static String password = "";
	private final static String apitoken = "";
	private final static String thingid = "";

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping
	public String greting() throws URISyntaxException, IOException, InterruptedException, ExecutionException {
		ThingsClient thingsClient = initializeThingsClient();
		return thingsClient.twin().forId(thingid).retrieve().get().toJsonString().toString();
	}

	private static ThingsClient initializeThingsClient() {
        final CredentialsAuthenticationConfiguration credentialsAuthenticationConfiguration =
                CredentialsAuthenticationConfiguration
                        .newBuilder()
                        .username(username)
                        .password(password)
                        .build();
 
        final ThingsWsMessagingProviderConfiguration thingsWsMessagingProviderConfiguration = MessagingProviders
                .thingsWebsocketProviderBuilder()
				.authenticationConfiguration(credentialsAuthenticationConfiguration)
				.endpoint("wss://things.eu-1.bosch-iot-suite.com")
                .build();
 
        final CommonConfiguration twinConfiguration =
                ThingsClientFactory.configurationBuilder()
                        .apiToken(apitoken)
                        .providerConfiguration(thingsWsMessagingProviderConfiguration)
                        .build();
 
        return ThingsClientFactory.newInstance(twinConfiguration);
    }

}
