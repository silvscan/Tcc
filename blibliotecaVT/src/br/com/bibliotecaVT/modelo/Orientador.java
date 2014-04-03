package br.com.bibliotecaVT.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBORIENTADOR") 
public class Orientador extends Pessoa{
	@GeneratedValue
	private long id;
	private String email;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 
	
	@Override
	public String toString() {
		return super.getNome();
	}
}
