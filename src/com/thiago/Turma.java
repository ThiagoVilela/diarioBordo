package com.thiago;

import java.util.ArrayList;

public class Turma {
/************************************************************************************************************/
	//Atributos
	private String nome;
	private String sala;
	private String codigoMateria;
	private int numeroAvaliacoes = 0;
	private int numeroRecuperacoes = 0;
	
	//Alunos Cadastrados
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();;
	
	//Avaliações Cadastradas
	private ArrayList<Avaliacao> avaliacoesFormativas = new ArrayList<Avaliacao>();
	private ArrayList<AvaliacaoRecuperativa> avaliacoesRecuperativas = new ArrayList<AvaliacaoRecuperativa>();
/************************************************************************************************************/
	//Construtores
	public Turma(){}
	
	public Turma(String nome, String sala, String codigo){
		this.nome = nome;
		this.sala = sala;
		this.codigoMateria = codigo;
	}
	
	public Turma(String nome, String sala, String codigo, int numeroAvaliacoes){
		this.nome = nome;
		this.sala = sala;
		this.codigoMateria = codigo;
		this.numeroAvaliacoes = numeroAvaliacoes;
	}
	
	public Turma(String nome, String sala, String codigo, int numeroAvaliacoes, int numeroRecuperacoes){
		this.nome = nome;
		this.sala = sala;
		this.codigoMateria = codigo;
		this.numeroAvaliacoes = numeroAvaliacoes;
		this.numeroRecuperacoes = numeroRecuperacoes;
	}
	
	public Turma(String nome, String sala, String codigo, int numeroAvaliacoes, int numeroRecuperacoes, ArrayList<Aluno> alunos){
		this.nome = nome;
		this.sala = sala;
		this.codigoMateria = codigo;
		this.numeroAvaliacoes = numeroAvaliacoes;
		this.numeroRecuperacoes = numeroRecuperacoes;
		this.alunos = alunos;
	}
	
	public Turma(String nome, String sala, String codigo, int numeroAvaliacoes, int numeroRecuperacoes, ArrayList<Aluno> alunos, ArrayList<Avaliacao> avaliacoesFormativas){
		this.nome = nome;
		this.sala = sala;
		this.codigoMateria = codigo;
		this.numeroAvaliacoes = numeroAvaliacoes;
		this.numeroRecuperacoes = numeroRecuperacoes;
		this.alunos = alunos;
		this.avaliacoesFormativas = avaliacoesFormativas;
	}
	
	public Turma(String nome, String sala, String codigo, int numeroAvaliacoes, int numeroRecuperacoes, ArrayList<Aluno> alunos, ArrayList<Avaliacao> avaliacoesFormativas, ArrayList<AvaliacaoRecuperativa> avaliacoesRecuperativas){
		this.nome = nome;
		this.sala = sala;
		this.codigoMateria = codigo;
		this.numeroAvaliacoes = numeroAvaliacoes;
		this.numeroRecuperacoes = numeroRecuperacoes;
		this.alunos = alunos;
		this.avaliacoesFormativas = avaliacoesFormativas;
		this.avaliacoesRecuperativas = avaliacoesRecuperativas;
	}
/************************************************************************************************************/	
	//Métodos acessores
	public ArrayList<Avaliacao> getAvaliacoesFormativas() {
		return avaliacoesFormativas;
	}

	public void setAvaliacoesFormativas(ArrayList<Avaliacao> avaliacoesFormativas) {
		this.avaliacoesFormativas = avaliacoesFormativas;
	}

	public ArrayList<AvaliacaoRecuperativa> getAvaliacoesRecuperativas() {
		return avaliacoesRecuperativas;
	}

	public void setAvaliacoesRecuperativas(ArrayList<AvaliacaoRecuperativa> avaliacoesRecuperativas) {
		this.avaliacoesRecuperativas = avaliacoesRecuperativas;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public int getNumeroAvaliacoes() {
		return numeroAvaliacoes;
	}

	public void setNumeroAvaliacoes(int numeroAvaliacoes) {
		this.numeroAvaliacoes = numeroAvaliacoes;
	}

	public int getNumeroRecuperacoes() {
		return numeroRecuperacoes;
	}

	public void setNumeroRecuperacoes(int numeroRecuperacoes) {
		this.numeroRecuperacoes = numeroRecuperacoes;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
}
