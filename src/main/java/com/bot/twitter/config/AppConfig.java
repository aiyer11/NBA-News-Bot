package com.bot.twitter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bot.twitter.properties.AppProperties;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class AppConfig {

	@Autowired
	private AppProperties properties;

	@Bean
	public HttpResponse<JsonNode> request() throws UnirestException {
		return Unirest.get(properties.getHost()).header("X-RapidApi-Key", properties.getApiKey()).asJson();
	}

	@Bean
	public Twitter twitterInstance() {
		ConfigurationBuilder c = new ConfigurationBuilder();
		c.setApplicationOnlyAuthEnabled(false);
		c.setOAuthConsumerKey(properties.getConsumerKey());
		c.setOAuthConsumerSecret(properties.getConsumerSecret());
		c.setOAuthAccessTokenSecret(properties.getAccessTokenSecret());
		c.setOAuthAccessToken(properties.getAccessToken());
		TwitterFactory tf = new TwitterFactory(c.build());
		return tf.getInstance();
	}

}
