package com.example.masterticket.pass

import com.example.masterticket.BaseEntity
import com.example.masterticket.bulkpass.BulkPass
import com.example.masterticket.packaze.Packaze
import lombok.NoArgsConstructor
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@NoArgsConstructor
class Pass(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "packageId", insertable = false, updatable = false)
    val packaze: Packaze,
    val userId: String,
    @Enumerated(EnumType.STRING)
    var status: PassStatus,
    var remainingCount: Int,
    val startedAt: LocalDateTime,
    val endedAt: LocalDateTime? = null,
    var expiredAt: LocalDateTime? = null,

    @Id @GeneratedValue
    val id: Long? = null,
) : BaseEntity() {

    fun updateExpiringPass() {
        this.status = PassStatus.EXPIRED
        this.expiredAt = LocalDateTime.now()
    }
}