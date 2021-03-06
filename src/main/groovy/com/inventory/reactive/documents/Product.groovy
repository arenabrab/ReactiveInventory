package com.inventory.reactive.documents

import groovy.transform.Canonical
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document("variants")
@Canonical
//@Sharded(["code", "location"])
class Product {
    @Indexed
    String itemId
    @Indexed
    String location
    BigDecimal price
    Map<ProductVariant, Integer> variants
    List<ProductReference> references
}
