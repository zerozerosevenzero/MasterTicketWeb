package com.example.masterticket.UserGroupMapping

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserGroupMappingRepository : JpaRepository<UserGroupMapping, Integer> {
    fun findByUserGroupId(userGroupId: String): List<UserGroupMapping>

    @Query(
        "select distinct u.userGroupId " +
                "from UserGroupMapping u " +
                "order by u.userGroupId"
    )
    fun findDistinctUserGroupId(): List<String>
}