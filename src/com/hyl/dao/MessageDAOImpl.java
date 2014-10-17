package com.hyl.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hyl.DBUtils;
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
				+ " (id,catagoryId,from_,to_,content,time_)"
				+ " values(null,?,?,?,?,?)";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, message.getCatagoryId());
			ps.setString(2, message.getFrom());
			ps.setString(3, message.getTo());
			ps.setString(4, message.getContent());
			ps.setDate(5, new Date(new java.util.Date().getTime()));

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(null, ps, null);
		}
		return false;
	}

	@Override
	public List<Message> doList() {
		List<Message> list = new ArrayList<>();
		String sql = "select id,catagoryId,from_,to_,content,time_ from message"
				+ " order by  catagoryId, id";
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
				m.setTo(rs.getString(4));
				m.setContent(rs.getString(5));
				m.setTime(rs.getDate(6));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(rs, ps, null);
		}
		return list;
	}

}
