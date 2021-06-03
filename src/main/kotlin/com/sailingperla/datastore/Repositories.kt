package com.sailingperla.datastore

import org.springframework.data.repository.CrudRepository
import java.util.*

interface ItemRepository : CrudRepository<Item, UUID> {
    fun findBySlug(slug: String): Item?
    fun findAllByOrderByAddedAtDesc(): Iterable<Item>
}

interface UserRepository : CrudRepository<User, UUID> {
    fun findByLogin(login: String): User?
}