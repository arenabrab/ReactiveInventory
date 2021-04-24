package com.inventory.reactive.documents

import groovy.transform.Canonical
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
@Canonical
class Product {
    @Id
    ObjectId objectId
    BigDecimal price
}
