package com.bot.twitter;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bot.twitter.controller.TweetController;

@SpringBootApplication
public class TwitterBotApplication {

	@Autowired
	TweetController tweets;

	public static void main(String[] args) {
		SpringApplication.run(TwitterBotApplication.class, args);
	}

	@Bean
	public Supplier<String> generateTweets() {
		return () -> tweets.generateTweets();
	}

}
