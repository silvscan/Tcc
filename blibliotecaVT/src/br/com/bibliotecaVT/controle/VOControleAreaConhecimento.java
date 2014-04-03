package br.com.bibliotecaVT.controle;

import java.util.List;
import br.com.bibliotecaVT.dao.DAO;
import br.com.bibliotecaVT.modelo.AreaConhecimento;

public class VOControleAreaConhecimento {

	public List<AreaConhecimento> listarAreas() {
		DAO<AreaConhecimento> dao = new DAO<AreaConhecimento>(AreaConhecimento.class);
		return dao.listaTodos();
	}
	
	public AreaConhecimento buscaPorId(long id){
		DAO<AreaConhecimento> dao = new DAO<AreaConhecimento>(AreaConhecimento.class);
		return dao.buscaPorId(id);
	}

}
