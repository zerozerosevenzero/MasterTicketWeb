package com.example.masterticket.packaze

import com.example.masterticket.BaseEntity
import javax.persistence.*

@Entity
class Packaze(

    val name: String?,
    val count: Int? = null,
    var period: Int?,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) : BaseEntity() {

}