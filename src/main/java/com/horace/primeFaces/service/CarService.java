package com.horace.primeFaces.service;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.horace.primeFaces.domain.Car;

@ManagedBean(name = "carService")
@ApplicationScoped
public class CarService {
	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate = null;

	{
		ctx = new ClassPathXmlApplicationContext("SpringMVC-servlet.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	}

	public List<Car> getCarPage() {
		String sql = "select * from car";
		RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
		List<Car> cars = jdbcTemplate.query(sql, rowMapper);
		System.out.println(cars.size());
		return cars;
	}
}
