package com.example.masterticket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MasterTicketWebApplication

fun main(args: Array<String>) {
    runApplication<MasterTicketWebApplication>(*args)
}
