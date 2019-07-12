package com.pvn.event;

import org.springframework.context.ApplicationEvent;

public class DrawingEvent extends ApplicationEvent
{
	private static final long serialVersionUID = -6063681213400392145L;

	public DrawingEvent(Object source)
	{
		super(source);
	}
}
