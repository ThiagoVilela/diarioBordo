package com.thiago;

import java.util.ArrayList;

public class NecessidadesEspeciais extends Aluno{
/************************************************************************************************************/
	//ATRIBUTOS
	private String acompanhante;
	private String observacoes;
/************************************************************************************************************/
	//CONSTRUTORES
	public NecessidadesEspeciais(){}
	
	public NecessidadesEspeciais(String nome, double matricula, Turma turma, String acompanhante){
		super(nome, matricula, turma);
		this.acompanhante = acompanhante;
	}
	
	public NecessidadesEspeciais(String nome, double matricula, Turma turma, String acompanhante, String observacoes) {
		super(nome, matricula, turma);
		this.acompanhante = acompanhante;
		this.observacoes = observacoes;
	}
	
	public NecessidadesEspeciais(String nome, double matricula, Turma turma, ArrayList<Avaliacao> avaliacoesFormativas, String acompanhante, String observacoes){
		super(nome, matricula, turma, avaliacoesFormativas);
		this.acompanhante = acompanhante;
		this.observacoes = observacoes;
	}
	
	public NecessidadesEspeciais(String nome, double matricula, Turma turma, ArrayList<Avaliacao> avaliacoesFormativas, ArrayList<Avaliacao> avaliacoesRecuperativas, String acompanhante, String observacoes){
		super(nome, matricula, turma, avaliacoesFormativas, avaliacoesRecuperativas);
		this.acompanhante = acompanhante;
		this.observacoes = observacoes;
	}
/************************************************************************************************************/
	public String getAcompanhante() {
		return acompanhante;
	}
	public void setAcompanhante(String acompanhante) {
		this.acompanhante = acompanhante;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
}
