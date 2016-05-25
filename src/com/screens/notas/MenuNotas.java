package com.screens.notas;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.screens.Home;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MenuNotas {

	public JFrame menuNotasFrame;
	protected Object addFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuNotas window = new MenuNotas();
					window.menuNotasFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuNotas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		menuNotasFrame = new JFrame();
		menuNotasFrame.setBounds(100, 100, 804, 542);
		menuNotasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuNotasFrame.getContentPane().setLayout(null);
		
		JButton button = new JButton("Voltar para menu principal");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home window = new Home();
				window.homeFrame.setVisible(true);
				menuNotasFrame.dispose();
			}
		});
		button.setBounds(535, 454, 213, 23);
		menuNotasFrame.getContentPane().add(button);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em 'Menu Notas'");
		lblVocEstEm.setBounds(73, 51, 278, 14);
		menuNotasFrame.getContentPane().add(lblVocEstEm);
		
		JLabel lblOQueVoc = new JLabel("O que voc\u00EA deseja fazer?");
		lblOQueVoc.setBounds(321, 150, 271, 14);
		menuNotasFrame.getContentPane().add(lblOQueVoc);
		
		JButton btnCadastrarNota = new JButton("Cadastrar Nota");
		btnCadastrarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddNota window = new AddNota();
				window.addFrame.setVisible(true);
				menuNotasFrame.dispose();
			}
		});
		btnCadastrarNota.setBounds(196, 245, 155, 67);
		menuNotasFrame.getContentPane().add(btnCadastrarNota);
		
		JButton btnEmitirBoletim = new JButton("Emitir Boletim");
		btnEmitirBoletim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmitirBoletim window = new EmitirBoletim();
				window.boletimFrame.setVisible(true);
				menuNotasFrame.dispose();
			}
		});
		btnEmitirBoletim.setBounds(423, 245, 155, 67);
		menuNotasFrame.getContentPane().add(btnEmitirBoletim);
	}

}
