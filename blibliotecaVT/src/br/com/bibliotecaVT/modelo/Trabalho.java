package br.com.bibliotecaVT.modelo;

import java.util.Date;

public class Trabalho {
	private String titTrabalho;
	private int codFaculdade;
	private Date dataConclusao;
	private int codAluno;
	private int codOrientador;
	private int codCurso;
	
	public String getTitTrabalho() {
		return titTrabalho;
	}
	public void setTitTrabalho(String titTrabalho) {
		this.titTrabalho = titTrabalho;
	}
	public int getCodFaculdade() {
		return codFaculdade;
	}
	public void setCodFaculdade(int codFaculdade) {
		this.codFaculdade = codFaculdade;
	}
	public Date getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public int getCodAluno() {
		return codAluno;
	}
	public void setCodAluno(int codAluno) {
		this.codAluno = codAluno;
	}
	public int getCodOrientador() {
		return codOrientador;
	}
	public void setCodOrientador(int codOrientador) {
		this.codOrientador = codOrientador;
	}
	public int getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}
}
