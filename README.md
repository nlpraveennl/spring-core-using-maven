# spring-core-using-maven
spring-core using maven(IDE used - Eclipse)

This repository contains maven projects to understand concept of spring-core and the highlights of all projects in this repository is given below.

#### 1. Setter based dependency injection.
ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
Triangle triangle=(Triangle)context.getBean("triangle");
```xml
<bean id="pointA" class="com.pvn.Point" scope="prototype">
	<property name="pointX" value="0" />
	<property name="pointY" value="0" />
</bean>
	
<bean id="triangle" class="com.pvn.Triangle">
	<property name="pointA" ref="pointA" />
	<property name="pointB" ref="pointB" />
	<property name="pointC" ref="pointC" />
</bean>
```
		
#### 2. Constructor based DI
```xml
<bean id="pointA" class="com.pvn.Point" >
	<constructor-arg name="pointX" value="0" />
	<constructor-arg name="pointY" value="-1" />
</bean>
```

#### 3. Reading values from properties file
```xml
<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
	<property name="locations" value="shapevalue.properties" />
</bean>

<property name="pointX" value="${pointA.X}" />
```

#### 4. Bean scopes
prototype, singleton(default), request, session
```xml
<bean id="pointA2" class="com.pvn.Point" scope="prototype">
```
	
#### 5. BeanNameAware
```java
public class Point implements BeanNameAware
{
	@Override
	public void setBeanName(String beanName) {
		this.beanName=beanName;
	}
}
```

#### 6. Inheritance of property values
```xml
<bean id="XatZero" class="com.pvn.Point" abstract="true">
	<property name="pointX" value="10" />
</bean>

<bean id="pointA" class="com.pvn.Point" parent="XatZero">
	<property name="pointY" value="${pointA.Y}" />
</bean>
```

#### 7. Bean definition inheritance in collection
```xml
<bean id="parenttriangle" class="com.pvn.Triangle">
	<property name="points">
		<list>
			<ref bean="pointA"/>
		</list>
	</property>
</bean>

<bean id="triangle" class="com.pvn.Triangle" parent="parenttriangle" >
	<property name="points">
		<list merge="true">
			<ref bean="pointB"/>
			<ref bean="pointC"/>
		</list>
	</property>
</bean>
```
```java
public class Triangle
{
	private Collection<Point> points;
}
```

#### 8. Spring life cycle callbacks
```java
public class Point implements InitializingBean, DisposableBean, BeanNameAware
{
	@Override
	public void afterPropertiesSet() throws Exception
	{
		System.out.println("after Intializing point " + getBeanName());
	}
	@Override
	public void destroy() throws Exception
	{
		System.out.println("before Destroying point " + getBeanName());
	}
	@Override
	public void setBeanName(String beanName)
	{
		this.beanName = beanName+"----";
	}
}
```

```xml
<bean id="pointA" class="com.pvn.Point" init-method="initializePoint" destroy-method="destroyPoint">
```

//Equivalent annotations for spring life cycle call backs by custom methods

```java
@PostConstruct
public void initializePoint(){
	System.out.println("CUSTOM METHOD initializePoint for "+getBeanName());
}
@PreDestroy
public void destroyPoint(){
	System.out.println("CUSTOM METHOD destroyPoint for "+getBeanName());
}
```

#### 9. Bean post processor
```xml
<bean class="com.pvn.DisplayNameBeanPostProcessor" />
```
```java
public class DisplayNameBeanPostProcessor implements BeanPostProcessor 
{
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) 
	throws BeansException {
		if(bean instanceof Point)
		{}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) 
	throws BeansException {
		if(bean instanceof Point)
		{}
		return bean;
	}
}
```

#### 10. BeanFactoryPostProcessor
```java
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor 
{
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException 
{}
}
```
#### 11. Coding to interface
For classes Circle and Triangle create interface Shape and create abstract method draw();
Implement draw method in both classes. Up cast bean instance to interface and call interface method.
```java
Shape shape=(Shape)context.getBean("circle");
shape.draw();
```

If multiple bean is defined for Point class but during auto wiring point to circle center qualifier should be used in bean definition and @Qualifier for setCenter to intimate for injecting bean value.
```xml
<qualifier value="circleRelated"/>
```

```java
@Autowired
@Qualifier("circleRelated")
public void setCenter(Point center)
```

#### 12. Required annotation
```xml
<bean class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor" />
```
```java
public class Circle implements Shape
{
	private Point center;

	//Spring container will fail to load if center dependency is not defined in spring XML
	@Required
	public void setCenter(Point center) {
		this.center = center;
	}
}
```



#### 13. @Component @Resource @Autowire
```xml
<context:component-scan base-package="com.pvn"/>
<context:annotation-config />

<!-- removed by @Component -->
<bean id="triangle" class="com.pvn.Triangle">
<!-- removed by @Autowired -->
	<property name="pointA" ref="pointA" />
	<property name="pointB" ref="pointB" />
	<property name="pointC" ref="pointC" />
</bean>
```

```java
@Component
public class Triangle implements Shape
{
	private Point pointA;
	private Point pointB;
	private Point pointC;

	@Resource	//or @Resource
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	@Resource	
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	@Autowired
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	//getters
	
	@Override
	public void draw()
	{}
}
```
