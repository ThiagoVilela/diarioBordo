package com.thiago;

import java.util.Date;

public class Avaliacao {
/************************************************************************************************************/	
	//Atributos
	private String nome;
	private String tipo;
	private double peso;
	private double media;
	private Date dataAplicacao;
	private int nota;

/************************************************************************************************************/	
	//Construtores
	public Avaliacao(){}
	
	public Avaliacao(String nome, double peso){
		this.nome = nome;
		this.peso = peso;
	}
	
	public Avaliacao(String nome, double peso, double media){
		this.nome = nome;
		this.peso = peso;
		this.media = media;
	}
	
	public Avaliacao(String nome, String tipo, double peso, double media){
		this.nome = nome;
		this.tipo = tipo;
		this.peso = peso;
		this.media = media;
	}
	
	public Avaliacao(String nome, String tipo){
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public Avaliacao(String nome, String tipo, double peso, double media, Date data){
		this.nome = nome;
		this.tipo = tipo;
		this.peso = peso;
		this.media = media;
		this.dataAplicacao = data;
	}
	
	public Avaliacao(String nome, String tipo, double peso, double media, Date data, int nota){
		this.nome = nome;
		this.tipo = tipo;
		this.peso = peso;
		this.media = media;
		this.dataAplicacao = data;
		this.nota = nota;
	}
/************************************************************************************************************/
	//Métodos acessores
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	public Date getDataAplicacao() {
		return dataAplicacao;
	}
	public void setDataAplicacao(Date dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	
}
