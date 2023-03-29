package com.itwill.transaction.spring;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional(
		isolation = Isolation.READ_COMMITTED,
		propagation = Propagation.REQUIRES_NEW,
		rollbackFor = RuntimeException.class)
public interface EmployeeService {

	public abstract void registerEmployee(Employee emp);

	public abstract void deleteEmployee(int id);
	
	public abstract void udpateEmployee(Employee emp);
	@Transactional(rollbackFor =  {RuntimeException.class,SQLException.class},
									noRollbackFor = IndexOutOfBoundsException.class )
	public abstract List<Employee> getEmps();
	
	public abstract void increaseSalaryForAll();
	
	

}