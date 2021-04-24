package com.inventory.reactive.config

import com.inventory.reactive.documents.Product
import com.inventory.reactive.repositories.ProductRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
@EnableWebFlux
class Config {

    ProductRepository repository

    Config(ProductRepository repository) {
        this.repository = repository
    }

    @Bean
    RouterFunction<ServerResponse> routes() {
        RouterFunctions.route(RequestPredicates.GET("/"), { ServerResponse.ok().body(BodyInserters.fromValue("Welcome Home"))})
        .andRoute(RequestPredicates.GET("/add"), {ServerResponse.ok().body(BodyInserters.fromProducer(repository.save(new Product(price: BigDecimal.ONE)), Product))})
        .andRoute(RequestPredicates.GET("/all"), {ServerResponse.ok().body(BodyInserters.fromProducer(repository.findAll(), Product))})
    }
}
