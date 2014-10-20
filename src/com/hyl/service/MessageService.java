package com.hyl.service;

import com.hyl.model.Message;

public interface MessageService {
	boolean addMsgOnly(Message message);
	boolean addNewCataAndMsg(Message message);
}
