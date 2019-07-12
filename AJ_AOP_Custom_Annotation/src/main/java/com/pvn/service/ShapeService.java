package com.pvn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvn.di.setterbased.Circle;
import com.pvn.di.setterbased.Triangle;

@Service
public class ShapeService {
	private Circle circle;
	private Triangle triangle;
	
	public Circle getCircle() {
		return circle;
	}
	@Autowired
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	@Autowired
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
}
