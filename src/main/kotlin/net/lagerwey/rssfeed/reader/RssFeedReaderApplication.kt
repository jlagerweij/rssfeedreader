package net.lagerwey.rssfeed.reader

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class RssFeedReaderApplication

fun main(args: Array<String>) {
    SpringApplication.run(RssFeedReaderApplication::class.java, *args)
}