package com.pvn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Praveen
 * (*) one or any arguments
 * (..) zero or any arguments  <-- Supermost condition
 * () No arguments
 */

//@Component
//@Aspect
public class B_PointCutExecution
{

	@Before(value = "circleDraw() || triangleDraw()")
	public void adviceRun(JoinPoint joinPoint)
	{
		System.out.println(joinPoint.getKind() + " -- " + joinPoint.getSignature());
	}

//	@Pointcut("execution(public void com.pvn.di.setterbased.Circle.draw())")
//	@Pointcut("execution(public void com.pvn.di.setterbased.Circle.*())")
//	@Pointcut("execution(public void com.pvn.di.setterbased.*.*())")
	@Pointcut("execution(public * com.pvn.di.setterbased.*.*(..))")
	public void circleDraw()
	{
	}

	@Pointcut("execution(public void com.pvn.di.setterbased.Triangle.draw())")
	public void triangleDraw()
	{
	}
}

