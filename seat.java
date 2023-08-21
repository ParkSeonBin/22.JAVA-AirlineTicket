package airline;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import DB.DBconn;

import javax.swing.JButton;
import java.awt.BorderLayout;

public class seat {

	private JFrame frame;
	private Connection conn = DBconn.getConnection();
	PreparedStatement pstmt;
	String sql;
	int res;
	
	Main amain = new Main();
	String id = Main.id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seat window = new seat();
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
	public seat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\uC608\uC57D\uD558\uAE30");
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		amain.frame.setVisible(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC88C\uC11D \uC120\uD0DD");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 32));
		lblNewLabel.setBounds(199, 26, 349, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JButton A1 = new JButton("A1");
		A1.setFont(new Font("굴림", Font.PLAIN, 20));
		A1.setBounds(35, 136, 89, 44);
		frame.getContentPane().add(A1);
		A1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='A1' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		}); 
		
		JButton A2 = new JButton("A2");
		A2.setFont(new Font("굴림", Font.PLAIN, 20));
		A2.setBounds(138, 136, 89, 44);
		frame.getContentPane().add(A2);
		A2.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='A2' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		}); 
		
		JButton A3 = new JButton("A3");
		A3.setFont(new Font("굴림", Font.PLAIN, 20));
		A3.setBounds(239, 136, 89, 44);
		frame.getContentPane().add(A3);
		A3.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='A3' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		}); 
		
		JButton A6 = new JButton("A6");
		A6.setFont(new Font("굴림", Font.PLAIN, 20));
		A6.setBounds(665, 136, 89, 44);
		frame.getContentPane().add(A6);
		A6.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='A6' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		}); 
		
		JButton A5 = new JButton("A5");
		A5.setFont(new Font("굴림", Font.PLAIN, 20));
		A5.setBounds(552, 136, 89, 44);
		frame.getContentPane().add(A5);
		A5.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='A5' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		}); 
		
		JButton A4 = new JButton("A4");
		A4.setFont(new Font("굴림", Font.PLAIN, 20));
		A4.setBounds(440, 136, 89, 44);
		frame.getContentPane().add(A4);
		A4.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='A4' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		}); 
		
		JButton B1 = new JButton("B1");
		B1.setFont(new Font("굴림", Font.PLAIN, 20));
		B1.setBounds(35, 217, 89, 44);
		frame.getContentPane().add(B1);
		B1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='B1' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		}); 
		
		JButton C1 = new JButton("C1");
		C1.setFont(new Font("굴림", Font.PLAIN, 20));
		C1.setBounds(35, 300, 89, 44);
		frame.getContentPane().add(C1);
		C1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='C1' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton D1 = new JButton("D1");
		D1.setFont(new Font("굴림", Font.PLAIN, 20));
		D1.setBounds(35, 385, 89, 44);
		frame.getContentPane().add(D1);
		D1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='D1' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton E1 = new JButton("E1");
		E1.setFont(new Font("굴림", Font.PLAIN, 20));
		E1.setBounds(35, 470, 89, 44);
		frame.getContentPane().add(E1);
		E1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='E1' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton B2 = new JButton("B2");
		B2.setFont(new Font("굴림", Font.PLAIN, 20));
		B2.setBounds(138, 217, 89, 44);
		frame.getContentPane().add(B2);
		B2.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='B2' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton B3 = new JButton("B3");
		B3.setFont(new Font("굴림", Font.PLAIN, 20));
		B3.setBounds(239, 217, 89, 44);
		frame.getContentPane().add(B3);
		B3.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='B3' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton B4 = new JButton("B4");
		B4.setFont(new Font("굴림", Font.PLAIN, 20));
		B4.setBounds(440, 217, 89, 44);
		frame.getContentPane().add(B4);
		B4.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='B4' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton B5 = new JButton("B5");
		B5.setFont(new Font("굴림", Font.PLAIN, 20));
		B5.setBounds(552, 217, 89, 44);
		frame.getContentPane().add(B5);
		B5.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='B5' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton B6 = new JButton("B6");
		B6.setFont(new Font("굴림", Font.PLAIN, 20));
		B6.setBounds(665, 217, 89, 44);
		frame.getContentPane().add(B6);
		B6.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='B6' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton C2 = new JButton("C2");
		C2.setFont(new Font("굴림", Font.PLAIN, 20));
		C2.setBounds(138, 300, 89, 44);
		frame.getContentPane().add(C2);
		C2.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='C2' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton C3 = new JButton("C3");
		C3.setFont(new Font("굴림", Font.PLAIN, 20));
		C3.setBounds(239, 300, 89, 44);
		frame.getContentPane().add(C3);
		C3.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='C3' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton C4 = new JButton("C4");
		C4.setFont(new Font("굴림", Font.PLAIN, 20));
		C4.setBounds(440, 300, 89, 44);
		frame.getContentPane().add(C4);
		C4.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='C4' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton C5 = new JButton("C5");
		C5.setFont(new Font("굴림", Font.PLAIN, 20));
		C5.setBounds(552, 300, 89, 44);
		frame.getContentPane().add(C5);
		C5.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='C5' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton C6 = new JButton("C6");
		C6.setFont(new Font("굴림", Font.PLAIN, 20));
		C6.setBounds(665, 300, 89, 44);
		frame.getContentPane().add(C6);
		C6.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='C6' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton D2 = new JButton("D2");
		D2.setFont(new Font("굴림", Font.PLAIN, 20));
		D2.setBounds(138, 385, 89, 44);
		frame.getContentPane().add(D2);
		D2.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='D2' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton D3 = new JButton("D3");
		D3.setFont(new Font("굴림", Font.PLAIN, 20));
		D3.setBounds(239, 385, 89, 44);
		frame.getContentPane().add(D3);
		D3.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='D3' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton D4 = new JButton("D4");
		D4.setFont(new Font("굴림", Font.PLAIN, 20));
		D4.setBounds(440, 385, 89, 44);
		frame.getContentPane().add(D4);
		D4.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='D4' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton D5 = new JButton("D5");
		D5.setFont(new Font("굴림", Font.PLAIN, 20));
		D5.setBounds(552, 385, 89, 44);
		frame.getContentPane().add(D5);
		D5.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='D5' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton D6 = new JButton("D6");
		D6.setFont(new Font("굴림", Font.PLAIN, 20));
		D6.setBounds(665, 385, 89, 44);
		frame.getContentPane().add(D6);
		D6.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='D6' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton E2 = new JButton("E2");
		E2.setFont(new Font("굴림", Font.PLAIN, 20));
		E2.setBounds(138, 470, 89, 44);
		frame.getContentPane().add(E2);
		E2.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='E2' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton E3 = new JButton("E3");
		E3.setFont(new Font("굴림", Font.PLAIN, 20));
		E3.setBounds(239, 470, 89, 44);
		frame.getContentPane().add(E3);
		E3.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='E3' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton E4 = new JButton("E4");
		E4.setFont(new Font("굴림", Font.PLAIN, 20));
		E4.setBounds(440, 470, 89, 44);
		frame.getContentPane().add(E4);
		E4.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='E4' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton E5 = new JButton("E5");
		E5.setFont(new Font("굴림", Font.PLAIN, 20));
		E5.setBounds(552, 470, 89, 44);
		frame.getContentPane().add(E5);
		E5.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='E5' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
		
		JButton E6 = new JButton("E6");
		E6.setFont(new Font("굴림", Font.PLAIN, 20));
		E6.setBounds(665, 470, 89, 44);
		frame.getContentPane().add(E6);
		E6.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "UPDATE passenger SET seatno='E6' WHERE seatno = '0'";
				res = 0;
				try {  		
					pstmt = conn.prepareStatement(sql);
					res = pstmt.executeUpdate();
				} catch (Exception e1) {
					System.out.println("업데이트 실행 오류");
				}
			    if(res > 0){
		            System.out.println("업데이트 완료");
		            frame.setVisible(false);
		        }
			}
		});
	}

}
