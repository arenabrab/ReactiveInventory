package com.inventory.reactive.documents

import groovy.transform.Canonical
import org.springframework.data.mongodb.core.mapping.Document

@Canonical
@Document("references")
class ProductReference {
    String referenceType
    List<Product> associatedProducts
}
