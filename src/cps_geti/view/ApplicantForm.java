package cps_geti.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

import cps_geti.model.Applicant;

public class ApplicantForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField cepField;
	private JTextField cpfField;
	
	int xx, xy;

	/**
	 * Create the frame.
	 */
	public ApplicantForm() {
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
		lblImage.setIcon(new ImageIcon(ApplicantForm.class.getResource("/cps_geti/view/imgs/new-people.jpg")));
		lblImage.setBounds(-152, -214, 603, 1187);
		panel.add(lblImage);
		
		JLabel lblTitle= new JLabel("Processo Seletivo -GETI");
		lblTitle.setForeground(new Color(47, 79, 79));
		lblTitle.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 18));
		lblTitle.setIcon(new ImageIcon(ApplicantForm.class.getResource("/cps_geti/view/imgs/cps-nimage.jpg")));
		lblTitle.setBounds(519, 81, 411, 159);
		contentPane.add(lblTitle);
		
		JLabel lblName = new JLabel("Nome");
		lblName.setForeground(new Color(47, 79, 79));
		lblName.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 15));
		lblName.setBounds(519, 239, 70, 15);
		contentPane.add(lblName);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 13));
		nameField.setBounds(519, 268, 411, 42);
		nameField.setColumns(10);
		contentPane.add(nameField);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setForeground(new Color(47, 79, 79));
		lblEmail.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 15));
		lblEmail.setBounds(519, 322, 70, 15);
		contentPane.add(lblEmail);
		
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

		emailField = new JTextField();
		emailField.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 13));
		emailField.setColumns(10);
		emailField.setBounds(519, 349, 411, 42);
		contentPane.add(emailField);
		
		cepField = new JTextField();
		cepField.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 13));
		cepField.setColumns(10);
		cepField.setBounds(747, 434, 185, 42);
		contentPane.add(cepField);
		
		cpfField = new JTextField();
		cpfField.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 13));
		cpfField.setColumns(10);
		cpfField.setBounds(519, 434, 185, 42);
		contentPane.add(cpfField);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setForeground(new Color(47, 79, 79));
		lblCep.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 15));
		lblCep.setBounds(747, 403, 70, 15);
		contentPane.add(lblCep);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setForeground(new Color(47, 79, 79));
		lblCpf.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 15));
		lblCpf.setBounds(519, 403, 70, 15);
		contentPane.add(lblCpf);
		
		JButton btnRegister = new JButton("Cadastrar");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewApplicantAuthentication auth = new NewApplicantAuthentication();
				auth.setApplicant(new Applicant(
						nameField.getText(),
						emailField.getText(),
						cpfField.getText(),
						cepField.getText(),
						"Não deferida"));
				auth.setUndecorated(true);
				auth.setVisible(true);
			}
		});
		
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 17));
		btnRegister.setBorder(new LineBorder(new Color(128, 128, 128)));
		btnRegister.setBackground(new Color(46, 139, 87));
		btnRegister.setBounds(647, 535, 175, 55);
		contentPane.add(btnRegister);
		
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