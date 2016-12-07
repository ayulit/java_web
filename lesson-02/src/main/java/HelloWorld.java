
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class HelloWorld
 */

public class HelloWorld extends HttpServlet {
	
	private ApplicationContext ctx;

    public void init(ServletConfig config) throws ServletException {
    	this.ctx = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
    }
        
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		this.process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		this.process(request, response);
	}
	
    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

    	response.setContentType("text/html;charset=UTF-8");    	
		LocaleContextHolder.setLocale(request.getLocale());
    	    	
    	response.setStatus(200);
        PrintWriter writer = response.getWriter();
                        
        MessageRenderer mr = ctx.getBean("renderer",MessageRenderer.class);
        mr.printMessage(writer);
                
    }

}
