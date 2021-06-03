package com.sailingperla.datastore

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatastoreConfiguration {
    @Bean
    fun databaseInitializer(userRepository: UserRepository,
                            itemRepository: ItemRepository) = ApplicationRunner {

        val darko = userRepository.save(User("darko", "Darko", "Holman"))
        itemRepository.save(Item(
            name = "wanderer",
            contentUri = "https://upload.wikimedia.org/wikipedia/commons/1/1d/Georg_von_Rosen_-_Oden_som_vandringsman%2C_1886_%28Odin%2C_the_Wanderer%29.jpg",
            owner = darko
        ))
        itemRepository.save(Item(
            name = "Sól and Máni",
            contentUri = "https://upload.wikimedia.org/wikipedia/commons/5/51/The_Wolves_Pursuing_Sol_and_Mani.jpg",
            owner = darko
        ))
    }
}