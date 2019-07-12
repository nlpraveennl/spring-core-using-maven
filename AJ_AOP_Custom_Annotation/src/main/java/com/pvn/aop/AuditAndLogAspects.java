package com.pvn.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.pvn.di.setterbased.Shape;

@Component
@Aspect
public class AuditAndLogAspects
{
	@Around("@annotation(com.pvn.aop.AuditThis)")
	public void doAudit(ProceedingJoinPoint proceedingJoinPoint)
	{
		try 
		{
			String objectBefore = ((Shape)proceedingJoinPoint.getTarget()).getMessage();
			proceedingJoinPoint.proceed();
			String objectAfter = ((Shape)proceedingJoinPoint.getTarget()).getMessage();
			System.out.println(objectBefore +" Modified to >> "+ objectAfter);
		}
		catch (Throwable e)
		{}
		finally
		{}
	}
	
	@Around("@annotation(com.pvn.aop.LogThis)")
	public void addLog(ProceedingJoinPoint proceedingJoinPoint)
	{
		try 
		{
			proceedingJoinPoint.proceed();
			Shape shape = (Shape)proceedingJoinPoint.getTarget();
			System.out.println(proceedingJoinPoint.toShortString()+", bean name: "+shape.getBeanName() +", msg: "+shape.getMessage());
		}
		catch (Throwable e)
		{}
		finally
		{}
	}
}
