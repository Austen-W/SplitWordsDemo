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
 
   
  //�����û�֮��ͨ��ֱ��������������ַ�������servlet  
    protected void doGet(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
     	String encoding = "UTF-8";// �ַ�����
		request.setCharacterEncoding(encoding);// �������
		response.setContentType("text/html;charset=" + encoding);// ��Ӧ����
 
		PrintWriter out = response.getWriter();
		String text = request.getParameter("javaText");
		System.out.println(text);
		text = URLDecoder.decode(text,"UTF-8");
		System.out.println(text);
	
		DivideWord dw=new DivideWord();//���÷ִ�
		String responseText = dw.divide(text, 5);//�������ƥ��
		
		out.println(responseText);
		out.close();

    }  
  
    protected void doPost(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {
    	
    	doGet(request, response);
    }  

    
}
