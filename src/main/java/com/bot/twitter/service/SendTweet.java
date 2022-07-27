package com.bot.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Service
public class SendTweet {

	@Autowired
	private Twitter tweet;

	public boolean sendTweet(String message) {
		Status s;
		try {
			s = tweet.updateStatus(message);
		} catch (TwitterException e) {
			if (e.getErrorCode() == 187) {
				return true;
			}
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
