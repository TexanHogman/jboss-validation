package org.hogdev.play;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.hogdev.play.Bar;

public class Foo
{
	@Inject Bar bar;
	
	public String foos()
	{
		return "foo was here but was bar, let's see: " + bar.bars();
	}

	@PostConstruct
	public void init()
	{
		System.out.println("FOO POST CONSTRUCT");
	}

	public Foo()
	{
		super();
	}
	
}
