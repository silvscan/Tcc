package br.com.bibliotecaVT.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.bibliotecaVT.mb.LoginBean;

public class Autorizador implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		if ("/cadastro.xhtml".equals(context.getViewRoot().getViewId())){
			LoginBean loginBean = context.getApplication().evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
			
			if (!loginBean.isLogado()){
				NavigationHandler handler = context.getApplication().getNavigationHandler();
				handler.handleNavigation(context, null, "principal? faces-redirect=true");
				context.renderResponse();
			}
		}
		return;
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
