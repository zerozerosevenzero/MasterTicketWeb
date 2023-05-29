package com.example.masterticket.user

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@RequiredArgsConstructor
@Service
class UserService(val userRepository: UserRepository) {
    fun getUser(userId: String?): User {
        val user: User = userRepository.findByUserId(userId)
        return user
    }
}
