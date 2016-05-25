package com.screens.aluno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.screens.Home;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuAluno {

	public JFrame menuAlunoFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAluno window = new MenuAluno();
					window.menuAlunoFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		menuAlunoFrame = new JFrame();
		menuAlunoFrame.setBounds(100, 100, 799, 541);
		menuAlunoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuAlunoFrame.getContentPane().setLayout(null);
		
		JLabel voceEstaLabel = new JLabel("Voc\u00EA est\u00E1 em 'Menu Aluno'");
		voceEstaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		voceEstaLabel.setBounds(55, 54, 220, 14);
		menuAlunoFrame.getContentPane().add(voceEstaLabel);
		
		JLabel lblOQueDeseja = new JLabel("O que deseja fazer?");
		lblOQueDeseja.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOQueDeseja.setBounds(270, 85, 260, 35);
		menuAlunoFrame.getContentPane().add(lblOQueDeseja);
		
		JButton addAluno = new JButton("Adicionar Aluno");
		addAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAluno window = new AddAluno();
				window.addAlunoFrame.setVisible(true);
				menuAlunoFrame.dispose();
			}
		});
		addAluno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addAluno.setBounds(136, 167, 202, 86);
		menuAlunoFrame.getContentPane().add(addAluno);
		
		JButton consultaAluno = new JButton("Consultar Aluno");
		consultaAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaAluno window = new ConsultaAluno();
				window.consultaAlunoFrame.setVisible(true);
				menuAlunoFrame.dispose();
			}
		});
		consultaAluno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		consultaAluno.setBounds(417, 167, 202, 86);
		menuAlunoFrame.getContentPane().add(consultaAluno);
		
		JButton alteraAluno = new JButton("Alterar Aluno");
		alteraAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlteraAluno window = new AlteraAluno();
				window.alteraAlunoFrame.setVisible(true);
				menuAlunoFrame.dispose();
			}
		});
		alteraAluno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		alteraAluno.setBounds(136, 301, 202, 86);
		menuAlunoFrame.getContentPane().add(alteraAluno);
		
		JButton excluiAluno = new JButton("Excluir Aluno");
		excluiAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirAluno window = new ExcluirAluno();
				window.excluirAlunoFrame.setVisible(true);
				menuAlunoFrame.dispose();
			}
		});
		excluiAluno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		excluiAluno.setBounds(417, 301, 202, 86);
		menuAlunoFrame.getContentPane().add(excluiAluno);
		
		JButton btnVoltarParaPgin = new JButton("Voltar para p\u00E1gina principal");
		btnVoltarParaPgin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home window = new Home();
				window.homeFrame.setVisible(true);
				menuAlunoFrame.dispose();
			}
		});
		btnVoltarParaPgin.setBounds(514, 451, 212, 23);
		menuAlunoFrame.getContentPane().add(btnVoltarParaPgin);
	}

}
