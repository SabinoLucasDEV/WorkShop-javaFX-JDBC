package model.service;

import java.util.ArrayList;
import java.util.List;

import model.entitys.Department;

public class DepartmentService {
	
	public List<Department> findAll() {
		List<Department> list = new ArrayList<Department>();
		list.add(new Department(1, "books"));
		list.add(new Department(2, "eletronicks"));
		list.add(new Department(3, "computies"));
		return list;
		
		
	}

}
