package cps_geti.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import cps_geti.model.Applicant;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ApplicantHome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	int xx, xy;

	/**
	 * Create the frame.
	 */
	public ApplicantHome(Applicant applicant) {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 1024, 768);
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

		JLabel lblImage = new JLabel("");
		lblImage.setForeground(new Color(47, 79, 79));
		lblImage.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 15));
		lblImage.setIcon(new ImageIcon(ApplicantHome.class.getResource("/cps_geti/view/imgs/cps-nimage.jpg")));
		lblImage.setBounds(22, 37, 196, 92);
		contentPane.add(lblImage);

		JLabel lblTitle = new JLabel("Área do Candidato");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setForeground(new Color(47, 79, 79));
		lblTitle.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 25));
		lblTitle.setBounds(219, 54, 423, 41);
		contentPane.add(lblTitle);

		JLabel lblClose = new JLabel("X");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		lblClose.setForeground(new Color(178, 34, 34));
		lblClose.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 23));
		lblClose.setBounds(994, 0, 30, 32);
		contentPane.add(lblClose);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(644, 37, 346, 103);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBack = new JButton("Sair");
		btnBack.setBounds(168, 54, 78, 15);
		panel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home ti = new Home();
				ti.setUndecorated(true);
				ti.setVisible(true);
				dispose();
			}
		});
		
		btnBack.setForeground(new Color(102, 102, 204));
		btnBack.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 12));
		btnBack.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnBack.setBackground(Color.WHITE);
		
		JLabel lblActiveUser = new JLabel("Olá, " + applicant.getName() + "! Seja bem-vindo!");
		lblActiveUser.setBounds(122, 12, 212, 18);
		panel.add(lblActiveUser);
		lblActiveUser.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 12));
		
		JLabel lblUserIcon = new JLabel("");
		lblUserIcon.setBounds(49, 12, 57, 74);
		panel.add(lblUserIcon);
		lblUserIcon.setIcon(new ImageIcon(ApplicantHome.class.getResource("/cps_geti/view/imgs/Webp.net-resizeimage (1).png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(190, 255, 254));
		panel_1.setBounds(46, 192, 440, 326);
		contentPane.add(panel_1);
		
		JLabel lblApplicantData = new JLabel("Seus dados");
		lblApplicantData.setHorizontalAlignment(SwingConstants.CENTER);
		lblApplicantData.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 23));
		lblApplicantData.setBounds(12, 12, 416, 28);
		panel_1.add(lblApplicantData);
		
		JLabel lblName = new JLabel("Nome: " + applicant.getName());
		lblName.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 18));
		lblName.setBounds(12, 103, 416, 18);
		panel_1.add(lblName);
		
		JLabel lblemail = new JLabel("E-mail: " + applicant.getEmail());
		lblemail.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 18));
		lblemail.setBounds(12, 153, 416, 18);
		panel_1.add(lblemail);
		
		JLabel lblcpf = new JLabel("CPF: " + applicant.getCPF());
		lblcpf.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 18));
		lblcpf.setBounds(12, 205, 416, 18);
		panel_1.add(lblcpf);
		
		JLabel lblcep = new JLabel("CEP: " + applicant.getCEP());
		lblcep.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 18));
		lblcep.setBounds(12, 256, 416, 18);
		panel_1.add(lblcep);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(180, 255, 244));
		panel_1_1.setBounds(535, 192, 455, 326);
		contentPane.add(panel_1_1);
		
		JLabel lblstatusApplicant = new JLabel(applicant.getStatus());
		lblstatusApplicant.setHorizontalAlignment(SwingConstants.CENTER);
		lblstatusApplicant.setBackground(new Color(204, 204, 255));
		lblstatusApplicant.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 20));
		lblstatusApplicant.setBounds(12, 112, 431, 148);
		panel_1_1.add(lblstatusApplicant);
		
		JLabel lblStatus = new JLabel("Situação");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 23));
		lblStatus.setBounds(12, 12, 431, 28);
		panel_1_1.add(lblStatus);
	}
}