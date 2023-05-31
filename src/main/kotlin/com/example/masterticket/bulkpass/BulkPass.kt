package com.example.masterticket.bulkpass

import com.example.masterticket.BaseEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class BulkPass(

    val packageId: Long,
    val userGroupId: String,
    @Enumerated(EnumType.STRING)
    var status: BulkPassStatus,
    val count: Int? = null,
    val startedAt: LocalDateTime,
    var endedAt: LocalDateTime? = null,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) : BaseEntity() {

    fun updateStatus(status: BulkPassStatus): BulkPass {
        this.status = status
        return this
    }

    fun setEndedAt(period: Int?) {
        if (period == null) { return }
        this.endedAt = startedAt.plusDays(period.toLong())
        this.createdAt = LocalDateTime.now()
    }
}