package com.inventory.reactive.documents

import groovy.transform.Canonical
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalTime

@Document
@Canonical
//@Sharded("hours")
class OperatingHours {
    LocalTime openingTime, closingTime
}
