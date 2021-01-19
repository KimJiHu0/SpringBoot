package com.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.boot.biz.BoardBiz;
import com.spring.boot.dto.BoardDto;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private BoardBiz boardbiz;
	
	// localhost:3360 으로 접속했을 때 가장 먼저 나오는 페이지를 index로 지정하기 위해서 설정을 잡아주었다.
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	// index에서 List라는 Button을 누르게 되면 요청값 list.do를 통해서 들어오게 된다.
	// boardbiz를 autowired한 값을 통해서 mysql에 있는 테이블의 list를 mapper에서 뽑아오게 되고 이를 return한 값을
	// model객체에 담아서 board Folder안에 있는 boardlist를 찾아서 model객체와 함께 보내준다.
	@RequestMapping("list.do")
	public String List(Model model) {
		
		List<BoardDto> list = boardbiz.selectList();
		model.addAttribute("list", list);
		
		return "board/boardlist";
	}
	
	// boardlist.jsp에서 글작성을 누르면 요청값 insert.do를 통해서 들어오게 된다.
	// board Folder 밑에 있는 boardinsertForm.jsp를 찾아서 화면에 띄어주게 된다.
	@RequestMapping("insert.do")
	public String insertForm() {
		return "board/boardinsertForm";
	}
	
	// 작성완료를 누르면 아래의 메소드로 들어오게 된다.
	// 이제 name을 통해 넘어온 value들은 dto에 저장되게 된다.
	// 이를 가지고 insert를 통해 Table에 insert를 해준다.
	@RequestMapping("insertres.do")
	public String insertRes(BoardDto dto, Model model) {
		
		// insert하는 결과값을 res에 담아준다.
		// 성공하게되면 1이 담기고
		// 실패하게되면 0이 담긴다.
		int res = boardbiz.insertList(dto);
		
		// insert에 성공한다면
		if(res > 0) {
			// list를 보여주기 위해 list로 보내준다.
			return "redirect:/list.do";
		} else {
			return "redirect:/insert.do";
		}
	}
	
	// boardlist.jsp에서 제목을 클릭하게 되면 넘어오는 요청값 detail.do가 들어오는 메소드다.
	@RequestMapping("detail.do")
	public String detail(int boardno, Model model) {
		// 파라미터 값으로 같이 보낸 해당 글에 대한 boardno를 받았다.
		// dto의 값에 boardno를 파라미터로 보내어 selectOne을 실행했는데 biz에서 mapper를 실행해서 결과값을 가지고 와서
		// 해당 dto에 담아준다.
		BoardDto dto = boardbiz.selectOne(boardno);
		// 이를 다시 model객체에 dto라는 이름으로 dto를 담아서 detailForm.jsp로 보내주어 사용할 수 있게 만들어 주었다.
		model.addAttribute("dto", dto);
		
		return "board/detailForm";
	}
	
	// 수정페이지로 이동해주는데, 그 제목, 내용, 작성자 그대로 가져가야하기 때문에 selectOne의 것을 그대로 사용한다.
	@RequestMapping("update.do")
	public String updateForm(int boardno, Model model) {
		
		BoardDto dto = boardbiz.selectOne(boardno);
		model.addAttribute("dto", dto);
		
		return "board/updateForm";
	}
	
	// 수정 완료를 누르게 되면 아래의 메소드로 들어오게 된다.
	@RequestMapping("updateres.do")
	public String updateRes(BoardDto dto, Model model) {
		
		// 수정 한 값들을 name을 통해서 dto에 자동으로 담기게 되고, hidden값으로 보내준 boardno도 같이 보내준다.
		// res에 update의 결과값을 담아주고,
		// 성공은 1, 실패는 0을 담아준다.
		int res = boardbiz.UpdateList(dto);
		
		// 성공한다면
		if(res > 0) {
			// detail을 보여주고,
			return "redirect:/detail.do?boardno="+dto.getBoardno();
		// 실패한다면
		} else {
			// updateForm을 다시 보여준다.
			return "redirect:/update.do?boardno="+dto.getBoardno();
		}
	}
	
	// 삭제버튼을 누르게 되면 boardno를 보내게 된다.
	@RequestMapping("delete.do")
	public String delete(int boardno) {
		
		// boardno를 파라미터로 받는 deleteList라는 함수를 실행하게 되고, 실행 결과값을 int res에 담는다.
		int res = boardbiz.deleteList(boardno);
		
		// 성공한다면 1을 담아서, 
		if(res > 0) {
			// list를 보여주고,
			return "redirect:/list.do";
		// 실패한다면 0이 담아져서
		} else {
			// detail을 다시 보여준다.
			return "redirect:/detail.do?boardno="+boardno;
		}
	}
	
}
