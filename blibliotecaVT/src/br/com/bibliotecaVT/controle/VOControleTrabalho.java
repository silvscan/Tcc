package br.com.bibliotecaVT.controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.bibliotecaVT.dao.DAO;
import br.com.bibliotecaVT.modelo.Trabalho;
import br.com.bibliotecaVT.util.Resultado;

public class VOControleTrabalho {

	public Resultado cadastrar(Trabalho trabalho) {
		DAO<Trabalho> dao = new DAO<Trabalho>(Trabalho.class);
		try {
			dao.adiciona(trabalho);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Concluído" , "Cadastro realizado com sucesso"));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro" , "O cadastro não pode ser realizado"));
		}
		return null;
	}

	public List<Trabalho> listarTodos() {
		DAO<Trabalho> dao = new DAO<Trabalho>(Trabalho.class);
		return dao.listaTodosPaginada(0, 5);
	}

	public void cadastrarVoto(Long idTrabalho, long score) {
		DAO<Trabalho> dao = new DAO<Trabalho>(Trabalho.class);
		Trabalho trabalho = dao.buscaPorId(idTrabalho);
		trabalho.setTotalVotos(trabalho.getTotalVotos()+score);
		trabalho.setQuantidadeVotos(trabalho.getQuantidadeVotos()+1);
		trabalho.setScore(trabalho.getTotalVotos() / trabalho.getQuantidadeVotos());
		dao.atualiza(trabalho);
	}

}
