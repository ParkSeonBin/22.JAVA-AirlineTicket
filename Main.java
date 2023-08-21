package airline;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.*;
import java.util.List;

import DB.DBconn;

public class Main {
	
	JFrame frame;
	private JTextField ID;
	private JPasswordField PW;
	
	private Connection conn = DBconn.getConnection();
	
	static String id;
	
	int userno;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {   //원래 private였음
		frame = new JFrame();
		frame.setTitle("\uD56D\uACF5\uAD8C \uC608\uB9E4 \uD504\uB85C\uADF8\uB7A8");
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		ID = new JTextField();
		ID.setBounds(278, 455, 234, 27);
		frame.getContentPane().add(ID);
		ID.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(239, 455, 34, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setFont(new Font("굴림", Font.PLAIN, 20));
		lblPw.setBounds(239, 492, 34, 22);
		frame.getContentPane().add(lblPw);
		
		JPanel panel = new JPanel();
		panel.setBounds(81, 85, 634, 323);
		frame.getContentPane().add(panel);
		ImageIcon icon = new ImageIcon("비행기.png");
		Image img = icon.getImage();
		Image updateImg = img.getScaledInstance(634, 323, Image.SCALE_SMOOTH);
		ImageIcon updateIcon = new ImageIcon(updateImg);
		JLabel label = new JLabel(updateIcon);
		panel.add(label);
		
		
		PW = new JPasswordField();
		PW.setBounds(278, 492, 234, 27);
		frame.getContentPane().add(PW);
		
		JButton login = new JButton("\uB85C\uADF8\uC778");
		
		login.setBounds(421, 549, 91, 23);
		frame.getContentPane().add(login);
		
		JButton signup = new JButton("\uD68C\uC6D0\uAC00\uC785");
		signup.setBounds(318, 549, 91, 23);
		frame.getContentPane().add(signup);
		
		
		signup.addActionListener(new ActionListener() { //회원가입 버튼을 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				new SignUp();
				frame.setVisible(false);
			}
		});
		
		login.addActionListener(new ActionListener() { //로그인 버튼을 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				id = ID.getText();
				String pwd = PW.getText();
				
				PreparedStatement pstmt;
			    ResultSet rs;
			    String sql = "select* from a_user where user_id = ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
			        rs = pstmt.executeQuery();
			        while(rs.next()) {
			        	if(pwd.equals(rs.getString("user_pwd")))
			    		{
							System.out.println("로그인 성공");
							frame.setVisible(false);
							new CustomFrame();
							
							userDAO dao = new userDAO();
							List<userVO> name = dao.getName(id);
							for(int i=0; i<name.size(); i++) {
								userVO vo = name.get(i);
								userno=vo.getUser_no();
							}
							System.out.println(userno);
			      		}
			            else
			    		{
			            	System.out.println("로그인 실패");
			    		}
			        
			        }
			        } catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				ID.setText("");
				PW.setText("");
			}
		}); 
	}
}

