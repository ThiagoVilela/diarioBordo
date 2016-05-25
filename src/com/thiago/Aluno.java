package com.thiago;

import java.util.ArrayList;

public class Aluno {
/************************************************************************************************************/
	//Atribtos
	private String nome;
	private double matricula;
	
	//Turma no qual o Aluno está cadastrado
	private Turma turma = new Turma();
	
	//Avaliações FORMATIVAS que o Aluno fez
	private ArrayList<Avaliacao> avaliacoesFormativas = new ArrayList<Avaliacao>();
	
	//Avaliações RECUPERATIVAS que o Aluno fez
	private ArrayList<Avaliacao> avaliacoesRecuperativas = new ArrayList<Avaliacao>();
	
	//POSSIVEIS RELATORIOS
	private ArrayList<RelatorioAcompanhamento> relatorios = new ArrayList<RelatorioAcompanhamento>();
/************************************************************************************************************/
	//Construtores
	public Aluno(){}
	
	public Aluno(String nome, double matricula){
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public Aluno(String nome, double matricula, Turma turma){
		this.nome = nome;
		this.matricula = matricula;
		this.turma = turma;
	}
	
	public Aluno(String nome, double matricula, Turma turma, ArrayList<Avaliacao> avaliacoesFormativas){
		this.nome = nome;
		this.matricula = matricula;
		this.turma = turma;
		this.avaliacoesFormativas = avaliacoesFormativas;
	}
	
	public Aluno(String nome, double matricula, Turma turma, ArrayList<Avaliacao> avaliacoesFormativas, ArrayList<Avaliacao> avaliacoesRecuperativas){
		this.nome = nome;
		this.matricula = matricula;
		this.turma = turma;
		this.avaliacoesFormativas = avaliacoesFormativas;
		this.avaliacoesRecuperativas = avaliacoesRecuperativas;
	}
	
	public Aluno(String nome, double matricula, Turma turma, ArrayList<Avaliacao> avaliacoesFormativas, ArrayList<Avaliacao> avaliacoesRecuperativas, ArrayList<RelatorioAcompanhamento> relatorios){
		this.nome = nome;
		this.matricula = matricula;
		this.turma = turma;
		this.avaliacoesFormativas = avaliacoesFormativas;
		this.avaliacoesRecuperativas = avaliacoesRecuperativas;
		this.relatorios = relatorios;
	}
/************************************************************************************************************/
	//Métodos acessores
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getMatricula() {
		return matricula;
	}
	public void setMatricula(double matricula) {
		this.matricula = matricula;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public ArrayList<Avaliacao> getAvaliacoesSomativas() {
		return avaliacoesFormativas;
	}
	public void setAvaliacoesSomativas(ArrayList<Avaliacao> avaliacoesSomativas) {
		this.avaliacoesFormativas = avaliacoesSomativas;
	}
	public ArrayList<Avaliacao> getAvaliacoesRecuperativas() {
		return avaliacoesRecuperativas;
	}
	public void setAvaliacoesRecuperativas(ArrayList<Avaliacao> avaliacoesRecuperativas) {
		this.avaliacoesRecuperativas = avaliacoesRecuperativas;
	}

	public ArrayList<Avaliacao> getAvaliacoesFormativas() {
		return avaliacoesFormativas;
	}

	public void setAvaliacoesFormativas(ArrayList<Avaliacao> avaliacoesFormativas) {
		this.avaliacoesFormativas = avaliacoesFormativas;
	}

	public ArrayList<RelatorioAcompanhamento> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(ArrayList<RelatorioAcompanhamento> relatorios) {
		this.relatorios = relatorios;
	}
	
}
