package com.screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.thiago.Aplicacao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewTurma {

	JFrame consultarTurmaFrame;
	private JTextField buscaField;
	private JLabel lblDigiteONome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTurma window = new ViewTurma();
					window.consultarTurmaFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewTurma() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		consultarTurmaFrame = new JFrame();
		consultarTurmaFrame.setTitle("Consultar Turma - Di\u00E1rio de Bordo");
		consultarTurmaFrame.setBounds(100, 100, 800, 520);
		consultarTurmaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		consultarTurmaFrame.getContentPane().setLayout(null);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em: Consultar Turma");
		lblVocEstEm.setBounds(59, 49, 210, 23);
		consultarTurmaFrame.getContentPane().add(lblVocEstEm);
		
		buscaField = new JTextField();
		buscaField.setBounds(128, 193, 183, 20);
		consultarTurmaFrame.getContentPane().add(buscaField);
		buscaField.setColumns(10);
		
		lblDigiteONome = new JLabel("Digite o nome da turma:");
		lblDigiteONome.setBounds(128, 168, 148, 14);
		consultarTurmaFrame.getContentPane().add(lblDigiteONome);
		
		JButton btnVoltarParaMenu = new JButton("Voltar para menu de Turmas");
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditTurma window = new EditTurma();
				window.turmaFrame.setVisible(true);
				consultarTurmaFrame.dispose();
			}
		});
		btnVoltarParaMenu.setBounds(520, 426, 210, 23);
		consultarTurmaFrame.getContentPane().add(btnVoltarParaMenu);
		
		JLabel turmaEncontrada = new JLabel("");
		turmaEncontrada.setBounds(452, 168, 148, 14);
		consultarTurmaFrame.getContentPane().add(turmaEncontrada);
		
		JLabel turmaEncontrada2 = new JLabel("");
		turmaEncontrada2.setBounds(403, 224, 278, 35);
		consultarTurmaFrame.getContentPane().add(turmaEncontrada2);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < Aplicacao.bd.getTurmas().size(); i++) {
					if (Aplicacao.bd.getTurmas().get(i).getNome().equals(buscaField.getText())) {
						turmaEncontrada.setText("Turma encontrada");
						turmaEncontrada2.setText(Aplicacao.bd.getTurmas().get(i).toString());
						return;
					}
				}
				
				turmaEncontrada.setText("Turma não encontrada");
				turmaEncontrada2.setText("");
			}
		});
		btnBuscar.setBounds(128, 289, 89, 23);
		consultarTurmaFrame.getContentPane().add(btnBuscar);
		
	}
}
