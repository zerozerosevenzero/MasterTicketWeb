package com.example.masterticket.packaze

import org.springframework.stereotype.Service

@Service
class PackageService(
    val packageRepository: PackageRepository
) {

    val allPackages: List<Packaze>
        get() {
            return packageRepository.findAllByOrderByName()
        }
}
