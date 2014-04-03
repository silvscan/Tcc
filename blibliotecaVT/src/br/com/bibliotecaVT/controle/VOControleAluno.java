package br.com.bibliotecaVT.controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.bibliotecaVT.dao.DAO;
import br.com.bibliotecaVT.modelo.Aluno;
import br.com.bibliotecaVT.util.Resultado;

public class VOControleAluno {

	public Resultado cadastrarOuAtualizar(Aluno aluno) {
		DAO<Aluno> dao = new DAO<Aluno>(Aluno.class);
		if(aluno.getId()==0){
			try{
				dao.adiciona(aluno);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro Efetuado", "Cadastro realizado com sucesso"));
			} catch(Exception e){
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "Não foi possível realizar o cadastro"));
			}
		} else {
			dao.atualiza(aluno);
		}
		return null;
	}

	public List<Aluno> listarAlunos() {
		DAO<Aluno> dao = new DAO<Aluno>(Aluno.class);
		return dao.listaTodos();
	}

	public Aluno buscaPorCPF(long cpf) {
		DAO<Aluno> dao = new DAO<Aluno>(Aluno.class);
		return dao.buscaPorId(cpf);
	}

}
