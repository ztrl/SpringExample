package com.coderby.myapp.hr;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.coderby.myapp.hr.model.EmpVO;
import com.coderby.myapp.hr.service.EmpService;
import com.coderby.myapp.hr.service.IEmpService;

public class EmpMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config.xml");
		
//		EmpController controller = context.getBean(EmpController.class);
//		System.out.println("----------");
//		controller.printInfo();
//		System.out.println("----------");
		
		IEmpService empService = context.getBean(EmpService.class);
		
//		List<EmpVO> empList = empService.getEmpList();
//		
//		System.out.println("사원 목록");
//		System.out.println(empList);
//		System.out.println("----------");
//		
//		System.out.println("103번 사원의 정보 조회");
//		System.out.println(empService.getEmpInfo(103));
//		System.out.println("----------");
//		
//		System.out.println("새로운 사원 정보 입력");
//		EmpVO emp = new EmpVO();
//		emp.setEmployeeId(210);
//		emp.setFirstName("MoonYoung");
//		emp.setLastName("Shin");
//		emp.setEmail("SMY");
//		emp.setPhoneNumber("010-1234-5678");
//		emp.setJobId("IT_PROG");
//		emp.setSalary(10000);
//		emp.setCommissionPct(0.99);
//		emp.setManagerId(100);
//		emp.setDepartmentId(10);
//		try {
//			empService.insertEmp(emp);
//			System.out.println("insert OK");
//		}
//		catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("----------");
//		
		System.out.println("신규 사원 정보 조회");
		EmpVO emp210 = new EmpVO();
		emp210 = empService.getEmpInfo(210);
		System.out.println(emp210);
		System.out.println("----------");

		System.out.println("사원 정보 수정 - 210번 사원 급여 10% 인상");
		emp210.setSalary(emp210.getSalary() * 1.1);
		empService.updateEmp(emp210);
		System.out.println("----------");
		
		System.out.println("수정된 사원 정보 조회");
		emp210 = empService.getEmpInfo(210);
		System.out.println(emp210);
		System.out.println("----------");
		
//		System.out.println("210번 사원 정보 삭제");
//		empService.deleteEmp(210, "SMY");
//		System.out.println("----------");
//		
//		System.out.println("모든 부서번호와 부서이름 조회");
//		System.out.println(empService.getAllDeptId());
//		System.out.println("----------");
//		
//		System.out.println("모든 직무번호와 직무이름 조회");
//		System.out.println(empService.getAllJobId());
//		System.out.println("----------");
//		
//		System.out.println("모든 매니저번호와 매니저이름 조회");
//		System.out.println(empService.getAllManagerId());
//		System.out.println("----------");
		
		context.close();
	}
}