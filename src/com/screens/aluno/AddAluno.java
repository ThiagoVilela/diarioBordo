package com.screens.aluno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import com.thiago.Aluno;
import com.thiago.Aplicacao;
import com.thiago.Turma;

public class AddAluno {

	JFrame addAlunoFrame;
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
					AddAluno window = new AddAluno();
					window.addAlunoFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addAlunoFrame = new JFrame();
		addAlunoFrame.setBounds(100, 100, 802, 517);
		addAlunoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addAlunoFrame.getContentPane().setLayout(null);
		
		JButton btnVoltarParaMenu = new JButton("Voltar para menu Aluno");
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAluno window = new MenuAluno();
				window.menuAlunoFrame.setVisible(true);
				addAlunoFrame.dispose();
			}
		});
		btnVoltarParaMenu.setBounds(566, 423, 167, 23);
		addAlunoFrame.getContentPane().add(btnVoltarParaMenu);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em 'Adicionar Aluno'");
		lblVocEstEm.setBounds(52, 38, 208, 14);
		addAlunoFrame.getContentPane().add(lblVocEstEm);
		
		JLabel lblPreenchaOsCampos = new JLabel("Preencha os campos abaixo com os dados indicados:");
		lblPreenchaOsCampos.setBounds(101, 95, 338, 14);
		addAlunoFrame.getContentPane().add(lblPreenchaOsCampos);
		
		nomeField = new JTextField();
		nomeField.setBounds(101, 174, 242, 20);
		addAlunoFrame.getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setBounds(103, 149, 46, 14);
		addAlunoFrame.getContentPane().add(nomeLabel);
		
		matriculaField = new JTextField();
		matriculaField.setBounds(101, 249, 242, 20);
		addAlunoFrame.getContentPane().add(matriculaField);
		matriculaField.setColumns(10);
		
		JLabel matriculaLabel = new JLabel("Matr\u00EDcula");
		matriculaLabel.setBounds(101, 224, 79, 14);
		addAlunoFrame.getContentPane().add(matriculaLabel);
		
		turmaField = new JTextField();
		turmaField.setBounds(101, 323, 242, 20);
		addAlunoFrame.getContentPane().add(turmaField);
		turmaField.setColumns(10);
		
		JLabel turmaLabel = new JLabel("Nome da Turma");
		turmaLabel.setBounds(101, 298, 100, 14);
		addAlunoFrame.getContentPane().add(turmaLabel);
		
		JLabel erroTurmaLabel = new JLabel("Erro Turma");
		erroTurmaLabel.setBounds(353, 326, 0, 14);
		addAlunoFrame.getContentPane().add(erroTurmaLabel);
		
		JLabel erroMatriculaLabel = new JLabel("Erro Matr\u00EDcula");
		erroMatriculaLabel.setBounds(353, 252, 0, 14);
		addAlunoFrame.getContentPane().add(erroMatriculaLabel);
		
		JLabel sucessoTurmaLabel = new JLabel("Turma Adicionada com Sucesso");
		sucessoTurmaLabel.setBounds(523, 208, 0, 14);
		addAlunoFrame.getContentPane().add(sucessoTurmaLabel);
		
		JButton addBotao = new JButton("Adicionar");
		addBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome, nomeTurma;
				double matricula;
				
				if(nomeField.getText().equals("") || matriculaField.getText().equals("") || turmaField.getText().equals("")){
					sucessoTurmaLabel.setText("Preencha todos os campos.");
					sucessoTurmaLabel.setBounds(523, 208, 180, 14);
				} 
				
				else{
					sucessoTurmaLabel.setBounds(523, 208, 0, 14);
					
					nome = nomeField.getText();
					
					try{
						matricula = Double.parseDouble(matriculaField.getText());
					}catch(NumberFormatException e1){
						MessageDialog.openError(new Shell(), "Erro", "Número de matrícula inválido.");
						return;
					}
					
					nomeTurma = turmaField.getText();
					
					//Matricula
					for (int i = 0; i < Aplicacao.bd.getAlunos().size(); i++) {
						if (matricula == Aplicacao.bd.getAlunos().get(i).getMatricula()) {
							erroMatriculaLabel.setText("Matrícula já cadastrada.");
							erroMatriculaLabel.setBounds(353, 252, 150, 14);
							
							sucessoTurmaLabel.setBounds(523, 208, 0, 14);
							erroTurmaLabel.setBounds(353, 326, 0, 14);
							return;
						}
					}
					//Matricula
					//Turma
					boolean encontrou = false;
					Turma turma = new Turma();
					for (int j = 0; j < Aplicacao.bd.getTurmas().size(); j++) {
						if (nomeTurma.equals(Aplicacao.bd.getTurmas().get(j).getNome())) {
							turma = Aplicacao.bd.getTurmas().get(j);
							encontrou = true;
						}
					}
					
					if (!encontrou) {
						erroTurmaLabel.setText("Turma não encontrada.");
						erroTurmaLabel.setBounds(353, 326, 150, 14);
						
						sucessoTurmaLabel.setBounds(523, 208, 0, 14);
						erroMatriculaLabel.setBounds(353, 252, 0, 14);
						return;
					}
					//Turma
					
					Aluno aluno = new Aluno(nome, matricula, turma);
					Aplicacao.bd.getAlunos().add(aluno);
					
					for (int i = 0; i < Aplicacao.bd.getTurmas().size(); i++) {
						if (aluno.getTurma().getNome().equals(Aplicacao.bd.getTurmas().get(i).getNome())) {
							Aplicacao.bd.getTurmas().get(i).getAlunos().add(aluno);
							i = Aplicacao.bd.getTurmas().size();
						}
					}
					
					erroMatriculaLabel.setBounds(353, 252, 0, 14);
					erroTurmaLabel.setBounds(353, 326, 0, 14);
					
					sucessoTurmaLabel.setText("Aluno adicionado com sucesso.");
					sucessoTurmaLabel.setBounds(523, 208, 180, 14);
				}
				
			}
		});
		addBotao.setBounds(101, 379, 89, 23);
		addAlunoFrame.getContentPane().add(addBotao);
	}
}
