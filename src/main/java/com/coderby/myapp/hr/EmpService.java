package com.coderby.myapp.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService implements IEmpService {

	@Autowired
	IEmpRepository repository;
	
	@Override
	public int getEmpCount(int deptid) {
		if (deptid > 0) {
			return repository.getEmpCount(deptid);
		}
		else {
			return repository.getEmpCount();
		}
	}

}