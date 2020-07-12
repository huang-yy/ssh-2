package com.atguigu.ssh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atguigu.ssh.dao.DepartmentDao;
import com.atguigu.ssh.entities.Department;
@Service("departmentService")
public class DepartmentService {
	
	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	public List<Department> getAll(){
		return departmentDao.getAll();
	}
	
}