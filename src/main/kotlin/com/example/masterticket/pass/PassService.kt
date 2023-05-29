package com.example.masterticket.pass

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@RequiredArgsConstructor
@Service
class PassService(val passRepository: PassRepository) {
    fun getPasses(userId: String?): List<Pass> {
        val passes: List<Pass> = passRepository.findByUserId(userId)
        return passes
    }
}