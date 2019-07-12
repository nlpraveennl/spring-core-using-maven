package com.pvn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.pvn.di.setterbased.Shape;

//@Component
//@Aspect
public class A_PointCutWithinClassAndJoinPointMethods
{
	@Before(value = "getAllMethodsInCircle() || getAllMethodsInTriangle()")
	public void adviceRun(JoinPoint joinPoint)
	{
		System.out.println("kind: "+joinPoint.getKind());
		System.out.println("signature: "+joinPoint.getSignature());
		System.out.println("static part: "+joinPoint.getStaticPart());
		System.out.println(((Shape)joinPoint.getTarget()).getBeanName());
	}
	
//	@Pointcut("within(com.pvn.di.setterbased.*)")
	@Pointcut("within(com.pvn.di.setterbased.Circle)")
	public void getAllMethodsInCircle(){}
	
	@Pointcut("within(com.pvn.di.setterbased.Triangle)")
	public void getAllMethodsInTriangle(){}
}
