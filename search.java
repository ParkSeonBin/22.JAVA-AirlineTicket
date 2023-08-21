package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DB.DBconn;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class search {
	private JFrame frame;
	
	String header[] = {"항공편", "이름", "연락처", "이메일", "좌석"};
	DefaultTableModel model;
	Object ob[][] = new Object[0][5];
	
	private Connection conn = DBconn.getConnection();
	
	Main amain = new Main();
	String id = Main.id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search window = new search();
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
	public search() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("My reservation");
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		amain.frame.setVisible(false);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JButton back = new JButton("\uB3CC\uC544\uAC00\uAE30");
		back.setFont(new Font("굴림", Font.PLAIN, 20));
		frame.getContentPane().add(back, BorderLayout.SOUTH);
		back.addActionListener(new ActionListener() { //회원가입 버튼을 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new CustomFrame();
			}
		});
	
	
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
			table.getColumn("이름").setPreferredWidth(8);
			table.getColumn("이름").setCellRenderer(celAlignCenter);
			table.getColumn("연락처").setPreferredWidth(8);
			table.getColumn("연락처").setCellRenderer(celAlignCenter);
			table.getColumn("이메일").setPreferredWidth(150);
			table.getColumn("이메일").setCellRenderer(celAlignCenter);
			table.getColumn("좌석").setPreferredWidth(150);
			table.getColumn("좌석").setCellRenderer(celAlignCenter);
			table.setRowHeight(27);
			
			JScrollPane scrollpane = new JScrollPane(table);
			
			model.setNumRows(0);
			
			JLabel lblNewLabel = new JLabel("\uC608\uC57D \uC870\uD68C");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 32));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
			frame.getContentPane().add(scrollpane, BorderLayout.CENTER);
		    
			PreparedStatement pstmt;
		    ResultSet rs;
		    String sql; 
			try {
				sql = "Select *from passenger";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					int flightNo = rs.getInt("flightNo");
					String psName = rs.getString("psName");
					String psTel = rs.getString("psTel");
					String psEmail = rs.getString("psEmail");
					String seatno = rs.getString("seatno");
					
					Object data[] = {flightNo, psName, psTel, psEmail, seatno};
					model.addRow(data);
				}
			} catch (Exception e) {
				System.out.println("select() 실행 오류");
			}
		}

}
