package net.lagerwey.rssfeed.reader

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class RssToJsonConverter {
    @Scheduled(fixedDelay = 1000)
    fun doit() {
        println("Do it....")
    }
}