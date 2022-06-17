package controller.board;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import domain.Attach;
import domain.Board;
import domain.Criteria;
import domain.Member;
import domain.Package;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import service.BoardService;
import service.BoardServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;
import utils.Const;
import utils.Util;

@WebServlet("/board/register")
public class Register extends HttpServlet{
	
	private BoardService boardService = BoardServiceImpl.getInstance();
	private MemberService memberService = MemberServiceImpl.getInstance(); 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Criteria cri = new Criteria();
		if(req.getParameter("pageNum") != null) {
			cri.setPageNum(Integer.parseInt(req.getParameter("pageNum")));
		}
		if(req.getParameter("amount") != null) {
			cri.setAmount(Integer.parseInt(req.getParameter("amount")));
		}
		if(req.getParameter("category") != null) {
			cri.setCategory(Integer.parseInt(req.getParameter("category")));
		}
		req.setAttribute("cri", cri);
		
		
		
		if(req.getSession().getAttribute("member") == null) {
			
			resp.sendRedirect(req.getContextPath() + "/member/login?link=" + req.getRequestURI() + "?" + URLEncoder.encode(req.getQueryString(), "utf-8"));
			return;
		}
		
		req.getRequestDispatcher(Const.board("register")).forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Criteria cri = new Criteria();
		
		Package pack = new Package();
		Board board = upload(req, cri, pack);
		Member member = (Member)req.getSession().getAttribute("member");
		board.setWriter(member.getId());
		boardService.register(board);
		pack.setBno(board.getBno());
		boardService.setPackInfo(pack);
		
		resp.sendRedirect("list" + cri.getParams2());
		
	}
	
	private Board upload(HttpServletRequest req, Criteria cri, Package pack) {
		Board board = new Board();
		String saveDir = "C:\\upload";
		int size = 10 * 1024 * 1024; //업로드 가용 최대 용량
		
		
		File currentDir = new File(saveDir);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDir);
		factory.setSizeThreshold(size);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(req);
			for (FileItem fi : items) {
				if(fi.isFormField()) {
					if(fi.getFieldName().equals("title")) {
						board.setTitle(fi.getString("utf-8"));
					}
					if(fi.getFieldName().equals("content")) {
						board.setContent(fi.getString("utf-8"));
					}
					if(fi.getFieldName().equals("writer")) {
						board.setWriter(fi.getString("utf-8"));
					}
					if(fi.getFieldName().equals("city")) {
						pack.setCity(fi.getString("utf-8"));
					}
					if(fi.getFieldName().equals("time")) {
						pack.setTime(fi.getString("utf-8"));
					}
					if(fi.getFieldName().equals("price")) {
						pack.setPrice(Long.parseLong(fi.getString("utf-8")));
					}
					if(fi.getFieldName().equals("refund")) {
						pack.setRefund(fi.getString("utf-8"));
					}
					if(fi.getFieldName().equals("amount")) {
						cri.setAmount(Integer.parseInt(fi.getString("utf-8")));
					}
					if(fi.getFieldName().equals("category")) {
						cri.setCategory(Integer.parseInt(fi.getString("utf-8")));
						board.setCategory(cri.getCategory());
					}
				}
				else {
					if(fi.getSize() == 0) {
						continue;
					}
					String origin = fi.getName();
					int idxDot = origin.lastIndexOf(".");
					String ext = "";
					if(idxDot != -1) {
						ext = origin.substring(idxDot);
					}
					
					UUID uuid = UUID.randomUUID();
					String name = uuid + ext; // uuid
					
					File upPath = new File(currentDir, getTodayStr());
					if(!upPath.exists()) {
						upPath.mkdirs();
					}
					fi.write(new File(upPath, name));
					Attach attach = new Attach(name, origin, getTodayStr());
					procImageType(attach, upPath, name);
					if(cri.getCategory() > 2 && cri.getCategory() < 6) {
						bigImageType(attach, upPath, name);
					}
					board.getAttachs().add(attach);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}
	
	private String getTodayStr() {
		return new SimpleDateFormat("yyyy/MM/dd").format(System.currentTimeMillis());
	}
	
	private void procImageType(Attach attach, File upPath, String name) {
		try {
			Thumbnails
				.of(new File(upPath, name))
				.sourceRegion(Positions.CENTER, 130, 90)
				.size(130, 90)
				.toFile(new File(upPath, "s_" + name));
			attach.setImage(true);
		} catch (IOException ignore) {	}
	}
	
	private void bigImageType(Attach attach, File upPath, String name) {
		try {
			Thumbnails
				.of(new File(upPath, name))
				.sourceRegion(Positions.CENTER, 700, 400)
				.size(700, 400)
				.toFile(new File(upPath, "b_" + name));
			attach.setImage(true);
		} catch (IOException ignore) {	}
	}
}
