package com.sailingperla.datastore

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DatastoreApplication

fun main(args: Array<String>) {
	runApplication<DatastoreApplication>(*args)
}
