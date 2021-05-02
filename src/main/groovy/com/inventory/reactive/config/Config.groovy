package com.inventory.reactive.config

import com.inventory.reactive.documents.Product
import com.inventory.reactive.documents.Warehouse
import com.inventory.reactive.repositories.ProductRepository
import com.inventory.reactive.repositories.WarehouseRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

import static org.springframework.web.reactive.function.BodyInserters.fromProducer
import static org.springframework.web.reactive.function.BodyInserters.fromValue
import static org.springframework.web.reactive.function.server.RequestPredicates.GET
import static org.springframework.web.reactive.function.server.RequestPredicates.POST
import static org.springframework.web.reactive.function.server.RouterFunctions.route
import static org.springframework.web.reactive.function.server.ServerResponse.ok

@Configuration
@EnableWebFlux
class Config {

    ProductRepository productRepository
    WarehouseRepository warehouseRepository

    Config(ProductRepository productRepository, WarehouseRepository warehouseRepository) {
        this.productRepository = productRepository
        this.warehouseRepository = warehouseRepository
    }

    @Bean
    RouterFunction<ServerResponse> warehouseRoutes() {
        route(GET("/warehouses"), { ok().body(warehouseRepository.findAll(), Warehouse)})
        .andRoute(POST("/where"), this.&getNear)
        .andRoute(GET("/addW"), this.&addWarehouse)
        .andRoute(GET("/remove"), this.&remove)
    }

    @Bean
    RouterFunction<ServerResponse> routes() {
        route(GET("/"), { ok().body(fromValue("Welcome Home"))})
        .andRoute(GET("/add"), { ok().body(fromProducer(productRepository.save(new Product(price: BigDecimal.ONE)), Product))})
        .andRoute(GET("/all"), { ok().body(fromProducer(productRepository.findAll(), Product))})
    }

    Mono<ServerResponse> getNear(ServerRequest request) {
        GeoJsonPoint p = new GeoJsonPoint(-104.989192D, 39.581276D)
        ok().body(warehouseRepository.findByLocationNear(p), Warehouse)
    }

    Mono<ServerResponse> addWarehouse(ServerRequest request) {
        ok().body(warehouseRepository.save(new Warehouse(name: "W1", location: new GeoJsonPoint(-103.999192, 39.581277))), Warehouse)
    }

    Mono<ServerResponse> remove(ServerRequest request) {
        ok().body(warehouseRepository.deleteAll(), Void)
    }
}
