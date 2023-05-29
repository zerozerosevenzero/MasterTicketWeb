package com.example.masterticket.bulkpass

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDateTime

interface BulkPassRepository: JpaRepository<BulkPass, Long> {
    fun findByStatusAndStartedAtGreaterThan(status: BulkPassStatus?, startedAt: LocalDateTime?): List<BulkPass>

    @Query(
        value = "select b from BulkPass b " +
                "order by b.startedAt desc"
    )
    fun findAllOrderByStartedAtDesc(): List<BulkPass>
}