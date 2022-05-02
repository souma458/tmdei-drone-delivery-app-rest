package pt.isep.tmdei.schedulerservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pt.isep.tmdei.schedulerservice.client.DeliveryServiceClient;
import pt.isep.tmdei.schedulerservice.client.PackageServiceClient;
import pt.isep.tmdei.schedulerservice.client.UserServiceClient;
import pt.isep.tmdei.schedulerservice.client.implementation.DeliveryServiceClientImpl;
import pt.isep.tmdei.schedulerservice.client.implementation.PackageServiceClientImpl;
import pt.isep.tmdei.schedulerservice.client.implementation.UserServiceClientImpl;

@Configuration
public class ClientConfig {

    @Value("${user-service.url}")
    private String userServiceUrl;

    @Value("${user-service.prefix}")
    private String userServicePrefix;

    @Value("${delivery-service.url}")
    private String deliveryServiceUrl;

    @Value("${delivery-service.prefix}")
    private String deliveryServicePrefix;

    @Value("${package-service.url}")
    private String packageServiceUrl;

    @Value("${package-service.prefix}")
    private String packageServicePrefix;

    @Bean
    public UserServiceClient accountServiceClient() {
        return new UserServiceClientImpl(userServiceUrl, userServicePrefix);
    }

    @Bean
    public DeliveryServiceClient deliveryServiceClient() {
        return new DeliveryServiceClientImpl(deliveryServiceUrl, deliveryServicePrefix);
    }

    @Bean
    public PackageServiceClient packageServiceClient() {
        return new PackageServiceClientImpl(packageServiceUrl, packageServicePrefix);
    }

}
