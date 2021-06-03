package com.sailingperla.datastore

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class HttpControllersTests(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var userRepository: UserRepository

    @MockkBean
    private lateinit var itemRepository: ItemRepository

    @Test
    fun `List articles`() {
        val dh = User("darko", "Darko", "Holman")
        val a = Item("wooo", "Dear Spring community ...", dh)
        val b = Item("wooo", "Dear Spring community ...", dh)
        every { itemRepository.findAllByOrderByAddedAtDesc() } returns listOf(a, b)
        mockMvc.perform(get("/api/item/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].owner.login").value(dh.login))
            .andExpect(jsonPath("\$.[0].slug").value(a.slug))
            .andExpect(jsonPath("\$.[1].owner.login").value(dh.login))
            .andExpect(jsonPath("\$.[1].slug").value(b.slug))
    }

    @Test
    fun `List users`() {
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        val smaldini = User("smaldini", "Stéphane", "Maldini")
        every { userRepository.findAll() } returns listOf(juergen, smaldini)
        mockMvc.perform(get("/api/user/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].login").value(juergen.login))
            .andExpect(jsonPath("\$.[1].login").value(smaldini.login))
    }
}