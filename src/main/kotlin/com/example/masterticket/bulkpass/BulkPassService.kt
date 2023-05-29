package com.example.masterticket.bulkpass

import com.example.masterticket.packaze.PackageRepository
import com.example.masterticket.packaze.Packaze
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class BulkPassService(
    val bulkPassRepository: BulkPassRepository,
    val packageRepository: PackageRepository
) {

    val allBulkPasses: List<BulkPass>
        get() {
            val bulkPasses: List<BulkPass> = bulkPassRepository.findAllOrderByStartedAtDesc()
            return bulkPasses
        }

    fun addBulkPass(bulkPassRequest: BulkPassRequest) {
        val packaze: Packaze =
            packageRepository.findByIdOrNull(bulkPassRequest.packageId) ?: throw (IllegalArgumentException("해당하는 패키지가 없습니다."))

        val bulkPass = BulkPass(
            packageId = bulkPassRequest.packageId!!,
            userGroupId = bulkPassRequest.userGroupId!!,
            startedAt = bulkPassRequest.getStartedAt()!!,
            status = BulkPassStatus.READY,
            count = packaze.count,
        )
        bulkPass.setEndedAt(packaze.period)
        bulkPassRepository.save(bulkPass)
    }
}
