package com.atguigu.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.ssh.dao.EmployeeDao;
import com.atguigu.ssh.entities.Employee;


@Transactional
@Service("employeeService")
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public boolean lastNameIsValid(String lastName){
		return employeeDao.getEmployeeByLastName(lastName) == null;
	}
	
	public void saveOrUpdate(Employee employee){
		employeeDao.saveOrUpdate(employee);
	}
	
	public void delete(Integer id){
		employeeDao.delete(id);
	}
	
	public List<Employee> getAll(){
		System.out.println("employeeDao=======" + employeeDao);
		List<Employee> employees = employeeDao.getAll();
		return employees;
	}

	public Employee get(Integer id) {
		return employeeDao.get(id);
	}
	
}
