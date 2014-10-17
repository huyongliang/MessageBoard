package com.hyl.model;

import java.util.ArrayList;
import java.util.List;

public class Catagory {
	private int id;
	private String desc;
	private List<Message> messages = new ArrayList<>();

	public Catagory(int id, List<Message> messages) {
		super();
		this.id = id;
		this.messages = messages;
	}

	public Catagory(int id) {
		super();
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Catagory() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void addMsg(Message msg) {
		this.messages.add(msg);
	}

	@Override
	public String toString() {
		return "Catagory [id=" + id + ", messages=" + messages + "]\n";
	}
}
