package com.hyl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hyl.DBUtils;
import com.hyl.dao.CatagoryDAO;
import com.hyl.model.Catagory;

public class CatagoryDAOImpl implements CatagoryDAO {
	private Connection conn;

	public CatagoryDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public List<Catagory> doListCatagories() {
		List<Catagory> ids = new ArrayList<>();
		String sql = "select id,dsc from catagory order by id desc";
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
		finally{
			DBUtils.release(rs, ps);
		}
		return ids;
	}

	@Override
	public synchronized int doCreateCatagory(Catagory c) {
		String sql = "insert into catagory (id,dsc) values" + " (null,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, c.getDesc());
			if (ps.executeUpdate() > 0) {
				sql = "select max(id) from catagory";
				ps = this.conn.prepareStatement(sql);
				rs = ps.executeQuery();
				if (rs.next()) {
					return rs.getInt(1);
				}
				
				
			} else {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtils.release(rs, ps);
		}

		return -1;
	}
}
