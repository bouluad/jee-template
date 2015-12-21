package com.app.business.dao.impl;

import com.app.business.bo.Rayon;
import com.app.business.dao.RayonDao;
import com.boudaa.dao.impl.GenericDaoImpl;

public class RayonDaoImpl extends GenericDaoImpl<Rayon, Long> implements
		RayonDao {

	public RayonDaoImpl() {
		super(Rayon.class);
	}
}
