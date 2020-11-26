package cps_geti.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import cps_geti.controller.ApplicantControllerDAO;
import cps_geti.model.Applicant;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;


public class LoginApplicant extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;
	
	int xx, xy;

	/**
	 * Create the frame.
	 */
	public LoginApplicant() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
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
		
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 438, 810);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(LoginApplicant.class.getResource("/cps_geti/view/imgs/new-people.jpg")));
		lblImage.setBounds(-152, -214, 603, 1187);
		panel.add(lblImage);
		
		JLabel lblTitle = new JLabel("Processo Seletivo -GETI");
		lblTitle.setForeground(new Color(47, 79, 79));
		lblTitle.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 18));
		lblTitle.setIcon(new ImageIcon(LoginApplicant.class.getResource("/cps_geti/view/imgs/cps-nimage.jpg")));
		lblTitle.setBounds(519, 81, 411, 159);
		contentPane.add(lblTitle);
		
		JLabel lblUser = new JLabel("Nome");
		lblUser.setForeground(new Color(47, 79, 79));
		lblUser.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 15));
		lblUser.setBounds(519, 317, 70, 15);
		contentPane.add(lblUser);
		
		userField = new JTextField();
		userField.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 13));
		userField.setBounds(519, 344, 411, 42);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 206, 209));
		separator.setBackground(new Color(0, 206, 209));
		separator.setBounds(519, 385, 411, 2);
		contentPane.add(separator);
		
		JLabel lblPassword = new JLabel("CPF");
		lblPassword.setForeground(new Color(47, 79, 79));
		lblPassword.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 15));
		lblPassword.setBounds(519, 415, 70, 15);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 12));
		passwordField.setBounds(519, 442, 411, 42);
		contentPane.add(passwordField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 206, 209));
		separator_1.setForeground(new Color(0, 206, 209));
		separator_1.setBounds(519, 484, 411, 2);
		contentPane.add(separator_1);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ApplicantControllerDAO dao = new ApplicantControllerDAO();
				boolean test = dao.isValid(userField.getText(), String.valueOf(passwordField.getPassword()));
				
				String msg = "Usuário inexistente ou senha inválida.";
				
				if (!test) {
					Dialogue dialogue = new Dialogue(msg);
					dialogue.setUndecorated(true);
					dialogue.setVisible(true);
				} else {
					Applicant applicant = dao.getApplicant(String.valueOf(passwordField.getPassword()));
					ApplicantHome memberHome = new ApplicantHome(applicant);
					memberHome.setUndecorated(true);
					memberHome.setVisible(true);
					dispose();
				}
			}
		});
		
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(102, 102, 204));
		btnLogin.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 17));
		btnLogin.setBorder(new LineBorder(new Color(102, 102, 204)));
		btnLogin.setBounds(531, 523, 175, 55);
		contentPane.add(btnLogin);
		
		JLabel lblClose = new JLabel("X");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		lblClose.setForeground(new Color(178, 34, 34));
		lblClose.setFont(new Font("Open Sans", Font.BOLD, 23));
		lblClose.setBounds(994, 0, 30, 32);
		contentPane.add(lblClose);
		
		JButton btnBack = new JButton("Voltar");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home home = new Home();
				home.setUndecorated(true);
				home.setVisible(true);
				dispose();
			}
		});
		
		btnBack.setForeground(new Color(102, 102, 204));
		btnBack.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 17));
		btnBack.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.setBounds(450, 690, 138, 42);
		contentPane.add(btnBack);
	}
}