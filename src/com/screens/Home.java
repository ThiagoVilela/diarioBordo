package com.screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.screens.aluno.MenuAluno;
import com.screens.avaliacao.MenuAvaliacao;
import com.screens.notas.MenuNotas;
import com.screens.outros.MenuOutros;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home {

	public JFrame homeFrame;
	protected Object frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.homeFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		homeFrame = new JFrame();
		homeFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Thiago\\Pictures\\Logo JAVA Group\\1448331815_app_type_coffee_shop_512px_GREY.png"));
		homeFrame.setFont(new Font("Constantia", Font.PLAIN, 12));
		homeFrame.setTitle("Bem vindo - Di\u00E1rio de Bordo");
		homeFrame.setBounds(100, 100, 802, 573);
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeFrame.getContentPane().setLayout(null);
		
		JLabel lblBemVindoAo = new JLabel("Bem vindo ao Di\u00E1rio de Bordo");
		lblBemVindoAo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblBemVindoAo.setIcon(null);
		lblBemVindoAo.setBounds(135, 77, 567, 136);
		homeFrame.getContentPane().add(lblBemVindoAo);
		
		JLabel lblEscolhaSuaOpo = new JLabel("O que voc\u00EA deseja fazer?");
		lblEscolhaSuaOpo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEscolhaSuaOpo.setBounds(263, 190, 272, 47);
		homeFrame.getContentPane().add(lblEscolhaSuaOpo);
		
		JButton turmaButton = new JButton("Turma");
		turmaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditTurma window = new EditTurma();
				window.turmaFrame.setVisible(true);
				homeFrame.dispose();
			}
		});
		turmaButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		turmaButton.setBounds(155, 306, 133, 66);
		homeFrame.getContentPane().add(turmaButton);
		
		JButton botaoAluno = new JButton("Aluno");
		botaoAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuAluno window = new MenuAluno();
				window.menuAlunoFrame.setVisible(true);
				homeFrame.dispose();
			}
		});
		botaoAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoAluno.setBounds(473, 306, 133, 66);
		homeFrame.getContentPane().add(botaoAluno);
		
		JButton avaliacoesBotao = new JButton("Avalia\u00E7\u00F5es");
		avaliacoesBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuAvaliacao window = new MenuAvaliacao();
				window.menuAvaliacaoFrame.setVisible(true);
				homeFrame.dispose();
			}
		});
		avaliacoesBotao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		avaliacoesBotao.setBounds(155, 410, 133, 66);
		homeFrame.getContentPane().add(avaliacoesBotao);
		
		JButton btnNotas = new JButton("Notas");
		btnNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuNotas window = new MenuNotas();
				window.menuNotasFrame.setVisible(true);
				homeFrame.dispose();
			}
		});
		btnNotas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNotas.setBounds(313, 357, 133, 66);
		homeFrame.getContentPane().add(btnNotas);
		
		JButton btnOutros = new JButton("Outros");
		btnOutros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuOutros window = new MenuOutros();
				window.menuFrame.setVisible(true);
				homeFrame.dispose();
			}
		});
		btnOutros.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnOutros.setBounds(473, 410, 133, 66);
		homeFrame.getContentPane().add(btnOutros);
	}
}
