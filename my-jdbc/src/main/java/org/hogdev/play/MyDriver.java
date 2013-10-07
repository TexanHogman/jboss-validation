package org.hogdev.play;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;

public class MyDriver implements Driver
{
	public MyDriver()
	{
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException
	{
		Connection conn = null;
		try
		{
			InitialContext ic = new InitialContext(); // JNDI initial context
			BeanManager bm = (BeanManager) ic.lookup("java:comp/BeanManager"); // JNDI lookup
			Set<Bean<?>> cdiBeans = bm.getBeans(MyConnection.class);
			if (!cdiBeans.isEmpty()) 
			{
				final Bean<?> bean = cdiBeans.iterator().next();
				CreationalContext<?> ctx = bm.createCreationalContext(bean);
				conn = (Connection) bm.getReference(bean, MyConnection.class, ctx);
			}
			else
				throw new SQLException("count not find CDI bean for Connection");
		}
		catch (Exception e)
		{
			throw new SQLException(e);
		}
		return conn;
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException
	{
		if (url.startsWith("jdbc:hogdev:"))
			return true;
		else
			return false;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException
	{
		return new DriverPropertyInfo[0];
	}

	@Override
	public int getMajorVersion()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinorVersion()
	{
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public boolean jdbcCompliant()
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
