package cps_geti.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	int xx, xy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
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
		        Home.this.setLocation(x - xx, y - xy);  
			}
		});
		
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 438, 810);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(Home.class.getResource("/cps_geti/view/imgs/new-people.jpg")));
		lblImage.setBounds(-152, -214, 603, 1187);
		panel.add(lblImage);
		
		JLabel lblTitle = new JLabel("Processo Seletivo -GETI");
		lblTitle.setForeground(new Color(47, 79, 79));
		lblTitle.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 18));
		lblTitle.setIcon(new ImageIcon(Home.class.getResource("/cps_geti/view/imgs/cps-nimage.jpg")));
		lblTitle.setBounds(519, 81, 411, 159);
		contentPane.add(lblTitle);
		
		JButton btnLogin = new JButton("Acessar área do candidato");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(102, 102, 204));
		btnLogin.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 17));
		btnLogin.setBorder(new LineBorder(new Color(102, 102, 204)));
		btnLogin.setBounds(608, 336, 268, 55);
		contentPane.add(btnLogin);
		
		JButton btnApply = new JButton("Inscrição para o edital");
		btnApply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				ApplicantForm form = new ApplicantForm();
				form.setUndecorated(true);
				form.setVisible(true);
			}
		});
		
		btnApply.setForeground(Color.WHITE);
		btnApply.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 17));
		btnApply.setBorder(new LineBorder(new Color(60, 179, 113), 5, true));
		btnApply.setBackground(new Color(60, 179, 113));
		btnApply.setBounds(608, 427, 268, 55);
		contentPane.add(btnApply);
		
		JButton btnMemberLogin = new JButton("Membro CPS");
		btnMemberLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				LoginMember loginMember = new LoginMember();
				loginMember.setUndecorated(true);
				loginMember.setVisible(true);
			}
		});
		
		btnMemberLogin.setForeground(Color.WHITE);
		btnMemberLogin.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 17));
		btnMemberLogin.setBorder(new LineBorder(new Color(95, 158, 160)));
		btnMemberLogin.setBackground(new Color(95, 158, 160));
		btnMemberLogin.setBounds(608, 517, 268, 55);
		contentPane.add(btnMemberLogin);
		
		
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
		
		JLabel lblWelcome = new JLabel("Seja Bem-Vindo! Clique na opção desejada");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(new Color(47, 79, 79));
		lblWelcome.setFont(new Font("Noto Sans CJK JP", Font.BOLD, 18));
		lblWelcome.setBounds(519, 252, 411, 62);
		contentPane.add(lblWelcome);
	}
}