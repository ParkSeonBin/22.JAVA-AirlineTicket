package airline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.DBconn;

public class userDAO {
	private Connection conn = DBconn.getConnection();
	public userDAO() {}
	
	public List<userVO> getName(String user_id) {
		List<userVO> lst = new ArrayList<userVO>();
		String sql;
		PreparedStatement pstmt;
		ResultSet rs;
		try {
			sql = "select* from a_user where user_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				userVO vo = new userVO();
				vo.setUser_no(rs.getInt("userNo"));
				
				lst.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lst;
	}

}