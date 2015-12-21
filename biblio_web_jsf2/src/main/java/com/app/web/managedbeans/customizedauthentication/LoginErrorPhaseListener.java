package com.app.web.managedbeans.customizedauthentication;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class LoginErrorPhaseListener implements PhaseListener {
	private static final long serialVersionUID = -1216620620302322995L;

	@Override
	public void afterPhase(final PhaseEvent arg0) {
	}

	@Override
	public void beforePhase(final PhaseEvent arg0) {
		Exception e = (Exception) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSessionMap()
				.get(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY);

		if (e instanceof BadCredentialsException) {
			FacesContext
					.getCurrentInstance()
					.getExternalContext()
					.getSessionMap()
					.put(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY,
							null);
			addErrorMessage("Impossible de se connecter, le nom d'utilisateur ou le mots de passe sont invalides");
		}

		else if (e instanceof DisabledException) {
			FacesContext
					.getCurrentInstance()
					.getExternalContext()
					.getSessionMap()
					.put(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY,
							null);
			addErrorMessage("Impossible de se connecter, le compte est desactivé.");
		}

		else if (e instanceof LockedException) {
			FacesContext
					.getCurrentInstance()
					.getExternalContext()
					.getSessionMap()
					.put(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY,
							null);
			addErrorMessage("Impossible de se connecter, le compte est verrouillé");
		}

		else if (e instanceof AuthenticationException) {
			FacesContext
					.getCurrentInstance()
					.getExternalContext()
					.getSessionMap()
					.put(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY,
							null);
			addErrorMessage("Impossible de se connecter, veuillez contacter l'administrateur");
		}

	}

	public void addErrorMessage(String msg) {
		addMessage(FacesMessage.SEVERITY_ERROR, msg);
	}

	private void addMessage(FacesMessage.Severity severity, String msg) {
		System.out.println("iii");
		final FacesMessage facesMsg = new FacesMessage(severity, msg, msg);
		FacesContext.getCurrentInstance().addMessage("messages", facesMsg);
	}

	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}