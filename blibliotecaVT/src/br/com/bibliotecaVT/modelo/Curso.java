package br.com.bibliotecaVT.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tbCurso")
public class Curso {
	@Id
	@GeneratedValue
	private long codCurso;
	@ManyToOne 
	private AreaConhecimento areaConhecimento;
	private String tituloCurso;
	
	public String getTituloCurso() {
		return tituloCurso;
	}
	public void setTituloCurso(String tituloCurso) {
		this.tituloCurso = tituloCurso;
	}
	public long getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(long codCurso) {
		this.codCurso = codCurso;
	}
	public AreaConhecimento getAreaConhecimento() {
		return areaConhecimento;
	}
	public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}
}
