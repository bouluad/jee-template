package com.app.business.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.app.business.bo.BiblioUser;
import com.app.business.bo.Role;
import com.app.business.dao.RoleDao;
import com.app.business.dao.UserDao;
import com.app.business.service.UserManager;
import com.app.business.service.exceptions.DuplicateLoginException;

public class UserMangerService implements UserManager, UserDetailsService {

	private UserDao userDao;

	private RoleDao roleDao;

	protected final Log log = LogFactory.getLog(getClass());

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDetails loadUserByUsername(String pLogin)
			throws UsernameNotFoundException {

		BiblioUser biblioUser = null;
		Collection<GrantedAuthority> arrayAuths = new ArrayList<GrantedAuthority>();

		// On récupère un objet de domaine de type User ayant comme login pLogin
		try {
			biblioUser = userDao.getUserByLogin(pLogin);
		} catch (ObjectRetrievalFailureException ex) {

			// nous relançons une UsernameNotFoundException si aucun utilisateur
			// ne correspond à cet login
			log.debug("Erreur d'authentification avec le login : " + pLogin);
			throw new UsernameNotFoundException("User " + pLogin
					+ " not exists", ex);

		}

		// Si un utilisateur correspond à cet identifiant, nous en profitons
		// pour mettre à jour sa date de dernière connexion
		biblioUser.setLastAccessDate(Calendar.getInstance().getTime());
		userDao.update(biblioUser);
		// Il faut ensuite récupérer les rôles de l’utilisateur et les mettre
		// sous la forme de GrantedAuthority, une interface propre à Spring
		// Security*

		Role role = biblioUser.getRole();
		arrayAuths.add(new GrantedAuthorityImpl(role.getRoleName()));
		// /un User (classe Spring Security) est créé
		return new User(pLogin, biblioUser.getPassword(),
				biblioUser.getEnabled(), biblioUser.isAccountNotExpired(),
				true, biblioUser.isAccountNotLocked(), arrayAuths);
	}


	public void addUser(BiblioUser user) throws DuplicateLoginException {

		// pour hacher avec SHA1
		ShaPasswordEncoder encoder = new ShaPasswordEncoder();

		// Hachage du mot de passe avec un gain de sel variable = login
		String cryptedPassword = encoder.encodePassword(user.getPassword(),
				user.getLogin());

		// affecter le mot de passe haché
		user.setPassword(cryptedPassword);

		// stockage de l'utilisateur dans la base de données
		try {
			userDao.create(user);

		} catch (DataIntegrityViolationException ex) {
			log.error("erreur d'ajout d'un utilisateur à cause de l'exception "
					+ ex + " . un utilisateur avec le login " + user.getLogin()
					+ " existe déjà dans la base de données");
			throw new DuplicateLoginException(
					"Erreur d'inscription, login existe déjà", ex);
		}

	}

	public List<Role> getAllRoles() {
		return roleDao.getAll();
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public List<BiblioUser> getAllUser() {
		return userDao.getAll();
	}

	public Role getRoleByName(String pRoleName) {
		return roleDao.getRoleByName(pRoleName);
	}

	public void deleteUser(BiblioUser u) {

		userDao.delete(u.getId());

	}

}
