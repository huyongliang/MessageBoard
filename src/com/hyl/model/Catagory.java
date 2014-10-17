package com.hyl.model;

import java.util.ArrayList;
import java.util.List;

public class Catagory {
	private int id;
	private List<Message> messages = new ArrayList<>();

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
