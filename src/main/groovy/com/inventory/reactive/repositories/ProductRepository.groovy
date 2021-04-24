package com.inventory.reactive.repositories

import com.inventory.reactive.documents.Product
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository extends ReactiveMongoRepository<Product, ObjectId>{}