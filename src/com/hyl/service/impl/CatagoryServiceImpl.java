package com.hyl.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.hyl.DBUtils;
import com.hyl.dao.impl.CatagoryDAOImpl;
import com.hyl.dao.impl.MessageDAOImpl;
import com.hyl.model.Catagory;
import com.hyl.model.Message;
import com.hyl.service.CatagoryService;

/**
 * @author HuYongliang
 *
 */
public class CatagoryServiceImpl implements CatagoryService {

	/**
	 * 传入已有的Catagory列表和Message列表，将对应的Message放到对应的Cat阿公人员之下
	 * 
	 * @param cIds
	 * @param messages
	 * @return
	 */
	private List<Catagory> parseCatagory(List<Catagory> cIds,
			List<Message> messages) {
		List<Catagory> catagories = new ArrayList<>();
		Catagory catagory = null;
		for (int i = 0; i < cIds.size(); i++) {
			catagory = cIds.get(i);
			for (int j = 0; j < messages.size(); j++) {
				if (messages.get(j).getCatagoryId() == catagory.getId())
					catagory.addMsg(messages.get(j));
			}
			catagories.add(catagory);
		}
		return catagories;
	}

	@Override
	public List<Catagory> getAllCatagoriesWithMsg() {

		Connection conn = DBUtils.getConnection();
		List<Catagory> catagories = new ArrayList<Catagory>();
		try {
			List<Catagory> cs=new CatagoryDAOImpl(conn).doListCatagories();
			List<Message> ms=new MessageDAOImpl(conn).doList();
			
			catagories=this.parseCatagory(cs, ms);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBUtils.release(conn);
		}
		return catagories;
	}
}
