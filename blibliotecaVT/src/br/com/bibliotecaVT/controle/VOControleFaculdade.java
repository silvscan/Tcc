package br.com.bibliotecaVT.controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.bibliotecaVT.dao.DAO;
import br.com.bibliotecaVT.modelo.Faculdade;

public class VOControleFaculdade {

	public Faculdade buscaPorId(long codFaculdade) {
		DAO<Faculdade> dao = new DAO<Faculdade>(Faculdade.class);
		return dao.buscaPorId(codFaculdade);
	}

	public void cadastrarFaculdade(Faculdade faculdade) {
		DAO<Faculdade> dao = new DAO<Faculdade>(Faculdade.class);
		try {
			dao.adiciona(faculdade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Concluído" , "Cadastro realizado com sucesso"));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro" , "O cadastro não pode ser realizado"));
		} 
	}

	public List<Faculdade> listarFaculdades() {
		DAO<Faculdade> dao = new DAO<Faculdade>(Faculdade.class);
		return dao.listaTodos();
	}

}
