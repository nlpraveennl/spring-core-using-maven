package com.pvn.event;

import org.springframework.context.ApplicationEvent;

public class ColourFillingEvent extends ApplicationEvent
{

	private static final long serialVersionUID = -653067246955013069L;

	public ColourFillingEvent(Object source)
	{
		super(source);
	}

}
