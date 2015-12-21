package com.app.business.dao.impl;

import com.app.business.bo.Theme;
import com.app.business.dao.ThemeDao;
import com.boudaa.dao.impl.GenericDaoImpl;

public class ThemeDaoImpl extends GenericDaoImpl<Theme, Long> implements
		ThemeDao {

	public ThemeDaoImpl() {
		super(Theme.class);
	}

}
