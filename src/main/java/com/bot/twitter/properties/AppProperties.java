package com.bot.twitter.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class AppProperties {

	@Value("${api.host}")
	private String host;

	@Value("${rapidApi.key}")
	private String apiKey;

	@Value("${oauth.consumerKey}")
	private String consumerKey;

	@Value("${oauth.consumerSecret}")
	private String consumerSecret;

	@Value("${oauth.accessToken}")
	private String accessToken;

	@Value("${oauth.accessTokenSecret}")
	private String accessTokenSecret;

}
