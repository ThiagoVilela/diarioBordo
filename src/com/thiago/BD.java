package com.thiago;

import java.util.ArrayList;

public class BD {
/************************************************************************************************************/
	//TURMAS CADASTRADAS NO BD
	private ArrayList<Turma> turmas = new ArrayList<Turma>();
	//AVALIACOES CADASTRADAS NO BD
	private ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
	//ALUNOS
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
/************************************************************************************************************/
	//Métodos Acessores
	public ArrayList<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(ArrayList<Turma> turmas) {
		this.turmas = turmas;
	}

	public ArrayList<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}
