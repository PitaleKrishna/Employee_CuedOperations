package EmployeMain.File.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

 

import EmployeMain.File.model.Employee;
import EmployeMain.File.repository.EmployeRepository;
import EmployeMain.File.service.EmployeeService;
 

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeRepository employeRepository;
	@Override
	public Employee createEmp(Employee emp) {
		Employee saveEmp=employeRepository.save(emp);
		return saveEmp;
	}
	@Override
	public List<Employee> getEmployee() {
		List<Employee> empList=employeRepository.findAll();
		return empList;
	}

	@Override
	public void deleteEmp(int id) {


		Optional <Employee> deleteEmp=employeRepository.findById(id);
		if(deleteEmp.isPresent()) {
			Employee empDelete=deleteEmp.get();
			employeRepository.delete(empDelete);
		}
	}
 
	@Override
	public Employee updateEmploye(Integer id,Employee employee) {
		// TODO Auto-generated method stub
		Employee updatedUser = new Employee();
		Optional<Employee> savedUser = employeRepository.findById(id);
	    Employee update=savedUser.get();
		if (savedUser.isPresent()) {
			  
		BeanUtils.copyProperties(employee, updatedUser);
		}
		updatedUser=employeRepository.save(updatedUser);
		return updatedUser;
}
	@Override
	public Employee getEmployeById(int id) {
		 
		Employee employee = new Employee();
		Optional<Employee> savedEmp = employeRepository.findById(id);
		if (savedEmp.isPresent())
			return savedEmp.get();
		return employee;
	}
	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeRepository.save(employee);
		
	}
 
	 
	}
