package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.command.PCommand;
import com.spring.ex.dao.PDao;
import com.spring.ex.dto.PDto;


public class PContentCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request) {
		
		String num = request.getParameter("num");
		
		PDao dao = PDao.getInstance();
		PDto dto = dao.oneSelect(num);
		
		request.setAttribute("dto", dto);
		//model.addAttribute
	}

}
