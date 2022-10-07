package net.lagerwey.rssfeed.reader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RssFeedReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(RssFeedReaderApplication.class, args);
	}

}
