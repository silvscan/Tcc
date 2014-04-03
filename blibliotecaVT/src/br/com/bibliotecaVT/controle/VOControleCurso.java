package br.com.bibliotecaVT.controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.bibliotecaVT.dao.DAO;
import br.com.bibliotecaVT.modelo.Curso;
import br.com.bibliotecaVT.util.Resultado;


public class VOControleCurso {

	public Resultado cadastrar(Curso curso) {
		DAO<Curso> dao = new DAO<Curso>(Curso.class);
		try {
			dao.adiciona(curso);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Concluído" , "Cadastro realizado com sucesso"));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro" , "O cadastro não pode ser realizado"));
		} 
		return null;
	}

	public List<Curso> listarCursos() {
		DAO<Curso> dao = new DAO<Curso>(Curso.class);
		return dao.listaTodos();
	}

	public Curso buscaPorId(long codCurso) {
		DAO<Curso> dao = new DAO<Curso>(Curso.class);
		return dao.buscaPorId(codCurso);
	}
	
}
