package com.hyl.service.impl;

import java.sql.Connection;

import com.hyl.DBUtils;
import com.hyl.dao.impl.CatagoryDAOImpl;
import com.hyl.dao.impl.MessageDAOImpl;
import com.hyl.model.Catagory;
import com.hyl.model.Message;
import com.hyl.service.MessageService;

public class MessageServiceImpl implements MessageService {
	private Connection conn;

	public MessageServiceImpl() {
		super();
		this.conn = DBUtils.getConnection();
	}

	@Override
	public boolean addMsgOnly(Message message) {

		try {
			return new MessageDAOImpl(conn).doCreate(message);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtils.release(conn);
		}

	}

	@Override
	public boolean addNewCataAndMsg(Message message) {
		Catagory c = new Catagory(0);
		c.setDesc("Â¥Ö÷:" + message.getFrom());
		try {
			int cid = new CatagoryDAOImpl(conn).doCreateCatagory(c);
			if (cid > 0) {
				message.setCatagoryId(cid);
				return new MessageDAOImpl(conn).doCreate(message);
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(conn);
		}
		return false;
	}
}
