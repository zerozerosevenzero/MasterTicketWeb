package com.example.masterticket.UserGroupMapping

import org.springframework.stereotype.Service

@Service
class UserGroupMappingService(
    val userGroupMappingRepository: UserGroupMappingRepository
) {
    val allUserGroupIds: List<String>
        get() = userGroupMappingRepository.findDistinctUserGroupId()
}