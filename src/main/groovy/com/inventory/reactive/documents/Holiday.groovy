package com.inventory.reactive.documents

import groovy.transform.Canonical
import org.springframework.data.annotation.Transient
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalDate

@Document
@Canonical
class Holiday {
    LocalDate holiday

    @Transient
    def create(int day, int month, int year) {
        this.holiday = LocalDate.of(year, month, day)
    }
}
