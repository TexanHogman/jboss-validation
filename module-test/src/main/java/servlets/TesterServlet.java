package servlets;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hogdev.play.Foo;

@WebServlet({ "/doit" })
public class TesterServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private @Inject
	Foo foo;
	
	@PostConstruct
	private void myInit()
	{
		System.out.println("Servlet POST CONSTRUCT");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TesterServlet()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("If you see this, I guess things worked --- here is the output though: " + foo.foos());
	}

}
