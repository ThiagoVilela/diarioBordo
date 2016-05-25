package com.thiago;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;

public class AvaliacaoRecuperativa extends Avaliacao implements MedidaExcepcional{
/************************************************************************************************************/
	//ATRIBUTOS
	private boolean substituiSemestre;
	
	//AVALIACAO QUE AFETA
	private ArrayList<Avaliacao> avaliacaoSubstitui = new ArrayList<Avaliacao>();
	
	//ALUNOS A QUEM AFETA
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
/************************************************************************************************************/
	//CONSTRUTORES
	public AvaliacaoRecuperativa(){}
	
	public AvaliacaoRecuperativa(String nome, String tipo, double peso, double media, Date data){
		super(nome,tipo,peso,media,data);
		
		if (peso == 100) {
			this.substituiSemestre = true;
		} else{
			this.substituiSemestre = false;
		}
	}
	
	public AvaliacaoRecuperativa(String nome, String tipo, double peso, double media, Date data, ArrayList<Aluno> alunos){
		super(nome, tipo, peso, media, data);
		this.alunos = alunos;
	}
	
/************************************************************************************************************/
	@Override
	public void gerarRelatorioExcepcional(){
		try{
			FileWriter leitor = new FileWriter("SUB-relatorioExcepcional.txt",true);
			BufferedWriter buffer = new BufferedWriter(leitor);
			
			buffer.write(this.toString());
			buffer.newLine();
			
			buffer.flush();
			buffer.close();
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
/************************************************************************************************************/
	//METODOS ACESSORES
	public boolean isSubstituiSemestre() {
		return substituiSemestre;
	}
	
	public void setSubstituiSemestre(boolean substituiSemestre) {
		this.substituiSemestre = substituiSemestre;
	}
	
	public ArrayList<Avaliacao> getAvaliacaoSubstitui() {
		return avaliacaoSubstitui;
	}
	
	public void setAvaliacaoSubstitui(ArrayList<Avaliacao> avaliacaoSubstitui) {
		this.avaliacaoSubstitui = avaliacaoSubstitui;
	}
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}
