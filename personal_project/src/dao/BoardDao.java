package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Board;
import domain.Criteria;
import domain.Member;
import domain.Package;
import utils.DBConn;

public class BoardDao {
	
	private static BoardDao boardDao = new BoardDao();
	
	private BoardDao() {}
	
	public static BoardDao getInstance() {
		return boardDao;
	}
	
	
	public List<Board> list(Criteria cri) {
		List<Board> list = new ArrayList<Board>();
		
		try {
			Connection conn = DBConn.getConnection();
			
			//문장생성
			
			String sql = "SELECT * FROM (\r\n" + 
					"SELECT\r\n" + 
					"    /*+ INDEX_DESC(TBL_BOARD PK_BOARD) */\r\n" + 
					"    BNO,\r\n" + 
					"    TITLE,\r\n" + 
					"    CONTENT,\r\n" + 
					"    HITCOUNT,\r\n" + 
					"    CASE\r\n" + 
					"        WHEN SYSDATE - REGDATE > 1 THEN TO_CHAR(REGDATE, 'YY/MM/DD')\r\n" + 
					"        ELSE TO_CHAR(REGDATE, 'HH24:MI:SS')\r\n" + 
					"    END REGDATE,\r\n" + 
					"    WRITER,\r\n" + 
					"    ROWNUM RN\r\n" + 
					"FROM TBL_BOARD\r\n" + 
					"WHERE CATEGORY = ?\r\n" + 
					"AND ROWNUM <= ?\r\n" + 
					")\r\n" + 
					"WHERE RN > ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getCategory());
			pstmt.setInt(2, cri.getPageNum() * cri.getAmount());
			pstmt.setInt(3, (cri.getPageNum()-1) * cri.getAmount());
			
			//결과집합
			ResultSet rs = pstmt.executeQuery();
			
			//바인딩
			while(rs.next()) {
				int idx2 = 1;
				Board board = new Board(rs.getLong(idx2++), rs.getString(idx2++), rs.getString(idx2++), 
						rs.getInt(idx2++), rs.getString(idx2++), rs.getString(idx2++), rs.getInt(idx2++));
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public Board get(Long bno) {
		Board board = null;
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "UPDATE TBL_BOARD SET\r\n" + 
					"HITCOUNT = HITCOUNT + 1\r\n" + 
					"WHERE BNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, bno);
			
			pstmt.executeQuery();
			
			sql = "SELECT TITLE, CONTENT, \r\n" + 
					"CASE\r\n" + 
					"WHEN SYSDATE - REGDATE > 1 THEN TO_CHAR(REGDATE, 'YY/MM/DD')\r\n" + 
					"ELSE TO_CHAR(REGDATE, 'HH24:MI:SS')\r\n" + 
					"END REGDATE\r\n" + 
					", WRITER, CATEGORY FROM TBL_BOARD WHERE BNO = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, bno);
			
			//결과집합
			ResultSet rs = pstmt.executeQuery();
			
			//바인딩
			while(rs.next()) {
				int idx2 = 1;
				board = new Board(bno, rs.getString(idx2++), rs.getString(idx2++),
						0, rs.getString(idx2++), rs.getString(idx2++), rs.getInt(idx2++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}
	
	public int count(Criteria cri) { // 게시 글 개수 가져오는 메서드
		int count = 0;
		try {
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "SELECT COUNT(*) FROM TBL_BOARD WHERE CATEGORY = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getCategory());
			
			// 결과집합 생성
			ResultSet rs = pstmt.executeQuery();
			
			// 결과집합 순회 후 데이터 바인딩
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public void register(Board board) {
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "SELECT SEQ_BOARD.NEXTVAL FROM DUAL";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			board.setBno(rs.getLong(1));
			
			//문장생성
			
			sql = "INSERT INTO TBL_BOARD VALUES"
					+ "(?, ?, ?, 0, SYSDATE, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			int idx = 1;
			
			pstmt.setLong(idx++, board.getBno());
			pstmt.setString(idx++, board.getTitle());
			pstmt.setString(idx++, board.getContent());
			pstmt.setString(idx++, board.getWriter());
			pstmt.setInt(idx++, board.getCategory());
			
			pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void modify(Board board) {
		try {
			Connection conn = DBConn.getConnection();
			
			//문장생성
			
			String sql = "UPDATE TBL_BOARD SET\r\n" + 
					"TITLE = ?,\r\n" + 
					"CONTENT = ?,\r\n" + 
					"REGDATE = SYSDATE WHERE BNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int idx = 1;
			pstmt.setString(idx++, board.getTitle());
			pstmt.setString(idx++, board.getContent());
			pstmt.setLong(idx++, board.getBno());
			
			
			pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void remove(Long bno) {
		try {
			Connection conn = DBConn.getConnection();
			
			//문장생성
			
			String sql = "DELETE TBL_BOARD WHERE BNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int idx = 1;
			pstmt.setLong(idx++, bno);
			
			
			pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Board> whenever() {
		List<Board> boards = new ArrayList<>();
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "SELECT * FROM TBL_BOARD\r\n" + 
					"WHERE CATEGORY = 5 AND ROWNUM < 5\r\n" + 
					"ORDER BY HITCOUNT DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int idx = 1;
				Board board = new Board(rs.getLong(idx++), rs.getString(idx++), rs.getString(idx++),
						rs.getInt(idx++), rs.getString(idx++), rs.getString(idx++), rs.getInt(idx++), null);
				boards.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boards;
	}

	public Package getPackInfo(Long bno) {
		Package pack = null;
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "SELECT PNO, BNO, CITY, TIME, REFUND, PRICE FROM TBL_PACKAGE WHERE BNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, bno);
			
			//결과집합
			ResultSet rs = pstmt.executeQuery();
			
			//바인딩
			while(rs.next()) {
				int idx = 1;
				pack = new Package(rs.getLong(idx++), rs.getLong(idx++), rs.getString(idx++),
						rs.getString(idx++), rs.getString(idx++), rs.getLong(idx++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pack;
	}
	public void setPackInfo(Package pack) {
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "SELECT SEQ_PACKAGE.NEXTVAL FROM DUAL";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			pack.setPno(rs.getLong(1));
			
			//문장생성
			
			sql = "INSERT INTO TBL_PACKAGE (BNO, PNO, CITY, TIME, REFUND, PRICE) VALUES"
					+ "(?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			int idx = 1;
			
			pstmt.setLong(idx++, pack.getBno());
			pstmt.setLong(idx++, pack.getPno());
			pstmt.setString(idx++, pack.getCity());
			pstmt.setString(idx++, pack.getTime());
			pstmt.setString(idx++, pack.getRefund());
			pstmt.setLong(idx++, pack.getPrice());
			
			pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void modifyNullByWriter(String writer) {
		try {
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "UPDATE TBL_BOARD SET\r\n" + 
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
}
