package com.github.java4wro;

import com.github.java4wro.generator.GeneratorPDF;
import com.github.java4wro.generator.dto.EventPdfDTO;
import com.github.java4wro.generator.dto.OwnerPdfDTO;
import com.github.java4wro.generator.dto.TicketPdfDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableJpaRepositories
@EnableSwagger2
@SpringBootApplication
@EnableAutoConfiguration
public class Application implements CommandLineRunner{

    @Autowired
    private GeneratorPDF generator;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ticket-reservation")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST Sample with Swagger")
                .description("Spring REST Sample with Swagger")
                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .contact("Niklas Heidloff")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.0")
                .build();
    }

    @Override
    public void run(String... args) throws Exception {
        EventPdfDTO eventDTO = new EventPdfDTO();
        eventDTO.setEventName("Wydarzenie miesiaca");
        eventDTO.setEventDateAndTime(LocalDateTime.now());

        OwnerPdfDTO ownerDTO = new OwnerPdfDTO();
        ownerDTO.setEmail("jan.kisiel22@gmail.com");

        TicketPdfDTO ticket = new TicketPdfDTO();
        ticket.setPrice(BigDecimal.valueOf(12.99));
        ticket.setRow("12");
        ticket.setSeat("10");
        ticket.setTicketId("12");


        generator.generateAndSendTicket(eventDTO, ownerDTO, ticket);
    }
}
