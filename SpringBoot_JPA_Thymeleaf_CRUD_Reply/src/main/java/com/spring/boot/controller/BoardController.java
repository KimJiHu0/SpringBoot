package com.spring.boot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.boot.dao.BoardDao;
import com.spring.boot.dao.BoardReplyDao;
import com.spring.boot.dto.BoardListDto;
import com.spring.boot.dto.BoardReplyDto;

@Controller
public class BoardController {

	// JPADao interface의 값과 연결?해준다는 의미로 생각하고 있습니다.
	// 이를 작성하지 않으면 연결고리가 끊겨서 List를 출력할 수 없습니다.
	@Autowired
	private BoardDao boarddao;

	@Autowired
	private BoardReplyDao replydao;

	// list.do라는 요청이 들어오게 되면 해당 Method와 연결됩니다.
	@GetMapping("/list.do")
	public String boardList(Model model) {

		// model이라는 객체에 list라는 이름으로 dao에 있는 findAll Method의 return값을 담아서
		// board Folder 밑에 있는 boardList.html에 보내집니다.
		model.addAttribute("list", boarddao.findAll());

		return "/board/boardList";
	}

	// 글작성을 누르면 insert.do라는 요청값이 들어오게 되고, 이를 연결해주는 GetMapping을 통해서
	// 해당 Method와 연결해줍니다.
	@GetMapping("insert.do")
	public String insertForm() {
		return "/board/boardInsert";
	}

	// 작성완료를 누르면 insertres.do라는 요청값이 들어오게 되고, 이를 연결해주는 PostMapping을
	// 통해서 해당 MetHod와 연결해줍니다.
	@PostMapping("insertres.do")
	public String insertRes(BoardListDto dto) {

		// 아주 잘 들어옵니다.
		System.out.println(dto.getBoardname());
		System.out.println(dto.getBoardtitle());
		System.out.println(dto.getBoardcontent());

		boarddao.save(dto);

		return "redirect:/list.do";
	}

	// boardList.html에서 제목을 하나 클릭하게 되면 넘어오는 요청값 detail.do를
	// GetMapping을 통해서 해당 Method와 연결해줍니다.
	@GetMapping("detail.do")
	public String boardDetail(Model model, int boardno) {

		BoardListDto dto = boarddao.findByBoardno(boardno);
		model.addAttribute("dto", dto);

		System.out.println("해당 글에대한 번호 : " + boardno);

		// 댓글들 전부 나옴

		// 우선 모든 댓글들을 다 뽑아줍니다.
		List<BoardReplyDto> AllReply = replydao.findAll();

		// 그리고 진짜 원하는 댓글만 담아줄 List를 선언합니다.
		List<BoardReplyDto> reply = new ArrayList<BoardReplyDto>();

		// 이제 모든 댓글의 길이만큼 반복문들 돌아주면서
		for (int i = 0; i < AllReply.size(); i++) {
			// SQL의 조건문을 여기서 처리합니다.
			// 모든 댓글의 BOARDNO중에서 내가 들어온 DETAIL의 BOARDNO와 동일한 애들만
			// 새로운 List에 담아줍니다.
			if (AllReply.get(i).getBoardlistdto().getBoardno() == boardno) {
				reply.add(AllReply.get(i));
			}
		}
		// 그리고 이를 model객체에 담아서 html로 보내줍니다.
		model.addAttribute("reply", reply);

		return "/board/boardDetail";
	}

	// 상세보기에서 수정버튼을 클릭하게 되면 요청값 update.do를 통해서
	// 해당 Method와 연결해줍니다.
	// 같이 보내준 파라미터를 받아줍니다.
	@GetMapping("update.do")
	public String updatForm(Model model, int boardno) {

		// 하나의 dto를 다시 보여줘야하기 때문에 findByBoardno 메소드를 다시 호출하여
		// boardUpdate.html에 보내줍니다.
		BoardListDto dto = boarddao.findByBoardno(boardno);
		model.addAttribute("dto", dto);

		return "/board/boardUpdate";
	}

	// boardUpdate.html에서 수정완료 버튼을 클릭하면 넘어오는 요청값 updateres.do를 통해서
	// 해당 Method와 연결해줍니다.
	@PostMapping("updateres.do")
	public String updateRes(BoardListDto dto, Model model) {

		BoardListDto res = boarddao.save(dto);

		// 수정에 성공했다면
		if (res != null) {
			model.addAttribute("dto", boarddao.findByBoardno(dto.getBoardno()));
			return "redirect:/detail.do?boardno=" + dto.getBoardno();
		}
		// 실패했다면
		else {
			return "redirect:/update.do?boardno=" + dto.getBoardno();
		}
	}

	@GetMapping("delete.do")
	public String delete(int boardno) {

		// 삭제를 실행합니다.
		boarddao.deleteByBoardno(boardno);

		return "redirect:/list.do";

	}
}
