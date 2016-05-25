package com.screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditTurma {

	JFrame turmaFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditTurma window = new EditTurma();
					window.turmaFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditTurma() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		turmaFrame = new JFrame();
		turmaFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Thiago\\Pictures\\Logo JAVA Group\\1448331815_app_type_coffee_shop_512px_GREY.png"));
		turmaFrame.setTitle("Turma - Di\u00E1rio de Bordo");
		turmaFrame.setBounds(100, 100, 810, 575);
		turmaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		turmaFrame.getContentPane().setLayout(null);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em 'Turma'");
		lblVocEstEm.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVocEstEm.setBounds(49, 31, 274, 56);
		turmaFrame.getContentPane().add(lblVocEstEm);
		
		JLabel lblOQueDeseja = new JLabel("O que deseja fazer?");
		lblOQueDeseja.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOQueDeseja.setBounds(300, 92, 190, 56);
		turmaFrame.getContentPane().add(lblOQueDeseja);
		
		JButton btnNewButton = new JButton("Adicionar Turma");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddTurma window = new AddTurma();
				window.addTurmaFrame.setVisible(true);
				turmaFrame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(147, 182, 202, 86);
		turmaFrame.getContentPane().add(btnNewButton);
		
		JButton btnAlterarTurma = new JButton("Alterar Turma");
		btnAlterarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AlteraTurma window = new AlteraTurma();
					window.alteraTurmaFrame.setVisible(true);
					turmaFrame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAlterarTurma.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAlterarTurma.setBounds(147, 315, 202, 86);
		turmaFrame.getContentPane().add(btnAlterarTurma);
		
		JButton btnConsultarTurma = new JButton("Consultar Turma");
		btnConsultarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewTurma window = new ViewTurma();
				window.consultarTurmaFrame.setVisible(true);
				turmaFrame.dispose();
			}
		});
		btnConsultarTurma.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConsultarTurma.setBounds(423, 182, 202, 86);
		turmaFrame.getContentPane().add(btnConsultarTurma);
		
		JButton btnExcluirTurma = new JButton("Excluir Turma");
		btnExcluirTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteTurma window = new DeleteTurma();
				window.deleteTurmaFrame.setVisible(true);
				turmaFrame.dispose();
			}
		});
		btnExcluirTurma.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExcluirTurma.setBounds(423, 315, 202, 86);
		turmaFrame.getContentPane().add(btnExcluirTurma);
		
		JButton btnVoltarParaPgina = new JButton("Voltar para P\u00E1gina Principal");
		btnVoltarParaPgina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home window = new Home();
				window.homeFrame.setVisible(true);
				turmaFrame.dispose();
			}
		});
		btnVoltarParaPgina.setBounds(548, 491, 202, 23);
		turmaFrame.getContentPane().add(btnVoltarParaPgina);
	}

}
