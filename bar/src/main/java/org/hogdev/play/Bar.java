package org.hogdev.play;

import javax.annotation.PostConstruct;

public class Bar 
{
	public String bars()
	{
		return "bar was here new and improved";
	}
	
	@PostConstruct
	private void init()
	{
		System.out.println("BAR POST CONSTRUCT");
	}

	public Bar()
	{
		super();
	}
	
}
