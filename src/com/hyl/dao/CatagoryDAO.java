package com.hyl.dao;

import java.util.List;

import com.hyl.model.Catagory;

public interface CatagoryDAO {
	List<Catagory> doListCatagories();

	int doCreateCatagory(Catagory c);
}
