package com.sailingperla.datastore

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Item(
    var name: String,
    var contentUri: String,
    @ManyToOne var owner: User,
    var slug: String = name.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    var description: String? = null,
    @Id @GeneratedValue var id: UUID? = null)

@Entity
class User(
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String? = null,
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue var id: UUID? = null)