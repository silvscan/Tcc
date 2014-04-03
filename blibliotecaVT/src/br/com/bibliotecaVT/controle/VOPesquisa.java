package br.com.bibliotecaVT.controle;

import java.util.List;

import br.com.bibliotecaVT.dao.DAO;
import br.com.bibliotecaVT.modelo.Trabalho;


public class VOPesquisa {

	public List<Trabalho> pesquisarTrabalhos(long codCurso, long idAConhecimento, int firstResult, int maxResults) {
		DAO<Trabalho> dao = new DAO<Trabalho>(Trabalho.class);
		List<Trabalho> lista;
		String query = montarQuery(codCurso, idAConhecimento);
		if(!query.equals("")){
			lista = dao.listaTrabalhosPagComFiltro(query, firstResult, maxResults);
		} else {
			lista = dao.listaTodosPaginada(firstResult, maxResults);
		}
		return lista;
	}

	private String montarQuery(long codCurso,	long idAConhecimento) {
		String query = "";
		if(codCurso > 0 ||	idAConhecimento > 0){
			query = "select tb from Trabalho tb where ";
			return completeQuery(codCurso, idAConhecimento,query);
		}
		return "";
	}

	private String completeQuery(long codCurso, long idAConhecimento, String query) {
		int cont = 0;
		if(codCurso>0){
			query += "tb.curso.codCurso ="+codCurso;
			cont++;
		}
		if(idAConhecimento>0){
			if(cont>0){
				query += " and tb.curso.areaConhecimento ="+idAConhecimento;
			} else {
				query += "tb.curso.areaConhecimento ="+idAConhecimento;
			}
		}
		return query;
	}
}
