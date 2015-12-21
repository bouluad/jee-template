package com.app.web.managedbeans.customizedauthentication;

import java.io.IOException;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.context.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.authority.*;
import org.springframework.security.core.context.SecurityContextHolder;

import com.app.web.managedbeans.BaseManagedBean;
import com.app.web.utils.UAgentInfo;

public class LoginBean extends BaseManagedBean {
	private String username;
	private String password;

	public String doLogin() throws IOException, ServletException {
		addErrorMessage("messages", "er", "er");

		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		addErrorMessage("messages", "er", "er");

		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
				.getRequestDispatcher("/j_spring_security_check?j_username="
						+ username + "&j_password=" + password);

		dispatcher.forward((ServletRequest) context.getRequest(),
				(ServletResponse) context.getResponse());

		FacesContext.getCurrentInstance().responseComplete();
		// It's OK to return null here because Faces is just going to exit.

		return null;
	}

	public void redirect() throws IOException {

		
	
		
		String contextPath  = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() ;

		HttpServletRequest request = getRequest();
		String userAgent = request.getHeader("User-Agent");
		String httpAccept = request.getHeader("Accept");
		System.out.println(userAgent);
		UAgentInfo detector = new UAgentInfo(userAgent, httpAccept); // accéder
																		// aux
																		// context
																		// de
																		// sécurité

		Collection ath = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();

		if (ath.contains(new GrantedAuthorityImpl("ROLE_USER"))) {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(contextPath+"/pages/user/home.xhtml");
		}

		else if (ath.contains(new GrantedAuthorityImpl("ROLE_ADMIN"))) {

			// si le navigateur est de type mobile

			if (detector.detectIphone())

				FacesContext
						.getCurrentInstance()
						.getExternalContext()
						.redirect(
								contextPath+"/pages/admin/mobile/newBook.xhtml");

			else
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect(contextPath+"/pages/admin/home.xhtml");

		}

	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}