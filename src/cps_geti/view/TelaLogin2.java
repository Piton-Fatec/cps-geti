package cps_geti.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class TelaLogin2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	int xx, xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin2 frame = new TelaLogin2();
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
	public TelaLogin2() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
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
		        TelaLogin2.this.setLocation(x - xx, y - xy);  
			}
		});
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 438, 810);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin2.class.getResource("/cps_geti/view/imgs/new-people.jpg")));
		lblNewLabel.setBounds(-152, -214, 603, 1187);
		panel.add(lblNewLabel);
		
		JLabel lblTeste = new JLabel("Teste");
		lblTeste.setForeground(new Color(47, 79, 79));
		lblTeste.setFont(new Font("Open Sans", Font.BOLD, 15));
		lblTeste.setBounds(519, 658, 70, 15);
		contentPane.add(lblTeste);
		
		textField = new JTextField();
		textField.setFont(new Font("Open Sans", Font.PLAIN, 13));
		textField.setBounds(519, 344, 411, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Button button = new Button("Entrar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblTeste.setText(textField.getText());
			}
		});
		button.setForeground(new Color(255, 255, 255));
		button.setFont(new Font("Open Sans", Font.PLAIN, 18));
		button.setBackground(new Color(70, 130, 180));
		button.setActionCommand("");
		button.setBounds(643, 566, 175, 55);
		contentPane.add(button);
	
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 206, 209));
		separator.setBackground(new Color(0, 206, 209));
		separator.setBounds(519, 385, 411, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 206, 209));
		separator_1.setForeground(new Color(0, 206, 209));
		separator_1.setBounds(519, 484, 411, 2);
		contentPane.add(separator_1);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(47, 79, 79));
		lblSenha.setFont(new Font("Open Sans", Font.BOLD, 15));
		lblSenha.setBounds(519, 415, 70, 15);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(519, 442, 411, 42);
		contentPane.add(passwordField);
		
		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setForeground(new Color(47, 79, 79));
		lblUsurio.setFont(new Font("Open Sans", Font.BOLD, 15));
		lblUsurio.setBounds(519, 317, 70, 15);
		contentPane.add(lblUsurio);
		
		JLabel lblNewLabel_1 = new JLabel("Processo Seletivo -GETI");
		lblNewLabel_1.setForeground(new Color(47, 79, 79));
		lblNewLabel_1.setFont(new Font("Open Sans", Font.BOLD, 18));
		lblNewLabel_1.setIcon(new ImageIcon(TelaLogin2.class.getResource("/cps_geti/view/imgs/cps-nimage.jpg")));
		lblNewLabel_1.setBounds(519, 81, 411, 159);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lbl_close.setForeground(new Color(178, 34, 34));
		lbl_close.setFont(new Font("Open Sans", Font.BOLD, 23));
		lbl_close.setBounds(994, 0, 30, 32);
		contentPane.add(lbl_close);
		

	}
}
