package com.inventory.reactive.repositories

import com.inventory.reactive.documents.Warehouse
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface WarehouseRepository extends ReactiveMongoRepository<Warehouse, ObjectId> {
    Flux<Warehouse> findByLocationNear(GeoJsonPoint point)
}