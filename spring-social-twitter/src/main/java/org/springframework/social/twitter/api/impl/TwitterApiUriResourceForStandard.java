package org.springframework.social.twitter.api.impl;

public enum TwitterApiUriResourceForStandard {
	BLOCKS("blocks/list.json"),
	BLOCKS_IDS("blocks/ids.json"),
	BLOCKS_CREATE("blocks/create.json"),
	BLOCKS_DESTROY("blocks/destroy.json"),
	
	DIRECTMESSAGES("direct_messages.json"),
	DIRECTMESSAGES_SENT("direct_messages/sent.json"),
	DIRECTMESSAGES_SHOW("direct_messages/show.json"),
	DIRECTMESSAGES_NEW("direct_messages/new.json"),
	DIRECTMESSAGES_DESTROY("direct_messages/destroy.json"),
	
	FRIENDS("friends/list.json"),
	FRIENDS_IDS("friends/ids.json"),
	
	FOLLOWERS("followers/list.json"),
	FOLLOWERS_IDS("followers/ids.json"),
	
	FRIENDSHIPS_CREATE("friendships/create.json"),
	FRIENDSHIPS_DESTROY("friendships/destroy.json"),
	FRIENDSHIPS_UPDATE("friendships/update.json"),
	FRIENDSHIPS_INCOMING("friendships/incoming.json"),
	FRIENDSHIPS_OUTGOING("friendships/outgoing.json");
	
	private final String name;
	
	TwitterApiUriResourceForStandard(String path) {
		this.name = path;
	}
	
	public String getPath() {
		return this.name;
	}
}
