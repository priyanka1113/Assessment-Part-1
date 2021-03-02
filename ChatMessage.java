package com.priyanka.model;

public class ChatMessage {
	private String data;
	private String sender;
	private messageType type;

	public enum messageType {
		CHAT, LEAVE, JOIN
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public messageType getType() {
		return type;
	}

	public void setType(messageType type) {
		this.type = type;
	};

}
