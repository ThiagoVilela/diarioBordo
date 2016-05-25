package com.screens.notas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.thiago.Aplicacao;

public class AddNota {

	JFrame addFrame;
	private JTextField buscaField;
	private JTextField nota1Field;
	private JTextField nota2Field;
	private JTextField nota3Field;
	private JTextField nota4Field;
	private JTextField nota5Field;
	private JTextField nota6Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNota window = new AddNota();
					window.addFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddNota() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addFrame = new JFrame();
		addFrame.setBounds(100, 100, 801, 539);
		addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addFrame.getContentPane().setLayout(null);
		
		JButton btnVoltarParaO = new JButton("Voltar para o menu de notas");
		btnVoltarParaO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuNotas window = new MenuNotas();
				window.menuNotasFrame.setVisible(true);
				addFrame.dispose();
			}
		});
		btnVoltarParaO.setBounds(537, 454, 213, 23);
		addFrame.getContentPane().add(btnVoltarParaO);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em 'Adicionar Notas'");
		lblVocEstEm.setBounds(49, 35, 236, 14);
		addFrame.getContentPane().add(lblVocEstEm);
		
		JLabel buscaLabel = new JLabel("Digite a turma que deseja cadastrar as notas:");
		buscaLabel.setBounds(127, 118, 286, 14);
		addFrame.getContentPane().add(buscaLabel);
		
		buscaField = new JTextField();
		buscaField.setBounds(127, 153, 213, 20);
		addFrame.getContentPane().add(buscaField);
		buscaField.setColumns(10);
		
		JLabel erroLabel = new JLabel("Erro Label");
		erroLabel.setBounds(443, 118, 0, 14);
		addFrame.getContentPane().add(erroLabel);
		
		JLabel alunoLabel = new JLabel("Aluno Label");
		alunoLabel.setBounds(419, 156, 0, 14);
		addFrame.getContentPane().add(alunoLabel);
		
		nota1Field = new JTextField();
		nota1Field.setBounds(419, 208, 0, 20);
		addFrame.getContentPane().add(nota1Field);
		nota1Field.setColumns(10);
		
		nota2Field = new JTextField();
		nota2Field.setColumns(10);
		nota2Field.setBounds(419, 239, 0, 20);
		addFrame.getContentPane().add(nota2Field);
		
		nota3Field = new JTextField();
		nota3Field.setColumns(10);
		nota3Field.setBounds(419, 270, 0, 20);
		addFrame.getContentPane().add(nota3Field);
		
		JLabel nota1Label = new JLabel("Nota 1");
		nota1Label.setBounds(356, 211, 0, 14);
		addFrame.getContentPane().add(nota1Label);
		
		JLabel nota2Label = new JLabel("Nota 2");
		nota2Label.setBounds(356, 242, 0, 14);
		addFrame.getContentPane().add(nota2Label);
		
		JLabel nota3Label = new JLabel("Nota 3");
		nota3Label.setBounds(356, 273, 0, 14);
		addFrame.getContentPane().add(nota3Label);
		
		nota4Field = new JTextField();
		nota4Field.setBounds(419, 301, 0, 20);
		addFrame.getContentPane().add(nota4Field);
		nota4Field.setColumns(10);
		
		nota5Field = new JTextField();
		nota5Field.setColumns(10);
		nota5Field.setBounds(419, 332, 0, 20);
		addFrame.getContentPane().add(nota5Field);
		
		nota6Field = new JTextField();
		nota6Field.setColumns(10);
		nota6Field.setBounds(419, 363, 0, 20);
		addFrame.getContentPane().add(nota6Field);
		
		JLabel nota4Label = new JLabel("Nota 4");
		nota4Label.setBounds(356, 304, 0, 14);
		addFrame.getContentPane().add(nota4Label);
		
		JLabel nota5Label = new JLabel("Nota 5");
		nota5Label.setBounds(356, 335, 0, 14);
		addFrame.getContentPane().add(nota5Label);
		
		JLabel nota6Label = new JLabel("Nota 6");
		nota6Label.setBounds(356, 366, 0, 14);
		addFrame.getContentPane().add(nota6Label);
		
		JLabel lblSucessoLabel = new JLabel("Sucesso Label");
		lblSucessoLabel.setBounds(127, 304, 0, 14);
		addFrame.getContentPane().add(lblSucessoLabel);
		
		JButton btnPrximoAluno = new JButton("Pr\u00F3ximo aluno");
		btnPrximoAluno.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MenuNotas window = new MenuNotas();
				window.menuNotasFrame.setVisible(true);
				addFrame.dispose();
			}
		});
		btnPrximoAluno.setBounds(127, 382, 0, 23);
		addFrame.getContentPane().add(btnPrximoAluno);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < Aplicacao.bd.getTurmas().size(); i++) {
					if (buscaField.getText().equals(Aplicacao.bd.getTurmas().get(i).getNome())) {
						erroLabel.setText("Turma: " + Aplicacao.bd.getTurmas().get(i).getNome());
						erroLabel.setBounds(443, 118, 250, 14);
						
						if(Aplicacao.bd.getTurmas().get(i).getAlunos().size() > 0){
							switch(Aplicacao.bd.getTurmas().get(i).getAvaliacoesFormativas().size()){
							
								case 1: //Aplicacao.bd.getTurmas().get(i).getAlunos().get(0).getAvaliacoesFormativas().get(0).setNota(Integer.parseInt(nota1Field.getText()));
										lblSucessoLabel.setBounds(127, 304, 200, 14);
										lblSucessoLabel.setText("Nota cadastrada com sucesso");
										btnPrximoAluno.setBounds(127, 382, 150, 23);
										return;
										
								case 2: Aplicacao.bd.getTurmas().get(i).getAlunos().get(0).getAvaliacoesFormativas().get(0).setNota(Integer.parseInt(nota1Field.getText()));
										Aplicacao.bd.getTurmas().get(i).getAlunos().get(0).getAvaliacoesFormativas().get(1).setNota(Integer.parseInt(nota2Field.getText()));
										lblSucessoLabel.setBounds(127, 304, 200, 14);
										lblSucessoLabel.setText("Nota cadastrada com sucesso");
										btnPrximoAluno.setBounds(127, 382, 150, 23);
										return;
								
								case 3: Aplicacao.bd.getTurmas().get(i).getAlunos().get(0).getAvaliacoesFormativas().get(0).setNota(Integer.parseInt(nota1Field.getText()));
										Aplicacao.bd.getTurmas().get(i).getAlunos().get(0).getAvaliacoesFormativas().get(1).setNota(Integer.parseInt(nota2Field.getText()));
										Aplicacao.bd.getTurmas().get(i).getAlunos().get(0).getAvaliacoesFormativas().get(2).setNota(Integer.parseInt(nota3Field.getText()));
										lblSucessoLabel.setBounds(127, 304, 200, 14);
										lblSucessoLabel.setText("Nota cadastrada com sucesso");
										btnPrximoAluno.setBounds(127, 382, 150, 23);
										return;
										
								case 4: Aplicacao.bd.getTurmas().get(i).getAlunos().get(0).getAvaliacoesFormativas().get(0).setNota(Integer.parseInt(nota1Field.getText()));
										Aplicacao.bd.getTurmas().get(i).getAlunos().get(0).getAvaliacoesFormativas().get(1).setNota(Integer.parseInt(nota2Field.getText()));
										Aplicacao.bd.getTurmas().get(i).getAlunos().get(0).getAvaliacoesFormativas().get(2).setNota(Integer.parseInt(nota3Field.getText()));
										Aplicacao.bd.getTurmas().get(i).getAlunos().get(0).getAvaliacoesFormativas().get(3).setNota(Integer.parseInt(nota4Field.getText()));
										lblSucessoLabel.setBounds(127, 304, 200, 14);
										lblSucessoLabel.setText("Nota cadastrada com sucesso");
										btnPrximoAluno.setBounds(127, 382, 150, 23);
										return;
							
							}
						}
				
					}
				}
			}
		});
		btnConfirmar.setBounds(573, 207, 0, 23);
		addFrame.getContentPane().add(btnConfirmar);
		
		JButton buscaButton = new JButton("Buscar");
		buscaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buscaField.getText().equals("")) {
					erroLabel.setText("Preencha o campo de busca");
					erroLabel.setBounds(443, 118, 250, 14);
					return;
				}
				
				for (int i = 0; i < Aplicacao.bd.getTurmas().size(); i++) {
					if (buscaField.getText().equals(Aplicacao.bd.getTurmas().get(i).getNome())) {
						erroLabel.setText("Turma: " + Aplicacao.bd.getTurmas().get(i).getNome());
						erroLabel.setBounds(443, 118, 250, 14);
						
						if(Aplicacao.bd.getTurmas().get(i).getAlunos().size() > 0){
							switch(Aplicacao.bd.getTurmas().get(i).getAvaliacoesFormativas().size()){
							
								case 1: nota1Field.setBounds(419, 208, 89, 20);
										nota1Label.setText(Aplicacao.bd.getTurmas().get(i).getAvaliacoesFormativas().get(0).getNome());
										nota1Label.setBounds(356, 211, 50, 14); 
										
										btnConfirmar.setBounds(573, 207, 100, 23);
										return;
										
								case 2: nota1Field.setBounds(419, 208, 89, 20);
										nota1Label.setText(Aplicacao.bd.getTurmas().get(i).getAvaliacoesFormativas().get(0).getNome());
										nota1Label.setBounds(356, 211, 50, 14);
										
										nota2Field.setBounds(419, 239, 89, 20);
										nota2Label.setText(Aplicacao.bd.getTurmas().get(i).getAvaliacoesFormativas().get(1).getNome());
										nota2Label.setBounds(356, 242, 50, 14); 
										
										btnConfirmar.setBounds(573, 207, 100, 23);
										return;
								
								case 3: nota1Field.setBounds(419, 208, 89, 20);
										nota1Label.setText(Aplicacao.bd.getTurmas().get(i).getAvaliacoesFormativas().get(0).getNome());
										nota1Label.setBounds(356, 211, 50, 14);
										
										nota2Field.setBounds(419, 239, 89, 20);
										nota2Label.setText(Aplicacao.bd.getTurmas().get(i).getAvaliacoesFormativas().get(1).getNome());
										nota2Label.setBounds(356, 242, 50, 14); 
										
										nota3Field.setBounds(419, 270, 89, 20);
										nota3Label.setText(Aplicacao.bd.getTurmas().get(i).getAvaliacoesFormativas().get(2).getNome());
										nota3Label.setBounds(356, 273, 50, 14);
										btnConfirmar.setBounds(573, 207, 100, 23);
										return;
										
								case 4: nota1Field.setBounds(419, 208, 89, 20);
										nota1Label.setText(Aplicacao.bd.getTurmas().get(i).getAvaliacoesFormativas().get(0).getNome());
										nota1Label.setBounds(356, 211, 50, 14);
										
										nota2Field.setBounds(419, 239, 89, 20);
										nota2Label.setText(Aplicacao.bd.getTurmas().get(i).getAvaliacoesFormativas().get(1).getNome());
										nota2Label.setBounds(356, 242, 50, 14); 
										
										nota3Field.setBounds(419, 270, 89, 20);
										nota3Label.setText(Aplicacao.bd.getTurmas().get(i).getAvaliacoesFormativas().get(2).getNome());
										nota3Label.setBounds(356, 273, 50, 14);
										
										nota4Field.setBounds(419, 301, 89, 20);
										nota4Label.setText(Aplicacao.bd.getTurmas().get(i).getAvaliacoesFormativas().get(2).getNome());
										nota4Label.setBounds(356, 304, 50, 14);
										btnConfirmar.setBounds(573, 207, 100, 23);
										return;
								
								default: 	nota1Field.setBounds(419, 208, 0, 20);
											nota2Field.setBounds(419, 239, 0, 20);
											nota3Field.setBounds(419, 270, 0, 20);
											nota1Label.setBounds(356, 211, 0, 14);
											nota2Label.setBounds(356, 242, 0, 14);
											nota3Label.setBounds(356, 273, 0, 14);
											nota4Field.setBounds(419, 301, 0, 20);
											nota5Field.setBounds(419, 332, 0, 20);
											nota6Field.setBounds(419, 363, 0, 20);
											nota4Label.setBounds(356, 304, 0, 14);
											nota5Label.setBounds(356, 335, 0, 14);
											nota6Label.setBounds(356, 366, 0, 14);
											btnConfirmar.setBounds(573, 207, 0, 23);
											
											nota1Label.setText("Não existem avaliações cadastradas.");
											nota1Label.setBounds(356, 211, 250, 14);
											return;
								}
							}else{
								nota1Field.setBounds(419, 208, 0, 20);
								nota2Field.setBounds(419, 239, 0, 20);
								nota3Field.setBounds(419, 270, 0, 20);
								nota1Label.setBounds(356, 211, 0, 14);
								nota2Label.setBounds(356, 242, 0, 14);
								nota3Label.setBounds(356, 273, 0, 14);
								nota4Field.setBounds(419, 301, 0, 20);
								nota5Field.setBounds(419, 332, 0, 20);
								nota6Field.setBounds(419, 363, 0, 20);
								nota4Label.setBounds(356, 304, 0, 14);
								nota5Label.setBounds(356, 335, 0, 14);
								nota6Label.setBounds(356, 366, 0, 14);
								btnConfirmar.setBounds(573, 207, 0, 23);
								
								nota1Label.setText("Não existem Alunos nessa turma.");
								nota1Label.setBounds(356, 211, 250, 14);
								
								return;
							}
					}
				}
				
				erroLabel.setText("Turma não encontrada");
				erroLabel.setBounds(443, 118, 250, 14);
				JLabel alunoLabel = new JLabel("Aluno Label");
				alunoLabel.setBounds(419, 156, 0, 14);
				addFrame.getContentPane().add(alunoLabel);
				

				nota1Field.setBounds(419, 208, 0, 20);
				nota2Field.setBounds(419, 239, 0, 20);
				nota3Field.setBounds(419, 270, 0, 20);
				nota1Label.setBounds(356, 211, 0, 14);
				nota2Label.setBounds(356, 242, 0, 14);
				nota3Label.setBounds(356, 273, 0, 14);
				nota4Field.setBounds(419, 301, 0, 20);
				nota5Field.setBounds(419, 332, 0, 20);
				nota6Field.setBounds(419, 363, 0, 20);
				nota4Label.setBounds(356, 304, 0, 14);
				nota5Label.setBounds(356, 335, 0, 14);
				nota6Label.setBounds(356, 366, 0, 14);
				btnConfirmar.setBounds(573, 207, 0, 23);

				return;
				
			}
		});
		buscaButton.setBounds(127, 207, 89, 23);
		addFrame.getContentPane().add(buscaButton);
		
	}
}
