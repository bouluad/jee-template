package com.app.business.dao.impl;

import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.app.business.bo.BiblioUser;
import com.app.business.dao.UserDao;
import com.boudaa.dao.impl.GenericDaoImpl;

public class UserDaoImpl extends GenericDaoImpl<BiblioUser, Long> implements
		UserDao {

	public UserDaoImpl() {
		super(BiblioUser.class);
	}

	public BiblioUser getUserByLogin(String pLogin) {

		List users = getHibernateTemplate().find(
				"from BiblioUser where login = ? ", pLogin);

		if (users == null || users.size() == 0 || users.size() != 1)
			throw new ObjectRetrievalFailureException(BiblioUser.class, pLogin);

		return (BiblioUser) users.get(0);
	}

}
