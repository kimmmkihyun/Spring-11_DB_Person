package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.command.PCommand;
import com.spring.ex.dao.PDao;

public class PDeleteCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request) {
		
		int num =Integer.parseInt(request.getParameter("num"));
		
		PDao dao = PDao.getInstance();
		dao.deleteByNum(num);
		
	}
}
	
