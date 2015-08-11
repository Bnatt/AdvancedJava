package com.bhuvana;

import java.io.IOException;

import java.util.Date;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ConcatTagHandler extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	public int doStartTag(){
		
		JspWriter out = pageContext.getOut();
		try {
			out.println(new Date());
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return SKIP_BODY;
	}
	

}
