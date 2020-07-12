package com.atguigu.ssh.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.atguigu.ssh.entities.Employee;

@Repository("employeeDao")
public class EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void delete(Integer id) {
		String hql = "DELETE FROM Employee e WHERE e.id = ?";
		sessionFactory.getCurrentSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}

	public List<Employee> getAll() {

		System.out.println("sessionFactory=======" + sessionFactory);
		String hql = "FROM Employee e LEFT OUTER JOIN FETCH e.department";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	public void saveOrUpdate(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

	public Employee getEmployeeByLastName(String lastName) {
		String hql = "FROM Employee e WHERE e.lastName = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setString(0, lastName);
		Employee employee = (Employee) query.uniqueResult();
		System.out.println(employee.getDepartment().getClass().getName());
		return employee;
	}

	public Employee get(Integer id) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
	}
}
