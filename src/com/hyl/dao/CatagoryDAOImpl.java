package com.hyl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hyl.model.Catagory;
import com.hyl.model.Message;

public class CatagoryDAOImpl {
	private Connection conn;

	public CatagoryDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public List<Catagory> doListCatagories() {
		List<Catagory> catagories = new ArrayList<>();

		List<Message> messages = new MessageDAOImpl(conn).doList();
		catagories = parseCatagory(this.getCatagoryOnly(), messages);
		return catagories;
	}

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

	private List<Catagory> getCatagoryOnly() {
		List<Catagory> ids = new ArrayList<>();
		String sql = "select id,dsc from catagory";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = this.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			Catagory c = null;
			while (rs.next()) {
				c = new Catagory();
				c.setId(rs.getInt(1));
				c.setDesc(rs.getString(2));
				ids.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ids;
	}

	public synchronized int addCatagory(Catagory c) {
		String sql="insert into catagory (id,dsc) values"
				+ " (null,?)";
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, c.getDesc());
			if(ps.executeUpdate()>0){
				sql="select max(id) from catagory";
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next()){
					return rs.getInt(1);
				}
			}
			else{
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
