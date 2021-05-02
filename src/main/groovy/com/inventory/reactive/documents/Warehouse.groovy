package com.inventory.reactive.documents


import groovy.transform.Canonical
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

import java.time.DayOfWeek

@Document
//@Sharded("name")
@Canonical
class Warehouse {
    @Id
    ObjectId id
    @Indexed
    String name
    @Indexed
    List<Product> products
    Map<DayOfWeek, OperatingHours> weeklySchedule
    List<Holiday> holidays
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    GeoJsonPoint location
}
