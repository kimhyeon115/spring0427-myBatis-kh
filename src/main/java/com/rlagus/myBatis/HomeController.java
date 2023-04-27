package com.rlagus.myBatis;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rlagus.myBatis.dao.IDao;
import com.rlagus.myBatis.dto.BoardDto;

@Controller
public class HomeController {
	
	@Autowired
	private SqlSession sqlSession;						// sqlSession 빈이 컨테이너에서 자동 주입
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);		
		ArrayList<BoardDto> dtos = dao.listDao();
		
		model.addAttribute("list", dtos);
//		model.addAttribute("total", dtos.size());		// 리스트내 레코드 개수가 곧 데이터 개수
		int total = dao.totalCount();					// 메소드 생성하여 쿼리문 사용방법
		model.addAttribute("total", total);
		
		return "list";
	}
	
	@RequestMapping(value = "/write_form")
	public String write_form() {
		return "writeForm";
	}
	
	@RequestMapping(value = "/write")
	public String write(HttpServletRequest request) {
		String mwriter = request.getParameter("mwriter");
		String mcontent = request.getParameter("mcontent");
		
		IDao dao = sqlSession.getMapper(IDao.class);	// 객체생성이 아닌 기존객체 주입시키는 개념
		dao.writeDao(mwriter, mcontent);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request) {
		String mid = request.getParameter("mid");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteDao(mid);
		
		return "redirect:list";
	}
}
