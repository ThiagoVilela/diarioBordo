package com.screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.thiago.Aplicacao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlteraTurma {

	JFrame alteraTurmaFrame;
	private JTextField buscaField;
	private JTextField nomeField;
	private JTextField salaField;
	private JTextField materiaField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlteraTurma window = new AlteraTurma();
					window.alteraTurmaFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AlteraTurma() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		alteraTurmaFrame = new JFrame();
		alteraTurmaFrame.setTitle("Alterar Turma - Di\u00E1rio de Bordo");
		alteraTurmaFrame.setBounds(100, 100, 801, 526);
		alteraTurmaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alteraTurmaFrame.getContentPane().setLayout(null);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em: Alterar Turma");
		lblVocEstEm.setBounds(64, 54, 210, 23);
		alteraTurmaFrame.getContentPane().add(lblVocEstEm);
		
		buscaField = new JTextField();
		buscaField.setColumns(10);
		buscaField.setBounds(114, 153, 183, 20);
		alteraTurmaFrame.getContentPane().add(buscaField);
		
		JLabel label1 = new JLabel("Digite o nome da turma:");
		label1.setBounds(114, 128, 148, 14);
		alteraTurmaFrame.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("Teste");
		label2.setBounds(416, 79, 0, 14);
		alteraTurmaFrame.getContentPane().add(label2);
		
		nomeField = new JTextField();
		nomeField.setBounds(416, 153, 0, 20);
		alteraTurmaFrame.getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setBounds(416, 133, 0, 14);
		alteraTurmaFrame.getContentPane().add(nomeLabel);
		
		salaField = new JTextField();
		salaField.setBounds(416, 216, 0, 20);
		alteraTurmaFrame.getContentPane().add(salaField);
		salaField.setColumns(10);
		
		JLabel salaLabel = new JLabel("Sala");
		salaLabel.setBounds(416, 199, 0, 14);
		alteraTurmaFrame.getContentPane().add(salaLabel);
		
		materiaField = new JTextField();
		materiaField.setBounds(416, 280, 0, 20);
		alteraTurmaFrame.getContentPane().add(materiaField);
		materiaField.setColumns(10);
		
		JLabel materiaLabel = new JLabel("Mat\u00E9ria");
		materiaLabel.setBounds(416, 262, 0, 14);
		alteraTurmaFrame.getContentPane().add(materiaLabel);
		
		JButton alterarButton = new JButton("Alterar");
		alterarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome, sala, materia;
				for (int i = 0; i < Aplicacao.bd.getTurmas().size(); i++) {
					if (Aplicacao.bd.getTurmas().get(i).getNome().equals(buscaField.getText())) {
						
						nomeLabel.setBounds(416, 133, 0, 14);
						nomeField.setBounds(416, 153, 0, 20);
						//nomeField.setText(Aplicacao.bd.getTurmas().get(i).getNome());
						nome = nomeField.getText();
						
						salaLabel.setBounds(416, 199, 0, 14);
						salaField.setBounds(416, 216, 0, 20);
						//salaField.setText(Aplicacao.bd.getTurmas().get(i).getSala());
						sala = salaField.getText();
						
						materiaLabel.setBounds(416, 262, 0, 14);
						materiaField.setBounds(416, 280, 0, 20);
						//materiaField.setText(Aplicacao.bd.getTurmas().get(i).getCodigoMateria());
						materia = materiaField.getText();
						
						alterarButton.setBounds(416, 337, 0, 23);
						
						Aplicacao.bd.getTurmas().get(i).setNome(nome);
						Aplicacao.bd.getTurmas().get(i).setSala(sala);
						Aplicacao.bd.getTurmas().get(i).setCodigoMateria(materia);
						
						label2.setText("Turma alterada com sucesso.");
						label2.setBounds(416, 79, 180, 14);
						return;
					}
				}
				
				label2.setText("Erro ao encontrar a turma");
				label2.setBounds(416, 79, 120, 14);
			}
		});
		alterarButton.setBounds(416, 337, 0, 23);
		alteraTurmaFrame.getContentPane().add(alterarButton);
		
		JButton voltarButton = new JButton("Voltar para menu de Turmas");
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EditTurma window = new EditTurma();
					window.turmaFrame.setVisible(true);
					alteraTurmaFrame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		voltarButton.setBounds(523, 431, 210, 23);
		alteraTurmaFrame.getContentPane().add(voltarButton);
		
		JButton buscaButton = new JButton("Buscar");
		buscaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				for (int i = 0; i < Aplicacao.bd.getTurmas().size(); i++) {
					if (Aplicacao.bd.getTurmas().get(i).getNome().equals(buscaField.getText())) {
						
						label2.setText("Turma encontrada.");
						label2.setBounds(416, 79, 150, 14);
						
						nomeLabel.setBounds(416, 133, 50, 14);
						nomeField.setBounds(416, 153, 120, 20);
						nomeField.setText(Aplicacao.bd.getTurmas().get(i).getNome());
						
						salaLabel.setBounds(416, 199, 50, 14);
						salaField.setBounds(416, 216, 120, 20);
						salaField.setText(Aplicacao.bd.getTurmas().get(i).getSala());
						
						materiaLabel.setBounds(416, 262, 50, 14);
						materiaField.setBounds(416, 280, 120, 20);
						materiaField.setText(Aplicacao.bd.getTurmas().get(i).getCodigoMateria());
						
						alterarButton.setBounds(416, 337, 80, 23);
						return;
					}
				
				}
				
				label2.setText("Turma não encontrada.");
				label2.setBounds(416, 79, 150, 14);
				
				nomeLabel.setBounds(416, 133, 0, 14);
				nomeField.setBounds(416, 153, 0, 20);
				
				salaLabel.setBounds(416, 199, 0, 14);
				salaField.setBounds(416, 216, 0, 20);
				
				materiaLabel.setBounds(416, 262, 0, 14);
				materiaField.setBounds(416, 216, 0, 20);
				
				alterarButton.setBounds(416, 337, 0, 23);
			}
		});
		buscaButton.setBounds(114, 227, 89, 23);
		alteraTurmaFrame.getContentPane().add(buscaButton);
		
		
	}

}
