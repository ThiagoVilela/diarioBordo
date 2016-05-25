package com.screens.aluno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.thiago.Aplicacao;
import com.thiago.Turma;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlteraAluno {

	JFrame alteraAlunoFrame;
	private JTextField alunoField;
	private JTextField nomeField;
	private JTextField matriculaField;
	private JTextField turmaField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlteraAluno window = new AlteraAluno();
					window.alteraAlunoFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AlteraAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		alteraAlunoFrame = new JFrame();
		alteraAlunoFrame.setBounds(100, 100, 800, 541);
		alteraAlunoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alteraAlunoFrame.getContentPane().setLayout(null);
		
		JButton button = new JButton("Voltar para menu Aluno");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAluno window = new MenuAluno();
				window.menuAlunoFrame.setVisible(true);
				alteraAlunoFrame.dispose();
			}
		});
		button.setBounds(556, 443, 167, 23);
		alteraAlunoFrame.getContentPane().add(button);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em 'Alterar Aluno'");
		lblVocEstEm.setBounds(58, 53, 193, 14);
		alteraAlunoFrame.getContentPane().add(lblVocEstEm);
		
		JLabel lblDigiteONome = new JLabel("Digite o nome do aluno:");
		lblDigiteONome.setBounds(114, 152, 155, 14);
		alteraAlunoFrame.getContentPane().add(lblDigiteONome);
		
		alunoField = new JTextField();
		alunoField.setColumns(10);
		alunoField.setBounds(114, 198, 242, 20);
		alteraAlunoFrame.getContentPane().add(alunoField);
		
		JLabel encontradoLabel = new JLabel("Aluno encontrado");
		encontradoLabel.setBounds(428, 152, 0, 14);
		alteraAlunoFrame.getContentPane().add(encontradoLabel);
		
		nomeField = new JTextField();
		nomeField.setBounds(428, 210, 0, 20);
		alteraAlunoFrame.getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setBounds(428, 185, 0, 14);
		alteraAlunoFrame.getContentPane().add(nomeLabel);
		
		matriculaField = new JTextField();
		matriculaField.setColumns(10);
		matriculaField.setBounds(428, 262, 0, 20);
		alteraAlunoFrame.getContentPane().add(matriculaField);
		
		JLabel matriculaLabel = new JLabel("Matr\u00EDcula");
		matriculaLabel.setBounds(428, 241, 0, 14);
		alteraAlunoFrame.getContentPane().add(matriculaLabel);
		
		turmaField = new JTextField();
		turmaField.setColumns(10);
		turmaField.setBounds(428, 318, 0, 20);
		alteraAlunoFrame.getContentPane().add(turmaField);
		
		JLabel turmaLabel = new JLabel("Turma");
		turmaLabel.setBounds(428, 293, 0, 14);
		alteraAlunoFrame.getContentPane().add(turmaLabel);
		
		JButton alterarBotao = new JButton("Alterar");
		alterarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				String nome, nomeTurma;
				double matricula = 0;
				int posicaoAluno = -1;
				
				for (int i = 0; i < Aplicacao.bd.getAlunos().size(); i++) {
					if (alunoField.getText().equals(Aplicacao.bd.getAlunos().get(i).getNome())) {
						posicaoAluno = i;
						i = Aplicacao.bd.getAlunos().size();
					}
				}
				
				if (nomeField.getText().equals("") || matriculaField.getText().equals("") || turmaField.equals("")) {
					encontradoLabel.setText("Preencha todos os campos");
					return;
				}
				
				else{
					nome = nomeField.getText();
					
					try{
						matricula = Double.parseDouble(matriculaField.getText());
					}catch(NumberFormatException e1){
						encontradoLabel.setText("Matrícula já existente");
					}
					
					nomeTurma = turmaField.getText();
					boolean encontrou = false;
					Turma turma = new Turma();
					for (int i = 0; i < Aplicacao.bd.getTurmas().size(); i++) {
						if (nomeTurma.equals(Aplicacao.bd.getTurmas().get(i).getNome())) {
							encontrou = true;
							turma = Aplicacao.bd.getTurmas().get(i);
						}
					}
					
					if (!encontrou) {
						encontradoLabel.setText("Turma não encontrada");
						return;
					}
					
					if (posicaoAluno > -1) {
						Aplicacao.bd.getAlunos().get(posicaoAluno).setNome(nome);
						Aplicacao.bd.getAlunos().get(posicaoAluno).setMatricula(matricula);
						Aplicacao.bd.getAlunos().get(posicaoAluno).setTurma(turma);
						
						encontradoLabel.setText("Aluno alterado com sucesso.");
						encontradoLabel.setBounds(428, 152, 180, 14);
						
						nomeLabel.setBounds(428, 185, 0, 14);
						nomeField.setBounds(428, 210, 0, 20);
						matriculaLabel.setBounds(428, 241, 0, 14);
						matriculaField.setBounds(428, 262, 0, 20);
						turmaLabel.setBounds(428, 293, 0, 14);
						turmaField.setBounds(428, 318, 0, 20);
						
						alterarBotao.setBounds(428, 362, 0, 23);
						return;
					}
					
				}
				
			}
		});
		alterarBotao.setBounds(428, 362, 0, 23);
		alteraAlunoFrame.getContentPane().add(alterarBotao);
		
		JLabel erroTurmaLabel = new JLabel("Turma n\u00E3o encontrada");
		erroTurmaLabel.setBounds(276, 321, 0, 14);
		alteraAlunoFrame.getContentPane().add(erroTurmaLabel);
		
		JLabel erroMatriculaLabel = new JLabel("Matr\u00EDcula j\u00E1 existente");
		erroMatriculaLabel.setBounds(276, 265, 0, 14);
		alteraAlunoFrame.getContentPane().add(erroMatriculaLabel);
		
		JButton buscarBotao = new JButton("Buscar");
		buscarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nomeAluno = alunoField.getText();
				
				for (int i = 0; i < Aplicacao.bd.getAlunos().size(); i++) {
					if (nomeAluno.equals(Aplicacao.bd.getAlunos().get(i).getNome())) {
						
						encontradoLabel.setText("Aluno encontrado");
						encontradoLabel.setBounds(428, 152, 150, 14);
						
						nomeLabel.setBounds(428, 185, 150, 14);
						nomeField.setText(Aplicacao.bd.getAlunos().get(i).getNome());
						nomeField.setBounds(428, 210, 240, 20);
						
						
						matriculaLabel.setBounds(428, 241, 150, 14);
						matriculaField.setText(""+Aplicacao.bd.getAlunos().get(i).getMatricula());
						matriculaField.setBounds(428, 262, 240, 20);
						
						turmaLabel.setBounds(428, 293, 150, 14);
						turmaField.setText(Aplicacao.bd.getAlunos().get(i).getTurma().getNome());
						turmaField.setBounds(428, 318, 240, 20);
						
						alterarBotao.setBounds(428, 362, 89, 23);
						return;
					}
				}
				
				encontradoLabel.setText("Aluno não encontrado");
				encontradoLabel.setBounds(428, 152, 150, 14);
				
				nomeLabel.setBounds(428, 185, 0, 14);
				nomeField.setBounds(428, 210, 0, 20);
				matriculaLabel.setBounds(428, 241, 0, 14);
				matriculaField.setBounds(428, 262, 0, 20);
				turmaLabel.setBounds(428, 293, 0, 14);
				turmaField.setBounds(428, 318, 0, 20);
				
				alterarBotao.setBounds(428, 362, 0, 23);
				
			}
		});
		buscarBotao.setBounds(114, 261, 89, 23);
		alteraAlunoFrame.getContentPane().add(buscarBotao);

	}

}
