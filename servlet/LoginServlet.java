package servlet;

import java.io.*;

import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.*;
import javax.servlet.http.*;

import cn.strong.DivideWord;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }
 
   
  //放置用户之间通过直接在浏览器输入地址访问这个servlet  
    protected void doGet(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
     	String encoding = "UTF-8";// 字符编码
		request.setCharacterEncoding(encoding);// 请求编码
		response.setContentType("text/html;charset=" + encoding);// 响应编码
 
		PrintWriter out = response.getWriter();
		String text = request.getParameter("javaText");
		System.out.println(text);
		text = URLDecoder.decode(text,"UTF-8");
		System.out.println(text);
	
		DivideWord dw=new DivideWord();//调用分词
		String responseText = dw.divide(text, 5);//最大正向匹配
		
		out.println(responseText);
		out.close();

    }  
  
    protected void doPost(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {
    	
    	doGet(request, response);
    }  

    
}
