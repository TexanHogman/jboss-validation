package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.hogdev.play.Foo;

@WebServlet({ "/doit" })
public class TesterServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private @Inject
	Foo foo;
	
	//tried quickly to use @Resource but ran into some issue so I'll just  get it in the PostConstruct
//	@Resource(mappedName="java:jboss/datasources/MyDS")
	private DataSource dataSource;

	@PostConstruct
	private void myInit()
	{
		System.out.println("Servlet POST CONSTRUCT");
		
		try
		{
			InitialContext ic = new InitialContext();  // JNDI initial context
		    dataSource = (DataSource) ic.lookup("java:jboss/datasources/MyDS-55"); // JNDI lookup			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
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
		Connection conn = null;
		try
		{
			conn = dataSource.getConnection();
			System.out.println("RO [" + conn.hashCode() + "]: " + conn.isReadOnly());
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("If you see this, I guess things worked --- here is the output though: " + foo.foos());
	}

}
