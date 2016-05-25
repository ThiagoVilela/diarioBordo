package com.screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import com.thiago.Aplicacao;
import com.thiago.Turma;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddTurma {

	JFrame addTurmaFrame;
	private JTextField nameField;
	private JTextField classField;
	private JTextField subjectField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTurma window = new AddTurma();
					window.addTurmaFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddTurma() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addTurmaFrame = new JFrame();
		addTurmaFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Thiago\\Pictures\\Logo JAVA Group\\1448331815_app_type_coffee_shop_512px_GREY.png"));
		addTurmaFrame.setTitle("Adicionar Turma - Di\u00E1rio de Bordo");
		addTurmaFrame.setBounds(100, 100, 807, 575);
		addTurmaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addTurmaFrame.getContentPane().setLayout(null);
		
		JLabel lblVocEstEm = new JLabel("Voc\u00EA est\u00E1 em 'Adicionar Turma'");
		lblVocEstEm.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVocEstEm.setBounds(49, 32, 274, 56);
		addTurmaFrame.getContentPane().add(lblVocEstEm);
		
		JLabel lblPreenchaOsCampos = new JLabel("Preencha os campos com os dados indicados:");
		lblPreenchaOsCampos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreenchaOsCampos.setBounds(86, 133, 443, 34);
		addTurmaFrame.getContentPane().add(lblPreenchaOsCampos);
		
		nameField = new JTextField();
		nameField.setBounds(169, 223, 323, 20);
		addTurmaFrame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(89, 226, 70, 14);
		addTurmaFrame.getContentPane().add(lblNome);
		
		classField = new JTextField();
		classField.setColumns(10);
		classField.setBounds(169, 254, 111, 20);
		addTurmaFrame.getContentPane().add(classField);
		
		JLabel lblSala = new JLabel("Sala");
		lblSala.setBounds(89, 257, 70, 14);
		addTurmaFrame.getContentPane().add(lblSala);
		
		subjectField = new JTextField();
		subjectField.setBounds(170, 285, 153, 20);
		addTurmaFrame.getContentPane().add(subjectField);
		subjectField.setColumns(10);
		
		JLabel lblMatria = new JLabel("Mat\u00E9ria");
		lblMatria.setBounds(89, 288, 70, 14);
		addTurmaFrame.getContentPane().add(lblMatria);
		
		JLabel sucessoLabel = new JLabel("Turma adicionada com sucesso");
		sucessoLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sucessoLabel.setBounds(441, 342, 0, 34);
		addTurmaFrame.getContentPane().add(sucessoLabel);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = null;
				String sala = null;
				String materia = null;
				
				if (nameField.getText().equals("") || classField.getText().equals("") || subjectField.getText().equals("")) {
					sucessoLabel.setText("Preencha todos os campos.");
					sucessoLabel.setBounds(441, 342, 300, 34);
					return;
				} else{
					nome = nameField.getText();
					sala = classField.getText();
					materia = subjectField.getText();
				
					if(nome == null){
						MessageDialog.openError(new Shell(), "Erro", "Nome inválido.");
						return;
					} else if(sala == null){
						MessageDialog.openError(new Shell(), "Erro", "Série inválida.");
						return;
					} else if(materia == null){
						MessageDialog.openError(new Shell(), "Erro", "Matéria inválida.");
						return;
					}
					
					//ADD TURMA
					Turma turma = new Turma(nome, sala, materia);
					Aplicacao.bd.getTurmas().add(turma);
					//System.out.println(Aplicacao.bd.getTurmas().size());
					
					nameField.setText("");
					classField.setText("");
					subjectField.setText("");
					
					sucessoLabel.setText("Turma adicionada com sucesso.");
					sucessoLabel.setBounds(441, 342, 300, 34);
					
					return;
				}
			}
		});
		btnAdicionar.setBounds(86, 350, 125, 23);
		addTurmaFrame.getContentPane().add(btnAdicionar);
		
		JButton btnVoltarParaTurma = new JButton("Voltar para Turma");
		btnVoltarParaTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditTurma window = new EditTurma();
				window.turmaFrame.setVisible(true);
				addTurmaFrame.dispose();
			}
		});
		btnVoltarParaTurma.setBounds(577, 455, 153, 23);
		addTurmaFrame.getContentPane().add(btnVoltarParaTurma);
		
	}
}
