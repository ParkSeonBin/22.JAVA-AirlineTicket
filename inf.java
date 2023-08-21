package airline;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DB.DBconn;

import javax.swing.JButton;

public class inf {
	private JFrame frame;
	private JTextField TFPW;
	private JTextField TFNAME;
	private JTextField TFTEL;
	private JTextField TFEMAIL;
	
	private Connection conn = DBconn.getConnection();
	
	Main amain = new Main();
	String id = Main.id;
	
	int res;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inf window = new inf();
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
	public inf() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\uD68C\uC6D0\uAC00\uC785");
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		amain.frame.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0 \uC815\uBCF4");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 32));
		lblNewLabel.setBounds(312, 26, 139, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel PW = new JLabel("\uBE44\uBC00\uBC88\uD638");
		PW.setHorizontalAlignment(SwingConstants.CENTER);
		PW.setFont(new Font("굴림", Font.PLAIN, 21));
		PW.setBounds(183, 147, 90, 25);
		frame.getContentPane().add(PW);
		
		TFPW = new JTextField();
		TFPW.setColumns(10);
		TFPW.setBounds(275, 145, 258, 34);
		frame.getContentPane().add(TFPW);
		
		JLabel NAME = new JLabel("\uC774\uB984");
		NAME.setHorizontalAlignment(SwingConstants.CENTER);
		NAME.setFont(new Font("굴림", Font.PLAIN, 21));
		NAME.setBounds(183, 229, 90, 25);
		frame.getContentPane().add(NAME);
		
		TFNAME = new JTextField();
		TFNAME.setColumns(10);
		TFNAME.setBounds(275, 227, 258, 34);
		frame.getContentPane().add(TFNAME);
		
		JLabel TEL = new JLabel("\uC5F0\uB77D\uCC98");
		TEL.setHorizontalAlignment(SwingConstants.CENTER);
		TEL.setFont(new Font("굴림", Font.PLAIN, 21));
		TEL.setBounds(183, 305, 90, 25);
		frame.getContentPane().add(TEL);
		
		TFTEL = new JTextField();
		TFTEL.setColumns(10);
		TFTEL.setBounds(275, 303, 258, 34);
		frame.getContentPane().add(TFTEL);
		
		JLabel EMAIL = new JLabel("\uC774\uBA54\uC77C");
		EMAIL.setHorizontalAlignment(SwingConstants.CENTER);
		EMAIL.setFont(new Font("굴림", Font.PLAIN, 21));
		EMAIL.setBounds(183, 383, 90, 25);
		frame.getContentPane().add(EMAIL);
		
		TFEMAIL = new JTextField();
		TFEMAIL.setColumns(10);
		TFEMAIL.setBounds(275, 381, 258, 34);
		frame.getContentPane().add(TFEMAIL);
		
		JButton change = new JButton("\uBCC0\uACBD\uD558\uAE30");
		change.setFont(new Font("굴림", Font.PLAIN, 18));
		change.setBounds(429, 521, 113, 25);
		frame.getContentPane().add(change);
		change.addActionListener(new ActionListener() { //회원가입 버튼을 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				String pwd = TFPW.getText();
				String name = TFNAME.getText();
				String tel = TFTEL.getText();
				String email = TFEMAIL.getText();
				
				PreparedStatement pstmt;
			    ResultSet rs;
			    String sql;
			    
			    //유효성 검사
			    if(pwd.equals("")) {
			    	JOptionPane.showMessageDialog(frame, "비밀번호를 입력하세요.");
			    } else if(name.equals("")) {
			    	JOptionPane.showMessageDialog(frame, "이름을 입력하세요.");
			    } else if(tel.equals("")) {
			    	JOptionPane.showMessageDialog(frame, "연락처를 입력하세요.");
			    } else if(email.equals("")) {
			    	JOptionPane.showMessageDialog(frame, "이메일을 입력하세요.");
			    }else if(pwd.length()<6 || pwd.length()>20) {    
					JOptionPane.showMessageDialog(frame, "비밀번호는 6자리 이상, 20자리 이하만 가능 합니다.");
				}
			    
			    sql = "UPDATE a_user SET user_pwd=?, user_name=?, user_tel=?, user_email=?  WHERE user_id = ?";
		    	try {
		    		pstmt = conn.prepareStatement(sql);
		    		pstmt.setString(1, pwd);
		    		pstmt.setString(2, name);
		    		pstmt.setString(3, tel);
		    		pstmt.setString(4, email);
		    		pstmt.setString(5, id); //받아오기
		    		res = pstmt.executeUpdate();
		    	} catch (SQLException e1) {
		    		e1.printStackTrace();
		    	}	
		    	if(res > 0){
		    		JOptionPane.showMessageDialog(frame, "정보 변경 성공");
			    	TFPW.setText("");
			    	TFNAME.setText("");
			    	TFTEL.setText("");
			    	TFEMAIL.setText("");
				
			    	new CustomFrame();
			    	frame.setVisible(false);
			    }
			}
		}); 
	
		JButton delete = new JButton("\uC9C0\uC6B0\uAE30");
		delete.setFont(new Font("굴림", Font.PLAIN, 18));
		delete.setBounds(285, 521, 113, 25);
		frame.getContentPane().add(delete);
		delete.addActionListener(new ActionListener() { //지우기 버튼을 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				TFPW.setText("");
				TFNAME.setText("");
				TFTEL.setText("");
				TFEMAIL.setText("");
			}
		});	
		
		TFPW.setText("tjsqls123");
		TFNAME.setText("박선빈");
		TFTEL.setText("01033333333");
		TFEMAIL.setText("p011207@naver.com");
	}
}
