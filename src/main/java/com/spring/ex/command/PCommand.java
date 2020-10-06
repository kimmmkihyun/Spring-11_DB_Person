package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

public interface PCommand {
	
	void execute(HttpServletRequest request);
}
