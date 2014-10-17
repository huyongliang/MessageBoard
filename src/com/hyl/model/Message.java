package com.hyl.model;

import java.util.Date;

public class Message {
	private int id;
	private int catagoryId;
	private String from;
	private String to;
	private String content;
	private Date time;

	public Message() {
		super();
	}

	public Message(int id, int catagoryId, String from, String to,
			String content, Date time) {
		super();
		this.id = id;
		this.catagoryId = catagoryId;
		this.from = from;
		this.to = to;
		this.content = content;
		this.time = time;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCatagoryId() {
		return catagoryId;
	}

	public void setCatagoryId(int catagoryId) {
		this.catagoryId = catagoryId;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", catagoryId=" + catagoryId + ", from="
				+ from + ", to=" + to + ", content=" + content + ", time="
				+ time + "]";
	}

}
