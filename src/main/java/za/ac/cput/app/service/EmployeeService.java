package za.ac.cput.app.service;

import org.springframework.stereotype.Service;
import za.ac.cput.app.model.Employee;
import za.ac.cput.app.repository.EmployeeRepository;

import java.util.List;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 2/24/2022 | 5:47 PM
 *
 * <p>Project spring-boot-crud-app</p>
 */
@Service
public class EmployeeService {

  private EmployeeRepository empRepository;

  public EmployeeService(EmployeeRepository _er) {
    this.empRepository = _er;
  }

  /**
   * <p>getAllEmployee, this method will get all employees on
   * the database</p>
   *
   * @return    Returns a List of all Employee
   */
  public List<Employee> getAllEmployee() {
    return empRepository.findAll();
  }

  /**
   * <p>saveEmployee, this method saves a single employee
   * onto the database.</p>
   *
   * @param     employee
   * @return    Return a single employee on success
   */
  public Employee saveEmployee(Employee employee) {
    return empRepository.save(employee);
  }
  /**
   * <p>Method select a single employee by id</p>
   */
  public Employee selectById(Long id) {
    return empRepository.getById(id);
  }
  /**
   * <p>Methods to delete employee from db</p>
   *
   * @param     id
   */
  public void deleteById(Long id) {
    empRepository.deleteById(id);
  }
}
