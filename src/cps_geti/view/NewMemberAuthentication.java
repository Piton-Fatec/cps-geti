package cps_geti.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import cps_geti.controller.MemberControllerDAO;

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

public class NewMemberAuthentication extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean validation;
	
	private String login;
	private char[] password;
	
	int xx, xy;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public NewMemberAuthentication() {
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
		
		JLabel lblConfirm = new JLabel("Digite a senha para cadastrar novo membro");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 16));
		lblConfirm.setBounds(12, 30, 426, 54);
		contentPane.add(lblConfirm);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 12));
		passwordField.setBounds(91, 98, 266, 32);
		contentPane.add(passwordField);
		
		JButton btnConfirm = new JButton("Confirmar");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password = String.valueOf(passwordField.getPassword());
				if (password.equals("senha")) {
					MemberControllerDAO dao = new MemberControllerDAO();
					boolean test = dao.setMember(getLogin(), getPassword());
					String msg = "Usuário existente. Tente novamente.";
					
					if (test) {
						msg = "Usuário criado com sucesso!";
					}
					
					Dialogue dialogue = new Dialogue(msg);
					dialogue.setUndecorated(true);
					dialogue.setVisible(true);

				} else {
					Dialogue dialogue = new Dialogue("Senha incorreta!");
					dialogue.setUndecorated(true);
					dialogue.setVisible(true);
				}
				dispose();
			}
		});
		btnConfirm.setBackground(new Color(192, 192, 192));
		btnConfirm.setBorder(new LineBorder(new Color(192, 192, 192)));
		btnConfirm.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 12));
		btnConfirm.setBounds(155, 168, 128, 41);
		contentPane.add(btnConfirm);
	}
	
	public boolean getValidation() {
		return this.validation;
	}
	
	public void setValidation(boolean bool) {
		this.validation = bool;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public char[] getPassword() {
		return this.password;
	}
	
	public void setPassword(char[] cs) {
		this.password = cs;
	}
	
}
