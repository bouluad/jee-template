package com.app.web.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.app.business.bo.BiblioUser;
import com.app.business.bo.Role;
import com.app.business.service.UserManager;
import com.app.business.service.exceptions.DuplicateLoginException;

public class UserManagerBean extends BaseManagedBean {

	private BiblioUser user = new BiblioUser();
	private UserManager userManagerService;

	private List<BiblioUser> listeUsers;

	private static List<String> listRoles = new ArrayList<String>();

	public UserManagerBean() {
		user.setRole(new Role());
	}

	@PostConstruct
	public void updateData() {
		listeUsers = userManagerService.getAllUser();
		user = new BiblioUser();
		user.setRole(new Role());

	}

	public void initForm() {

		if (listRoles.size() == 0) {
			List<Role> roles = userManagerService.getAllRoles();
			for (Role r : roles) {
				listRoles.add(r.getRoleName());
			}
		}

	}

	public String newUser() {
		return adminPage("newUser");
	}

	public String insription() {
		try {
			user.setRole(userManagerService.getRoleByName("ROLE_USER"));
			userManagerService.addUser(user);
			updateData();

		} catch (DuplicateLoginException ex) {

			addErrorMessage("messages", "Erreur:", "le nom d'utilisateur "
					+ user.getLogin() + " existe déjà.");

			return null;
		} catch (Exception ex) {

			addErrorMessage("messages", "Erreur:", "Erreur d'inscription");
			log.error("Erreur à cause de : " + ex);
			return null;
		}
		return userPage("home");
	}

	public String addUser() {

		try {
			user.setRole(userManagerService.getRoleByName(user.getRole()
					.getRoleName()));
			userManagerService.addUser(user);
			updateData();

			addInfoMessage("messages", "Utilisateur ajouté :",
					"l'utilisateur est ajouté dans le système");
		} catch (Exception ex) {

			addErrorMessage("messages", "Erreur:",
					"Erreur lors de l'ajout de l'utilisateur");

			return errorPage();
		}

		return adminPage("listUsers");
	}

	public void deleteUser(BiblioUser u) {

		userManagerService.deleteUser(u);
		updateData();

	}

	public BiblioUser getUser() {
		return user;
	}

	public void setUser(BiblioUser user) {
		this.user = user;
	}

	public UserManager getUserManagerService() {
		return userManagerService;
	}

	public void setUserManagerService(UserManager userManagerService) {
		this.userManagerService = userManagerService;
	}

	public List<String> getListRoles() {
		return listRoles;
	}

	public List<BiblioUser> getListeUsers() {
		return listeUsers;
	}

	public void setListeUsers(List<BiblioUser> listeUsers) {
		this.listeUsers = listeUsers;
	}

}
