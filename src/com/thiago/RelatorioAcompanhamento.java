package com.thiago;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;

public class RelatorioAcompanhamento implements MedidaExcepcional{
/************************************************************************************************************/	 
	//ATRIBUTOS
	private Date data;
	private String acontecimento;
	//ALUNO(S) REFERENCIADO(S)
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
/************************************************************************************************************/	 
	//CONSTRUTORES
	public RelatorioAcompanhamento(){}
	
	public RelatorioAcompanhamento(Date data, String acontecimento, Aluno aluno){
		this.data = data;
		this.acontecimento = acontecimento;
		this.alunos.add(aluno);
	}
	
	public RelatorioAcompanhamento(Date data, String acontecimento, ArrayList<Aluno> alunos){
		this.data = data;
		this.acontecimento = acontecimento;
		this.alunos = alunos;
	}
/************************************************************************************************************/
	@Override
	public void gerarRelatorioExcepcional(){
		try{
			FileWriter leitor = new FileWriter("ACOMPANHAMENTO-relatorioExcepcional.txt",true);
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
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getAcontecimento() {
		return acontecimento;
	}

	public void setAcontecimento(String acontecimento) {
		this.acontecimento = acontecimento;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}
