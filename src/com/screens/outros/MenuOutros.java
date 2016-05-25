package com.screens.outros;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.screens.Home;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MenuOutros {

	public JFrame menuFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOutros window = new MenuOutros();
					window.menuFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuOutros() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		menuFrame = new JFrame();
		menuFrame.setBounds(100, 100, 800, 550);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.getContentPane().setLayout(null);
		
		JButton btn = new JButton("Voltar para menu principal");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home window = new Home();
				window.homeFrame.setVisible(true);
				menuFrame.dispose();
			}
		});
		btn.setBounds(538, 464, 213, 23);
		menuFrame.getContentPane().add(btn);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em 'Outros'");
		lblVocEstEm.setBounds(54, 37, 213, 14);
		menuFrame.getContentPane().add(lblVocEstEm);
		
		JLabel lblOQueDeseja = new JLabel("O que deseja fazer?");
		lblOQueDeseja.setBounds(304, 144, 230, 14);
		menuFrame.getContentPane().add(lblOQueDeseja);
		
		JButton btnAdicionarAvalaesRecuperativas = new JButton("Adicionar Avala\u00E7\u00F5es Recuperativas");
		btnAdicionarAvalaesRecuperativas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAvaliacaoRec window = new AddAvaliacaoRec();
				window.addFrame.setVisible(true);
				menuFrame.dispose();
			}
		});
		btnAdicionarAvalaesRecuperativas.setBounds(211, 211, 289, 74);
		menuFrame.getContentPane().add(btnAdicionarAvalaesRecuperativas);
		
		JButton btnGerarRelatorioExcepcional = new JButton("Gerar Relatorio Excepcional");
		btnGerarRelatorioExcepcional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio window = new Relatorio();
				window.relatorioFrame.setVisible(true);
				menuFrame.dispose();
			}
		});
		btnGerarRelatorioExcepcional.setBounds(211, 317, 289, 74);
		menuFrame.getContentPane().add(btnGerarRelatorioExcepcional);
	}

}
