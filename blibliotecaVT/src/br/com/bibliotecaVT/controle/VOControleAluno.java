package br.com.bibliotecaVT.controle;

import br.com.bibliotecaVT.dao.DAO;
import br.com.bibliotecaVT.modelo.Aluno;
import br.com.bibliotecaVT.util.Resultado;

public class VOControleAluno {

	public Resultado cadastrar(Aluno aluno) {
		DAO<Aluno> dao = new DAO<Aluno>(Aluno.class);
		dao.adiciona(aluno); 
		return null;
	}

}
