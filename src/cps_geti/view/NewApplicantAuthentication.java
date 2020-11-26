package cps_geti.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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

import cps_geti.model.Applicant;
import cps_geti.controller.ApplicantControllerDAO;

public class NewApplicantAuthentication extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Applicant applicant;
	
	int xx, xy;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public NewApplicantAuthentication() {
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
		
		JLabel lblCPFConfirm = new JLabel("Digite o seu CPF para confirmar");
		lblCPFConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPFConfirm.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 16));
		lblCPFConfirm.setBounds(12, 30, 426, 54);
		contentPane.add(lblCPFConfirm);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 12));
		passwordField.setBounds(91, 98, 266, 32);
		contentPane.add(passwordField);
		
		JButton btnConfirm = new JButton("Confirmar");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String passCPF = String.valueOf(passwordField.getPassword());
				String msg = "CPF incorreto!";
				
				if (passCPF.equals(getApplicant().getCPF())) {
					msg = "Candidato existente";
					ApplicantControllerDAO dao = new ApplicantControllerDAO();
					boolean test = dao.setApplicant(getApplicant());
					
					if (test) {
						msg = "Inscrito com sucesso!";
					}
				}
				
				dispose();
				Dialogue dialogue = new Dialogue(msg);
				dialogue.setUndecorated(true);
				dialogue.setVisible(true);
			}
		});
		btnConfirm.setBackground(new Color(192, 192, 192));
		btnConfirm.setBorder(new LineBorder(new Color(192, 192, 192)));
		btnConfirm.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 12));
		btnConfirm.setBounds(155, 168, 128, 41);
		contentPane.add(btnConfirm);
	}
	
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	
	public Applicant getApplicant() {
		return this.applicant;
	}
}
