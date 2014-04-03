package br.com.bibliotecaVT.controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.bibliotecaVT.dao.DAO;
import br.com.bibliotecaVT.modelo.Orientador;
import br.com.bibliotecaVT.util.Resultado;

public class VOControleOrientador {

	public Resultado cadastrarOuAtualizar(Orientador orientador) {
		DAO<Orientador> dao = new DAO<Orientador>(Orientador.class);
		if(orientador.getId()==0){
			try {
				dao.adiciona(orientador);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Concluído" , "Cadastro realizado com sucesso"));
			} catch (Exception e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro" , "O cadastro não pode ser realizado"));
			}
		}
		else{
			dao.atualiza(orientador);
		}
		return null;
	}

	public List<Orientador> listarOrientadores() {
		DAO<Orientador> dao = new DAO<Orientador>(Orientador.class);
		return dao.listaTodos();
	}

	public Orientador buscaPorCPF(long cpf) {
		DAO<Orientador> dao = new DAO<Orientador>(Orientador.class);
		return dao.buscaPorCPF(cpf);
	}

}
