package br.com.bibliotecaVT.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.bibliotecaVT.dao.UsuarioDAO;
import br.com.bibliotecaVT.modelo.Usuario;

@SessionScoped
@ManagedBean
public class LoginBean {
	private Usuario usuario = new Usuario();
	
	public void efetuarLogin(){
		UsuarioDAO dao = new UsuarioDAO();
		boolean existe = dao.existe(usuario);
		
		if(existe){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Permissão concedida", "logado como: "+usuario.getLogin()));
		} else {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acesso negado", "Usuário ou senha inválidos"));
		}
	}
	
	public boolean isLogado(){
		return usuario.getLogin() != null;
	}
	
	public String deslogar(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		return "principal? faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
