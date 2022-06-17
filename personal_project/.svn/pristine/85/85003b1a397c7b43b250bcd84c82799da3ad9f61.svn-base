package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Reply;
import utils.DBConn;

public class ReplyDao {
	private static ReplyDao replydao = new ReplyDao();
	
	public static ReplyDao getInstance() {
		return replydao;
	}
	
	private ReplyDao() {}
	
	public List<Reply> list(Long bno) {
		List<Reply> list = new ArrayList<Reply>();
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "SELECT * FROM TBL_REPLY WHERE BNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, bno);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int idx = 1;
				Reply reply = new Reply(rs.getLong(idx++), rs.getString(idx++), 
						rs.getString(idx++), rs.getLong(idx++), rs.getString(idx++));
				list.add(reply);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void register(Reply reply) {
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "INSERT INTO TBL_REPLY (RNO, CONTENT, BNO, WRITER)"
					+ " VALUES (SEQ_REPLY.NEXTVAL, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reply.getContent());
			pstmt.setLong(2, reply.getBno());
			pstmt.setString(3, reply.getWriter());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Reply get(Long rno) {
		Reply reply = null;
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "SELECT RNO, CONTENT, \r\n" + 
					"CASE\r\n" + 
					"    WHEN SYSDATE - REGDATE > 1 THEN TO_CHAR(REGDATE, 'YY/MM/DD')\r\n" + 
					"    ELSE TO_CHAR(REGDATE, 'HH24:MI:SS')\r\n" + 
					"END REGDATE,\r\n" + 
					"WRITER FROM TBL_REPLY WHERE RNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, rno);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int idx = 1;
				reply = new Reply(rs.getLong(idx++), rs.getString(idx++),
						rs.getString(idx++), null, rs.getString(idx++));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reply;
	}
	
	public void modify(Reply reply) {
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "UPDATE TBL_REPLY SET\r\n" + 
					"CONTENT = ?,\r\n" + 
					"REGDATE = SYSDATE\r\n" + 
					"WHERE RNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reply.getContent());
			pstmt.setLong(2, reply.getRno());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remove(Long rno) {
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "DELETE TBL_REPLY\r\n" + 
					"WHERE RNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, rno);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void modifyNullByWriter(String writer) {
		try {
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "UPDATE TBL_REPLY SET\r\n" + 
					"WRITER = NULL\r\n" + 
					"WHERE WRITER = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 파라미터 바인딩
			pstmt.setString(1, writer);
			
			// 문장 실행(반영)
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeAll(Long bno) {
		try {
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "DELETE TBL_REPLY\r\n" + 
					"WHERE BNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 파라미터 바인딩
			pstmt.setLong(1, bno);
			
			// 문장 실행(반영)
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
