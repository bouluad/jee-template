package com.app.business.service;

import java.util.List;

import com.app.business.bo.BiblioUser;
import com.app.business.bo.Role;
import com.app.business.service.exceptions.DuplicateLoginException;

public interface UserManager {

	public void addUser(BiblioUser user) throws DuplicateLoginException;

	public List<Role> getAllRoles();

	public List<BiblioUser> getAllUser();

	public void deleteUser(BiblioUser u);

	public Role getRoleByName(String pRoleName);

}
