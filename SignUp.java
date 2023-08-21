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

public class SignUp {
	private JFrame frame;
	private JTextField TFID;
	private JTextField TFPW;
	private JTextField TFNAME;
	private JTextField TFTEL;
	private JTextField TFEMAIL;
	
	private Connection conn = DBconn.getConnection();
	
	int res;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
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
	public SignUp() {
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
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 32));
		lblNewLabel.setBounds(312, 26, 139, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel ID = new JLabel("\uC544\uC774\uB514");
		ID.setHorizontalAlignment(SwingConstants.CENTER);
		ID.setFont(new Font("굴림", Font.PLAIN, 21));
		ID.setBounds(181, 120, 90, 25);
		frame.getContentPane().add(ID);
		
		TFID = new JTextField();
		TFID.setBounds(273, 118, 258, 34);
		frame.getContentPane().add(TFID);
		TFID.setColumns(10);
		
		JLabel PW = new JLabel("\uBE44\uBC00\uBC88\uD638");
		PW.setHorizontalAlignment(SwingConstants.CENTER);
		PW.setFont(new Font("굴림", Font.PLAIN, 21));
		PW.setBounds(181, 204, 90, 25);
		frame.getContentPane().add(PW);
		
		TFPW = new JTextField();
		TFPW.setColumns(10);
		TFPW.setBounds(273, 202, 258, 34);
		frame.getContentPane().add(TFPW);
		
		JLabel NAME = new JLabel("\uC774\uB984");
		NAME.setHorizontalAlignment(SwingConstants.CENTER);
		NAME.setFont(new Font("굴림", Font.PLAIN, 21));
		NAME.setBounds(181, 286, 90, 25);
		frame.getContentPane().add(NAME);
		
		TFNAME = new JTextField();
		TFNAME.setColumns(10);
		TFNAME.setBounds(273, 284, 258, 34);
		frame.getContentPane().add(TFNAME);
		
		JLabel TEL = new JLabel("\uC5F0\uB77D\uCC98");
		TEL.setHorizontalAlignment(SwingConstants.CENTER);
		TEL.setFont(new Font("굴림", Font.PLAIN, 21));
		TEL.setBounds(181, 362, 90, 25);
		frame.getContentPane().add(TEL);
		
		TFTEL = new JTextField();
		TFTEL.setColumns(10);
		TFTEL.setBounds(273, 360, 258, 34);
		frame.getContentPane().add(TFTEL);
		
		JLabel EMAIL = new JLabel("\uC774\uBA54\uC77C");
		EMAIL.setHorizontalAlignment(SwingConstants.CENTER);
		EMAIL.setFont(new Font("굴림", Font.PLAIN, 21));
		EMAIL.setBounds(181, 440, 90, 25);
		frame.getContentPane().add(EMAIL);
		
		TFEMAIL = new JTextField();
		TFEMAIL.setColumns(10);
		TFEMAIL.setBounds(273, 438, 258, 34);
		frame.getContentPane().add(TFEMAIL);
		
		JButton signup = new JButton("\uD68C\uC6D0\uAC00\uC785");
		signup.setFont(new Font("굴림", Font.PLAIN, 18));
		signup.setBounds(429, 521, 113, 25);
		frame.getContentPane().add(signup);
		signup.addActionListener(new ActionListener() { //회원가입 버튼을 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = TFID.getText();
				String pwd = TFPW.getText();
				String name = TFNAME.getText();
				String tel = TFTEL.getText();
				String email = TFEMAIL.getText();
				
				PreparedStatement pstmt;
			    ResultSet rs;
			    String sql;
			    
			    //유효성 검사
			    if(id.equals("")) {
			    	JOptionPane.showMessageDialog(frame, "아이디를 입력하세요.");
			    } else if(pwd.equals("")) {
			    	JOptionPane.showMessageDialog(frame, "비밀번호를 입력하세요.");
			    } else if(name.equals("")) {
			    	JOptionPane.showMessageDialog(frame, "이름을 입력하세요.");
			    } else if(tel.equals("")) {
			    	JOptionPane.showMessageDialog(frame, "연락처를 입력하세요.");
			    } else if(email.equals("")) {
			    	JOptionPane.showMessageDialog(frame, "이메일을 입력하세요.");
			    } else if(id.length()<6 || id.length()>15) {    
					JOptionPane.showMessageDialog(frame, "아이디는 6자리 이상, 15자리 이하만 가능 합니다.");
				} else if(pwd.length()<6 || pwd.length()>20) {    
					JOptionPane.showMessageDialog(frame, "비밀번호는 6자리 이상, 20자리 이하만 가능 합니다.");
				}
			    else {
			    	sql = "select user_id from a_user where user_id = ?";
					try {
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, id);
				        rs = pstmt.executeQuery();
				        while(rs.next()) {
				        	if(id.equals(rs.getString("user_id")))
				    		{
				        		JOptionPane.showMessageDialog(frame, "아이디가 중복됩니다.", "ERROR_MESSAGE", 1);
				      		}
				        }
				     } catch (SQLException e1) {
						e1.printStackTrace();
					}
			    }
			    
			    sql = "insert into a_user values(?,?,?,?,?,?,0,0)";
			    Random random = new Random();
			    random.setSeed(System.currentTimeMillis());
			    int userNo = random.nextInt(10);
		    	try {
		    		pstmt = conn.prepareStatement(sql);
		    		pstmt.setInt(1, userNo); //중복되지 않아야 함
		    		pstmt.setString(2, id);
		    		pstmt.setString(3, pwd);
		    		pstmt.setString(4, name);
		    		pstmt.setString(5, tel);
		    		pstmt.setString(6, email);
		    		res = pstmt.executeUpdate();
		    	} catch (SQLException e1) {
		    		e1.printStackTrace();
		    	}	
		    	if(res > 0){
		    		JOptionPane.showMessageDialog(frame, "회원가입 성공");
		    		TFID.setText("");
			    	TFPW.setText("");
			    	TFNAME.setText("");
			    	TFTEL.setText("");
			    	TFEMAIL.setText("");
				
			    	new Main();
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
				
				TFID.setText("");
				TFPW.setText("");
				TFNAME.setText("");
				TFTEL.setText("");
				TFEMAIL.setText("");
			}
		});
		
		JButton back = new JButton("\uCC98\uC74C\uD654\uBA74\uC73C\uB85C ");  //처음 화면으로 돌아가기
		back.setBounds(630, 610, 131, 25);
		frame.getContentPane().add(back);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Main();
				frame.setVisible(false);
			}
		});
		
	}
		
}
