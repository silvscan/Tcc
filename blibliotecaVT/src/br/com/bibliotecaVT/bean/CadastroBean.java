package br.com.bibliotecaVT.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bibliotecaVT.controle.VOControleAluno;
import br.com.bibliotecaVT.obj.Aluno;
import br.com.bibliotecaVT.obj.Curso;
import br.com.bibliotecaVT.obj.Orientador;
import br.com.bibliotecaVT.obj.Trabalho;
import br.com.bibliotecaVT.util.Resultado;

@ManagedBean
@RequestScoped
public class CadastroBean {
	private Aluno aluno;
	private Orientador orientador;
	private Curso curso;
	private Trabalho trabalho;
	private VOControleAluno voCadastrarAluno;
	
	private void cadastrarAluno(){
		voCadastrarAluno = new VOControleAluno();
		Resultado resultato = voCadastrarAluno.cadastrar(aluno);
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
