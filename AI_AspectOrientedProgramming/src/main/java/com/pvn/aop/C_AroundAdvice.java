package com.pvn.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class C_AroundAdvice
{

	@Before(value = "execution(public void com.pvn.di.setterbased.Circle.fill())")
	public void beforeCircleFilling() throws Throwable
	{
		System.out.println("@Before: Before circle Filling");
	}

	@After(value = "execution(public void com.pvn.di.setterbased.Circle.fill())")
	public void afterCircleFilling() throws Throwable
	{
		System.out.println("@After: After circle Filling");
	}

	@Around(value = "execution(public void com.pvn.di.setterbased.Circle.fill())")
	public void circleDraw(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		System.out.println("@Around advice: Before Drawing");
		proceedingJoinPoint.proceed();
		System.out.println("@Around advice: After Drawing");
	}

	@AfterReturning(value = "execution(public void com.pvn.di.setterbased.Circle.draw())")
	public void afterReturningCircleDrawing() throws Throwable
	{
		System.out.println("@AfterReturning: After circle Drawing");
	}

	@AfterReturning(pointcut="args(fn,ln)",returning="fullName")
	public void returnFullName(String fn, String ln, String fullName)
	{
		System.out.println(fn + " + " + ln + " ==> " + fullName);
	}
	
	@AfterThrowing(pointcut="args(fn,ln)",throwing="ex")
	public void fullNameError(String fn,String ln,Throwable ex)
	{
		System.out.println("Advice Run. @AfterThrowing advice with throwable arg : "+ex);
	}
}
