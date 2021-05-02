package com.inventory.reactive.documents

import groovy.transform.Canonical
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document("products")
@Canonical
class ProductVariant {
    @Indexed
    String sku
    String itemId
    String metalType
}
