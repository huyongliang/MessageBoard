package com.hyl.dao;

import java.util.List;

import com.hyl.model.Message;

public interface MessageDAO {
	boolean doCreate(Message message);

	List<Message> doList();
}
