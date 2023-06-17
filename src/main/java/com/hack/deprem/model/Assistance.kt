package com.hack.deprem.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.hibernate.annotations.GenericGenerator

@Entity
data class Assistance(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val uuid: String? ="",
        @OneToMany
        val product: List<Product>? = emptyList(),
        val fromCity: Int,
        val toLocation: String? = "" //Todo
){
        constructor(from:Int):this(
                null,
                null,
                from,
                null
        )
        constructor(from: Int, to: String) : this(
                null,
                null,
                from,
                to
        )
}
