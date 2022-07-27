package com.bot.twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bot.twitter.model.Tweet;
import com.bot.twitter.service.SendTweet;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

@Controller
public class TweetController {

	@Autowired
	private SendTweet tweet;

	@Autowired
	private HttpResponse<JsonNode> news;

	private boolean send(Tweet t) {
		String tweetText = t.getTitle() + " " + t.getUrl();
		return tweet.sendTweet(tweetText);
	}

	public String generateTweets() throws UnirestException {
		JSONArray resp = news.getBody().getArray();
		System.out.println(resp);
		for (int i = 0; i < resp.length(); i++) {
			JSONObject j = resp.getJSONObject(i);
			Tweet t = new Tweet(j.getString("title"), j.getString("url"));
			if (this.send(t)) {
				continue;
			}
		}
		return "Tweets successfully sent!";
	}

}
