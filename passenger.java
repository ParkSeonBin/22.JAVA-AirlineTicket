package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import DB.DBconn;

public class passenger {

	private JFrame frame;
	private JTextField psNameTF;
	private JTextField psTelTF;
	private JTextField psEmailTF;
	
	private Connection conn = DBconn.getConnection();
	
	int i = 0;
	int userno;
	
	Main amain = new Main();
	String id = Main.id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					passenger window = new passenger();
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
	public passenger() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		userDAO dao = new userDAO();
		List<userVO> name = dao.getName(id);
		for(int i=0; i<name.size(); i++) {
			userVO vo = name.get(i);
			userno=vo.getUser_no();
		}
		System.out.println(userno);
		
		frame = new JFrame();
		frame.setTitle("\uC608\uC57D\uD558\uAE30");
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		amain.frame.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("\uB3D9\uC2B9\uC790 \uC815\uBCF4 \uC785\uB825");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 32));
		lblNewLabel.setBounds(199, 26, 349, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB3D9\uC2B9\uC790 \uC774\uB984");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(153, 161, 128, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		psNameTF = new JTextField();
		psNameTF.setBounds(283, 152, 248, 39);
		frame.getContentPane().add(psNameTF);
		psNameTF.setColumns(10);
		
		JLabel label = new JLabel("\uB3D9\uC2B9\uC790 \uC5F0\uB77D\uCC98");
		label.setFont(new Font("굴림", Font.PLAIN, 20));
		label.setBounds(153, 260, 128, 30);
		frame.getContentPane().add(label);
		
		psTelTF = new JTextField();
		psTelTF.setColumns(10);
		psTelTF.setBounds(283, 251, 248, 39);
		frame.getContentPane().add(psTelTF);
		
		JLabel label2 = new JLabel("\uB3D9\uC2B9\uC790 \uC774\uBA54\uC77C");
		label2.setFont(new Font("굴림", Font.PLAIN, 20));
		label2.setBounds(153, 370, 128, 30);
		frame.getContentPane().add(label2);
		
		psEmailTF = new JTextField();
		psEmailTF.setColumns(10);
		psEmailTF.setBounds(283, 361, 248, 39);
		frame.getContentPane().add(psEmailTF);
		
		JButton delete = new JButton("\uC9C0\uC6B0\uAE30");
		delete.setFont(new Font("굴림", Font.PLAIN, 18));
		delete.setBounds(285, 521, 113, 25);
		frame.getContentPane().add(delete);
		delete.addActionListener(new ActionListener() { //지우기 버튼을 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				psNameTF.setText("");
				psTelTF.setText("");
				psEmailTF.setText("");
			}
		});
		
		JButton next = new JButton("\uB2E4\uC74C \uB2E8\uACC4");
		next.setFont(new Font("굴림", Font.PLAIN, 18));
		next.setBounds(429, 521, 113, 25);
		frame.getContentPane().add(next);
		
		int peopleNum = Integer.parseInt(JOptionPane.showInputDialog("예약할 인원수를 입력하세요."));
		PreparedStatement pstmt;
		String sql;
		int res = 0;

	    try {  		
	    	sql = "UPDATE reservation SET psNum=? WHERE psNum = '0'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, peopleNum);
			res = pstmt.executeUpdate();
		} catch (Exception e1) {
			System.out.println("업데이트 실행 오류");
		}
	    if(res > 0){
            System.out.println("인원 수 업데이트 완료");
        }
	
		
		next.addActionListener(new ActionListener() { //다음 단계 버튼을 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				String psName = psNameTF.getText();
				String psTel = psTelTF.getText();
				String psEmail = psEmailTF.getText();
					
				PreparedStatement pstmt;
				String sql;
				int res = 0;

				sql = "UPDATE passenger SET psName=?, psTel=?, psEmail=?, seatno=?  WHERE psName = 'a'";
				res = 0;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, psName);
					pstmt.setString(2, psTel);
					pstmt.setString(3, psEmail);
					pstmt.setString(4, "0");
					res = pstmt.executeUpdate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
				if(res > 0){
					psNameTF.setText("");
					psTelTF.setText("");
					psEmailTF.setText("");

					new seat();
					//frame.setVisible(false);
					i++;
				}
				if(i==peopleNum)
				{
					frame.setVisible(false);
					new CustomFrame();
					//i=0;
				}
			}
		}); 
	}
}
