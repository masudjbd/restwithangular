package org.masud.rest.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.masud.rest.domain.Department;
import org.masud.rest.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private static List<Employee> eList = new ArrayList<Employee>();

	static {
		eList.add(new Employee("Safiqul Alam"));
		eList.add(new Employee("Monjuara Khatun"));
		eList.add(new Employee("Masudur Rahman"));
		eList.add(new Employee("Shamima Sultana"));
		eList.add(new Employee("Fahim Muntasir"));
		eList.add(new Employee("Bivash Chowdhury"));
		eList.add(new Employee("Sultana Khatun"));
		eList.add(new Employee("Mumtahena Khatun"));
		eList.add(new Employee("Ornoi Chowdhury"));
		eList.add(new Employee("DunMiah Chowdhury"));
		eList.add(new Employee("Rasheda Chowdhury"));

	}

	public List<Employee> getList() {
		
//		Department dept = new Department("Software");
//		
//		for (Employee e : eList){
//			e.setDept(dept);
//			sessionFactory.getCurrentSession().persist(e);
//			
//		}
		
		
			return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	public void addEmployee(Employee employee) {
		 sessionFactory.getCurrentSession().persist(employee);
		
	}
}
