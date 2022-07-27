package com.bot.twitter.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Component
@NoArgsConstructor
public class Tweet {

	private String title;

	private String url;

	public Tweet(String title, String url) {
		this.title = title;
		this.url = url;
	}

	public String toString() {
		return this.title + "-" + this.url;
	}

}
