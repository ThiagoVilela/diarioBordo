package com.screens.avaliacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.screens.Home;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuAvaliacao {

	public JFrame menuAvaliacaoFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAvaliacao window = new MenuAvaliacao();
					window.menuAvaliacaoFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuAvaliacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		menuAvaliacaoFrame = new JFrame();
		menuAvaliacaoFrame.setBounds(100, 100, 804, 544);
		menuAvaliacaoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuAvaliacaoFrame.getContentPane().setLayout(null);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em 'Menu Avaliacao'");
		lblVocEstEm.setBounds(52, 64, 225, 14);
		menuAvaliacaoFrame.getContentPane().add(lblVocEstEm);
		
		JLabel lblOQueDeseja = new JLabel("O que deseja fazer?");
		lblOQueDeseja.setBounds(346, 141, 263, 14);
		menuAvaliacaoFrame.getContentPane().add(lblOQueDeseja);
		
		JButton btnAdicionarAvaliao = new JButton("Adicionar Avalia\u00E7\u00E3o");
		btnAdicionarAvaliao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAvaliacao window = new AddAvaliacao();
				window.addFrame.setVisible(true);
				menuAvaliacaoFrame.dispose();
			}
		});
		btnAdicionarAvaliao.setBounds(179, 192, 181, 75);
		menuAvaliacaoFrame.getContentPane().add(btnAdicionarAvaliao);
		
		JButton btnConsultarAvaliao = new JButton("Consultar Avalia\u00E7\u00E3o");
		btnConsultarAvaliao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaAvaliacao window = new ConsultaAvaliacao();
				window.consultaFrame.setVisible(true);
				menuAvaliacaoFrame.dispose();
			}
		});
		btnConsultarAvaliao.setBounds(427, 192, 179, 75);
		menuAvaliacaoFrame.getContentPane().add(btnConsultarAvaliao);
		
		JButton btnAlterarAvaliao = new JButton("Alterar Avalia\u00E7\u00E3o");
		btnAlterarAvaliao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarAvaliacao window = new AlterarAvaliacao();
				window.alteraFrame.setVisible(true);
				menuAvaliacaoFrame.dispose();
			}
		});
		btnAlterarAvaliao.setBounds(179, 300, 181, 75);
		menuAvaliacaoFrame.getContentPane().add(btnAlterarAvaliao);
		
		JButton btnExcluirAvaliao = new JButton("Excluir Avalia\u00E7\u00E3o");
		btnExcluirAvaliao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirAvaliacao window = new ExcluirAvaliacao();
				window.excluirFrame.setVisible(true);
				menuAvaliacaoFrame.dispose();
			}
		});
		btnExcluirAvaliao.setBounds(427, 300, 181, 75);
		menuAvaliacaoFrame.getContentPane().add(btnExcluirAvaliao);
		
		JButton btnVoltarParaMenu = new JButton("Voltar para menu principal");
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home window = new Home();
				window.homeFrame.setVisible(true);
				menuAvaliacaoFrame.dispose();
			}
		});
		btnVoltarParaMenu.setBounds(527, 447, 213, 23);
		menuAvaliacaoFrame.getContentPane().add(btnVoltarParaMenu);
	}
}
