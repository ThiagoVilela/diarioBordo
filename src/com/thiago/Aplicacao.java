package com.thiago;

import com.screens.Home;

public class Aplicacao {
/************************************************************************************************************/
	//ATRIBUTOS
	public static BD bd = new BD();
/************************************************************************************************************/
	//MÉTODOS ACESSORES
	public BD getBd() {
		return bd;
	}

	public void setBd(BD bd) {
		Aplicacao.bd = bd;
	}
/************************************************************************************************************/
	//MAIN
	public static void main(String[] args) {
		//Aplicacao aplicacao = new Aplicacao();
		
		Home window = new Home();
		window.homeFrame.setVisible(true);
		
		if(bd.getTurmas().size() > 0)
			System.out.println(bd.getTurmas().get(0));
	}
}
