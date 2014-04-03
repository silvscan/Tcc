package br.com.bibliotecaVT.modelo;

import java.util.Date; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbTrabalho")
public class Trabalho{
	@Id 
	@GeneratedValue
	private long id;
	private String titTrabalho;
	@ManyToOne
	private Faculdade faculdade;
	private Date dataConclusao;
	@ManyToOne //(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Aluno aluno;
	@ManyToOne //(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Orientador orientador;
	@ManyToOne //(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Curso curso;
	private String localArquivo;
	private long score;
	private int quantidadeVotos;
	private long totalVotos;
	
	public long getTotalVotos() {
		return totalVotos;
	}
	public void setTotalVotos(long totalVotos) {
		this.totalVotos = totalVotos;
	}
	public String getTitTrabalho() {
		return titTrabalho;
	}
	public void setTitTrabalho(String titTrabalho) {
		this.titTrabalho = titTrabalho;
	}
	
	public Date getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Orientador getOrientador() {
		return orientador;
	}
	public void setOrientador(Orientador ori) {
		this.orientador = ori;
	}
	public String getLocalArquivo() {
		return localArquivo;
	}
	public void setLocalArquivo(String localArquivo) {
		this.localArquivo = localArquivo;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	}
	public int getQuantidadeVotos() {
		return quantidadeVotos;
	}
	public void setQuantidadeVotos(int quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}
	public Faculdade getFaculdade() {
		return faculdade;
	}
	public void setFaculdade(Faculdade faculdade) {
		this.faculdade = faculdade;
	}
	
}
