package com.horace.primeFaces.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.horace.primeFaces.domain.Car;
import com.horace.primeFaces.service.CarService;

@ManagedBean(name = "carBean")
@SessionScoped
public class CarBean {
	private List<Car> cars;
	
	@ManagedProperty("#{carService}")
	private CarService carService;

	@PostConstruct
	public void init() {
		this.cars = carService.getCarPage();
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}
	
}
