package com.app.business.dao;

import com.app.business.bo.BiblioUser;

import com.boudaa.dao.GenericDao;

public interface UserDao extends GenericDao<BiblioUser, Long> {

	public BiblioUser getUserByLogin(String pLogin);
}
