package com.screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.thiago.Aplicacao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteTurma {

	JFrame deleteTurmaFrame;
	private JTextField buscaField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteTurma window = new DeleteTurma();
					window.deleteTurmaFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeleteTurma() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		deleteTurmaFrame = new JFrame();
		deleteTurmaFrame.setTitle("Deletar Turma - Di\u00E1rio de Bordo");
		deleteTurmaFrame.setBounds(100, 100, 800, 526);
		deleteTurmaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		deleteTurmaFrame.getContentPane().setLayout(null);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em: Deletar Turma");
		lblVocEstEm.setBounds(68, 70, 210, 23);
		deleteTurmaFrame.getContentPane().add(lblVocEstEm);
		
		JLabel label = new JLabel("Digite o nome da turma:");
		label.setBounds(118, 144, 148, 14);
		deleteTurmaFrame.getContentPane().add(label);
		
		buscaField = new JTextField();
		buscaField.setColumns(10);
		buscaField.setBounds(118, 169, 183, 20);
		deleteTurmaFrame.getContentPane().add(buscaField);
		
		JButton button_1 = new JButton("Voltar para menu de Turmas");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditTurma window = new EditTurma();
				window.turmaFrame.setVisible(true);
				deleteTurmaFrame.dispose();
			}
		});
		button_1.setBounds(537, 437, 210, 23);
		deleteTurmaFrame.getContentPane().add(button_1);
		
		JLabel label1 = new JLabel("");
		label1.setBounds(460, 144, 137, 14);
		deleteTurmaFrame.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("");
		label2.setBounds(375, 191, 332, 160);
		deleteTurmaFrame.getContentPane().add(label2);
		
		JButton deleteButton = new JButton("Deletar");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < Aplicacao.bd.getTurmas().size(); i++) {
					if (Aplicacao.bd.getTurmas().get(i).getNome().equals(buscaField.getText())) {
						Aplicacao.bd.getTurmas().remove(Aplicacao.bd.getTurmas().get(i));
						label1.setBounds(460, 144, 180, 14);
						label1.setText("Turma deletada com sucesso");
						label2.setText("");
						deleteButton.setBounds(375, 362, 0, 23);
						return;
					}
				}
				
				label1.setText("Erro ao encontrar a turma, repita a busca.");
				label2.setText("");
				deleteButton.setBounds(375, 362, 0, 23);
				buscaField.setText("");
			}
		});
		deleteButton.setBounds(375, 362, 0, 23);
		deleteTurmaFrame.getContentPane().add(deleteButton);
		
		JButton buscarButton = new JButton("Buscar");
		buscarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < Aplicacao.bd.getTurmas().size(); i++) {
					if (Aplicacao.bd.getTurmas().get(i).getNome().equals(buscaField.getText())) {
						label1.setText("Turma encontrada");
						label2.setText(Aplicacao.bd.getTurmas().get(i).toString());
						deleteButton.setBounds(375, 362, 85, 23);
						return;
					}
				}
				
				label1.setText("Turma não encontrada");
				label2.setText("");
				deleteButton.setBounds(375, 362, 0, 23);
				return;
			}
		});
		buscarButton.setBounds(118, 265, 89, 23);
		deleteTurmaFrame.getContentPane().add(buscarButton);
		
	}
}
