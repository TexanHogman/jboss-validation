package org.hogdev.play;

import java.util.Map;
import java.util.Set;

import org.jboss.security.vault.SecurityVault;
import org.jboss.security.vault.SecurityVaultException;

public class MyVault implements SecurityVault
{
	@Override
	public void init(Map<String, Object> arg0) throws SecurityVaultException
	{
		// TODO we would take all the CustomHttpsHandler initProtectedPackage & setUpSSLResumption and implement it here.

	}

	@Override
	public char[] retrieve(String arg0, String arg1, byte[] arg2) throws SecurityVaultException
	{
		// TODO reach into protected utils and get password for now i will hard code to match ideal protected.
		return "passwordstg2".toCharArray();
	}

	// nothing special below
	
	@Override
	public boolean exists(String arg0, String arg1) throws SecurityVaultException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public byte[] handshake(Map<String, Object> arg0) throws SecurityVaultException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInitialized()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<String> keyList() throws SecurityVaultException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void store(String arg0, String arg1, char[] arg2, byte[] arg3) throws SecurityVaultException
	{
		// TODO Auto-generated method stub

	}
}
