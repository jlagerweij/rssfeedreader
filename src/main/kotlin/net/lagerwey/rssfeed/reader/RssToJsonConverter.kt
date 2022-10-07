package net.lagerwey.rssfeed.reader;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RssToJsonConverter {

    @Scheduled(fixedDelay = 1000)
    public void doit() {
        System.out.println("Do it....");
    }
}
