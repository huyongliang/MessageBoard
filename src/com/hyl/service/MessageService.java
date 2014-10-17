package com.hyl.service;

import java.sql.Connection;
import java.util.Date;

import com.hyl.dao.CatagoryDAOImpl;
import com.hyl.dao.MessageDAOImpl;
import com.hyl.model.Catagory;
import com.hyl.model.Message;

public class MessageService {
	private Connection conn;

	public MessageService(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addCatagoryAndMsg(Message message) {
		Catagory c = new Catagory(0);
		c.setDesc("Â¥Ö÷:" + message.getFrom());
		int cid = new CatagoryDAOImpl(conn).addCatagory(c);
		if (cid > 0) {
			message.setCatagoryId(cid);
			if (new MessageDAOImpl(conn).doCreate(message)) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}
}
