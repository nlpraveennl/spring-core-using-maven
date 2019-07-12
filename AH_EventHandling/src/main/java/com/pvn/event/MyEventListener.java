package com.pvn.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.pvn.di.setterbased.Shape;

@Component
public class MyEventListener implements ApplicationListener<ApplicationEvent>
{

	@Override
	public void onApplicationEvent(ApplicationEvent event)
	{
		if (!(event instanceof ContextRefreshedEvent))
		{
			System.out.println("Event called on " + ((Shape) event.getSource()).getMessage());
		}
	}

}