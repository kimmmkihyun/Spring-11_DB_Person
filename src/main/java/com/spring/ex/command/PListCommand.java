package com.spring.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PDao;
import com.spring.ex.dto.PDto;

public class PListCommand implements PCommand{

	
	@Override
	public void execute(HttpServletRequest request) {
		
		PDao dao = PDao.getInstance();
		ArrayList<PDto> lists = dao.list();
		
		request.setAttribute("lists", lists);  //request 속성 설정한거를 넘겨야 한다!!!!!
	}

}
