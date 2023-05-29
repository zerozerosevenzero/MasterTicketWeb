package com.example.masterticket.bulkpass

import com.example.masterticket.util.LocalDateTimeUtils
import java.time.LocalDateTime

data class BulkPassRequest(
    var packageId: Long? = null,
    var userGroupId: String? = null,
    var startedAt: String? = null,
) {
    fun getStartedAt(): LocalDateTime? {
        return LocalDateTimeUtils.parse(startedAt)
    }
}