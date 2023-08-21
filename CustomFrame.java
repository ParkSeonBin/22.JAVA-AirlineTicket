package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import DB.DBconn;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

public class CustomFrame {
	private JFrame frame;
	String header[] = {"항공편", "출발지", "도착지", "출발시간", "도착시간", "요금"};
	DefaultTableModel model;
	Object ob[][] = new Object[0][6];
	
	private Connection conn = DBconn.getConnection();
	
	int res1;
	int res2;
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
					CustomFrame window = new CustomFrame();
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
	public CustomFrame() {
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
		frame.setTitle("Custom Frame");
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setVisible(true);
		amain.frame.setVisible(false);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton reservation = new JButton("\uC608\uC57D\uD558\uAE30");
		reservation.setHorizontalAlignment(SwingConstants.RIGHT);
		reservation.setFont(new Font("굴림", Font.PLAIN, 18));
		panel.add(reservation);
		reservation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int flightNo = Integer.parseInt(JOptionPane.showInputDialog("항공편명을 입력하세요."));
				
				PreparedStatement pstmt;
			    String sql;
			    
			    sql = "insert into reservation values(?,?,?,?,?)";
			    Random random = new Random();
			    random.setSeed(System.currentTimeMillis());
			    int resno = random.nextInt(10);
			    Date date_now = new Date(System.currentTimeMillis());
			    SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMddHHmmss"); 
			    System.out.println(fourteen_format.format(date_now));
		    	try {
		    		pstmt = conn.prepareStatement(sql);
		    		pstmt.setInt(1, resno); //중복되지 않아야 함
		    		pstmt.setInt(2, flightNo);
		    		pstmt.setInt(3, userno);
		    		pstmt.setDate(4, date_now);
		    		pstmt.setString(5, "0");
		    		
		    		res1 = pstmt.executeUpdate();
		    	} catch (SQLException e1) {
		    		e1.printStackTrace();
		    	}	
		    	//여기
		   		sql = "insert into passenger(resno, flightno, psName) values(?,?,?)";
		   		try {
		   			pstmt = conn.prepareStatement(sql);
		    		pstmt.setInt(1, resno);
		    		pstmt.setInt(2, flightNo);
	    			pstmt.setString(3, "a");
	   			
	    			res2 = pstmt.executeUpdate();
		   		} catch (SQLException e1) {
		   			e1.printStackTrace();
		   		}	
		   		if(res2 > 0) {
		    		System.out.println("입력 성공");
		    	}
			    //까지
		    	if(res1 > 0){
	    			new passenger();
	    			frame.setVisible(false);
		    	}
			}
		});

		JButton search = new JButton("\uC608\uC57D \uC870\uD68C");
		search.setHorizontalAlignment(SwingConstants.RIGHT);
		search.setFont(new Font("굴림", Font.PLAIN, 18));
		panel.add(search);
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new search();
				frame.setVisible(false);
			}
		});
		
		JButton inform = new JButton("\uD68C\uC6D0 \uC815\uBCF4");
		inform.setHorizontalAlignment(SwingConstants.RIGHT);
		inform.setFont(new Font("굴림", Font.PLAIN, 18));
		panel.add(inform);
		inform.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new inf();
				frame.setVisible(false);
			}
		});

		
		JButton logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		logout.setHorizontalAlignment(SwingConstants.RIGHT);
		logout.setFont(new Font("굴림", Font.PLAIN, 18));
		panel.add(logout);
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Main();
				frame.setVisible(false);
			}
		});
		
		JPanel tablePanel = new JPanel();
		frame.getContentPane().add(tablePanel, BorderLayout.CENTER);
		
		
		//일정 테이블
		model = new DefaultTableModel(ob, header);

		JTable table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("굴림", Font.PLAIN, 18));
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		table.getColumn("항공편").setPreferredWidth(8);
		table.getColumn("항공편").setCellRenderer(celAlignCenter);
		table.getColumn("출발지").setPreferredWidth(8);
		table.getColumn("출발지").setCellRenderer(celAlignCenter);
		table.getColumn("도착지").setPreferredWidth(8);
		table.getColumn("도착지").setCellRenderer(celAlignCenter);
		table.getColumn("출발시간").setPreferredWidth(150);
		table.getColumn("출발시간").setCellRenderer(celAlignCenter);
		table.getColumn("도착시간").setPreferredWidth(150);
		table.getColumn("도착시간").setCellRenderer(celAlignCenter);
		table.getColumn("요금").setPreferredWidth(10);
		table.getColumn("요금").setCellRenderer(celAlignCenter);
		table.setRowHeight(27);
		
		JScrollPane scrollpane = new JScrollPane(table);
		
		model.setNumRows(0);
		frame.getContentPane().add("Center",scrollpane);
	    
		PreparedStatement pstmt;
	    ResultSet rs;
	    String sql;
	    
		try {
			sql = "Select *from flight";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int flightNo = rs.getInt("flightNo");
				String dep = rs.getString("dep");
				String des = rs.getString("des");
				String depTime = rs.getString("depTime");
				String desTime = rs.getString("desTime");
				int fare = rs.getInt("fare");
				
				Object data[] = {flightNo, dep, des, depTime, desTime, fare};
				model.addRow(data);
			}
		} catch (Exception e) {
			System.out.println("select() 실행 오류");
		}
	}
}


