package com.app.business.dao.impl;

import java.util.List;

import org.hibernate.loader.custom.Return;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.app.business.bo.Role;
import com.app.business.dao.RoleDao;
import com.boudaa.dao.impl.GenericDaoImpl;

public class RoleDaoImpl extends GenericDaoImpl<Role, Long> implements RoleDao {

	public RoleDaoImpl() {
		super(Role.class);
	}

	public Role getRoleByName(String pRole) {
		List roles = getHibernateTemplate().find("from Role where roleName=?",
				pRole);

		if (roles == null || roles.isEmpty())
			throw new ObjectRetrievalFailureException(Role.class, pRole);

		return (Role) roles.get(0);
	}
}
