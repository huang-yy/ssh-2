package com.atguigu.ssh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.atguigu.ssh.entities.Department;

@Repository("departmentDao")
public class DepartmentDao extends BaseDao {

	public List<Department> getAll() {
		String hql = "FROM Department";
		return getSession().createQuery(hql).list();
	}

}
