package cps_geti.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import cps_geti.controller.GerenciamentoCandidato;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import cps_geti.model.Candidato;

public class AutenticacaoNovoCandidato extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Candidato candidato;
	
	int xx, xy;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public AutenticacaoNovoCandidato() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
		        int y = e.getYOnScreen();
		        setLocation(x - xx, y - xy);  
			}
		});
		
		JLabel lblDigiteASenha = new JLabel("Digite o seu CPF para confirmar");
		lblDigiteASenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblDigiteASenha.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 16));
		lblDigiteASenha.setBounds(12, 30, 426, 54);
		contentPane.add(lblDigiteASenha);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 12));
		passwordField.setBounds(91, 98, 266, 32);
		contentPane.add(passwordField);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String passCPF = String.valueOf(passwordField.getPassword());
				
				String msg = "CPF incorreto!";
				
				if (passCPF.equals(getCandidato().getCPF())) {
					msg = "Candidato existente";
					GerenciamentoCandidato manageCandidato = new GerenciamentoCandidato();
					boolean testeCriar = manageCandidato.criarUsuario(getCandidato());
					
					if (testeCriar) {
						msg = "Inscrito com sucesso!";
					}
				}
				
				dispose();
				Dialogo dialogo = new Dialogo(msg);
				dialogo.setUndecorated(true);
				dialogo.setVisible(true);
			}
		});
		btnConfirmar.setBackground(new Color(192, 192, 192));
		btnConfirmar.setBorder(new LineBorder(new Color(192, 192, 192)));
		btnConfirmar.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 12));
		btnConfirmar.setBounds(155, 168, 128, 41);
		contentPane.add(btnConfirmar);
	}
	
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	public Candidato getCandidato() {
		return this.candidato;
	}
}
