package com.thiago;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlunoTeste {

	@Test
	public void testaSetGetNome() {
		Aluno aluno = new Aluno();
		aluno.setNome("Aluno");
		assertEquals("Aluno", aluno.getNome());
	}

}
