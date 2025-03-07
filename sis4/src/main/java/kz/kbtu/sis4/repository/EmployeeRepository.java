package kz.kbtu.sis4.repository;

import kz.kbtu.sis4.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
