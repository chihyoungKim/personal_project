package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Board;
import domain.Member;
import utils.DBConn;

public class MemberDao {
	
	private static final MemberDao memberDao = new MemberDao();
	
	private MemberDao() {}
	
	public static MemberDao getInstance() {
		return memberDao;
	}
	
	
	//로그인
	public Member login(String id, String pw) {
		Member member = null;
		
		try {
			Connection conn = DBConn.getConnection();
			
			//문장생성
			
			String sql = "SELECT * FROM TBL_MEMBER WHERE ID = ? AND PW = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int idx = 1;
			pstmt.setString(idx++, id.trim());//공백제거
			pstmt.setString(idx++, pw.trim());
			
			//결과집합
			ResultSet rs = pstmt.executeQuery();
			
			//바인딩
			while(rs.next()) {
				int idx2 = 1;
				member = new Member(rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++),
						rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++)
						, rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++),
						rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	
	//회원가입
	public void register(Member member) {
		
		try {
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "{call PROC_INSERT_MEMBER(?,?,?,?,?,?,?,?,?,?,?,?)}";
			
			
//			PreparedStatement pstmt = conn.prepareStatement(sql);
			CallableStatement cstmt = conn.prepareCall(sql);
			
			// 파라미터 바인딩
			int idx = 1;
			cstmt.setString(idx++, member.getId());
			cstmt.setString(idx++, member.getPw());
			cstmt.setString(idx++, member.getName());
			
			cstmt.setString(idx++, member.getSi());
			cstmt.setString(idx++, member.getSgg());
			cstmt.setString(idx++, member.getEmd());
			cstmt.setString(idx++, member.getRoadAddr());
			cstmt.setString(idx++, member.getAddrDetail());
			cstmt.setString(idx++, member.getZipNo());
			cstmt.setString(idx++, member.getRoadFullAddr());
			cstmt.setString(idx++, member.getJibunAddr());
			
			cstmt.setString(idx++, member.getEmail());
			
			
			// 문장 실행(반영)
			cstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void remove(String id) {
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "DELETE TBL_MEMBER WHERE ID = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int idx = 1;
			pstmt.setString(idx++, id);
			
			pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Member get(String id) {
		Member member = null;
		try {
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "SELECT * FROM TBL_MEMBER\r\n" + 
					"WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setString(idx++, id.trim().toLowerCase());
			
			// 결과집합 생성
			ResultSet rs = pstmt.executeQuery();
			
			// 결과집합 순회 후 데이터 바인딩
			while(rs.next()) {
				int idx2 = 1;
				member = new Member(rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++),
						rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++)
						, rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++),
						rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public Member findBy(String email) {
		Member member = null;
		try {
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "SELECT * FROM TBL_MEMBER\r\n" + 
					"WHERE EMAIL = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setString(idx++, email.trim().toLowerCase());
			
			// 결과집합 생성
			ResultSet rs = pstmt.executeQuery();
			
			// 결과집합 순회 후 데이터 바인딩
			while(rs.next()) {
				int idx2 = 1;
				member = new Member(rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++),
						rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++)
						, rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++),
						rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	public void modify(Member member) {
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "{call MODIFY_MEMBER_PROC(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			int idx = 1;
			cstmt.setString(idx++, member.getId());
			cstmt.setString(idx++, member.getPw());
			cstmt.setString(idx++, member.getName());
			cstmt.setString(idx++, member.getSi());
			cstmt.setString(idx++, member.getSgg());
			cstmt.setString(idx++, member.getEmd());
			cstmt.setString(idx++, member.getRoadAddr());
			cstmt.setString(idx++, member.getAddrDetail());
			cstmt.setString(idx++, member.getZipNo());
			cstmt.setString(idx++, member.getRoadFullAddr());
			cstmt.setString(idx++, member.getJibunAddr());
			cstmt.setString(idx++, member.getEmail());
			
			cstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateAuth(Member member) {
		Connection conn;
		try {
			conn = DBConn.getConnection();
			String sql = "{call UPDATEAUTH_PROC(?, ?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, member.getId());
			cstmt.setString(2, member.getAuth());
			
			cstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void updateAuthToken(Member member) {
		Connection conn;
		try {
			conn = DBConn.getConnection();
			String sql = "{call UPDATEAUTHTOKEN_PROC(?, ?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, member.getId());
			cstmt.setString(2, member.getAuthToken());
			
			cstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
