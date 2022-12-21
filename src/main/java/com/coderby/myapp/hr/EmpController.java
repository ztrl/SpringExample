package com.coderby.myapp.hr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmpController {
	
	@Autowired
	IEmpService empService;
	
	@RequestMapping("/hr/count") //http://localhost:8080/MySpring/hr/count?deptid=50
	public String empCount(@RequestParam(value="deptid", required=false, defaultValue="0") int deptid, Model model) {
		model.addAttribute("count", empService.getEmpCount(deptid));
		return "hr/count"; //WEB-INF/views/hr/count.jsp
	}
	
	@RequestMapping(value= {"/hr", "/hr/list"})
	public String getAllEmps(Model model) {
		List<EmpVO> empList = empService.getEmpList();
		model.addAttribute("empList", empList);
		return "hr/list";
	}
	
	@RequestMapping(value="/hr/{employeeId}")
	public String getEmpInfo(@PathVariable int employeeId, Model model) {
		EmpVO emp = empService.getEmpInfo(employeeId);
		model.addAttribute("emp", emp);
		return "hr/view";
	}
	
	@RequestMapping(value="/hr/insert", method=RequestMethod.GET)
	public String insertEmp(Model model) {
		System.out.println("회원입력 양식 호출");
		return "hr/insertForm";
	}
	
	public void printInfo() {
		int count = empService.getEmpCount(50);
		System.out.println("사원의 수: " + count);
	}
}
