package com.hyl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hyl.DBUtils;
import com.hyl.dao.MessageDAO;
import com.hyl.model.Message;

public class MessageDAOImpl implements MessageDAO {

	private Connection conn;

	public MessageDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Message message) {

		String sql = "insert into message"
				+ " (id,catagoryId,from_,content,time_)"
				+ " values(null,?,?,?,?)";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, message.getCatagoryId());
			ps.setString(2, message.getFrom());
			ps.setString(3, message.getContent());
			ps.setString(4, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(new java.util.Date()));

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtils.release(ps);
		}
		return false;
	}

	@Override
	public List<Message> doList() {
		List<Message> list = new ArrayList<>();
		String sql = "select id,catagoryId,from_,content,time_ from message"
				+ " order by  catagoryId desc, id asc";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			Message m = null;
			while (rs.next()) {
				m = new Message();
				m.setId(rs.getInt(1));
				m.setCatagoryId(rs.getInt(2));
				m.setFrom(rs.getString(3));
				m.setContent(rs.getString(4));
				String s=rs.getString(5);
				Date d=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
				m.setTime(d);
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtils.release(rs, ps);
		}
		return list;
	}

}
