package br.com.bibliotecaVT.mb;

import javax.faces.bean.ManagedBean;

import br.com.bibliotecaVT.controle.VOControleAluno;
import br.com.bibliotecaVT.modelo.Aluno;
import br.com.bibliotecaVT.modelo.Curso;
import br.com.bibliotecaVT.modelo.Orientador;
import br.com.bibliotecaVT.modelo.Trabalho;
import br.com.bibliotecaVT.util.Resultado;

@ManagedBean
public class CadastroBean {
	private Aluno aluno = new Aluno();
	private Orientador orientador = new Orientador();
	private Curso curso = new Curso();
	private Trabalho trabalho = new Trabalho();
	private VOControleAluno voCadastrarAluno = new VOControleAluno();
	
	public void cadastrarAluno(){
		voCadastrarAluno = new VOControleAluno();
		Resultado resultado = voCadastrarAluno.cadastrar(aluno);
		System.out.println(resultado);
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Orientador getOrientador() {
		return orientador;
	}
	public void setOrientador(Orientador orientador) {
		this.orientador = orientador;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Trabalho getTrabalho() {
		return trabalho;
	}
	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}
}
