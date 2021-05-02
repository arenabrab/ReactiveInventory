package com.inventory.reactive.repositories

import com.inventory.reactive.documents.Holiday
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface HolidayRepository extends ReactiveMongoRepository<Holiday, ObjectId> {}