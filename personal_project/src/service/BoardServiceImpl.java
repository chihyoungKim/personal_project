package service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dao.AttachDao;
import dao.BoardDao;
import dao.ReplyDao;
import domain.Attach;
import domain.Board;
import domain.Criteria;
import domain.Package;

public class BoardServiceImpl implements BoardService {
	
	private static final BoardService boardService = new BoardServiceImpl();
	
	private BoardServiceImpl() {}
	
	public static BoardService getInstance() {
		return boardService;
	}
	
	private BoardDao boardDao = BoardDao.getInstance();
	private AttachDao attachDao = AttachDao.getInstance();
	private ReplyDao replyDao = ReplyDao.getInstance();
	
	@Override
	public List<Board> list(Criteria cri) {
		List<Board> list = boardDao.list(cri);
		// 갤러리일 경우
		if(cri.getCategory() >= 3) {
			list.forEach(board->{
				List<Attach> attachList = attachDao.list(board.getBno());
				List<Attach> attachList2 =new ArrayList<>(); 
				for(Attach attach : attachList) {
					if(attach.isImage()) {
						attachList2.add(attach);
						break;
					}
				}
				board.setAttachs(attachList2);
			});
		}
		return list;
	}

	@Override
	public Board get(Long bno) {
		return boardDao.get(bno);
	}

	@Override
	public void register(Board board) {
		boardDao.register(board);
		for(Attach a : board.getAttachs()) {
			a.setBno(board.getBno());
			attachDao.insert(a);
		}
	}

	@Override
	public void modify(Board board) {
		boardDao.modify(board);
	}

	@Override
	public void remove(Long bno) {
		List<Attach> attachs = attachDao.list(bno);
		String saveDir = "C:\\upload";
		for(Attach attach : attachs) {
			File file = new File(saveDir, attach.getPath());
			System.out.println(file);
			file = new File(file, attach.getUuid());
			System.out.println(file);
			file.delete();
		}
		attachDao.remove(bno);
		
		replyDao.removeAll(bno);
		
		boardDao.remove(bno);
	}

	@Override
	public int count(Criteria cri) {
		return boardDao.count(cri);
	}

	@Override
	public List<Board> whenever() {
		List<Board> list = boardDao.whenever();
		for(Board b : list) {
			b.setAttachs(attachDao.list(b.getBno()));
		}
		return list;
	}

	@Override
	public Package getPackInfo(Long bno) {
		return boardDao.getPackInfo(bno);
	}

	@Override
	public void setPackInfo(Package pack) {
		boardDao.setPackInfo(pack);
	}
	
	
}
