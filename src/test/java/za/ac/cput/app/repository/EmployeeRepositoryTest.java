package za.ac.cput.app.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.app.model.Employee;
import za.ac.cput.app.service.EmployeeService;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 3/2/2022 | 6:52 AM
 *
 * <p>Project spring-boot-crud-app</p>
 */
@SpringBootTest
class EmployeeRepositoryTest {

  @Autowired
  private EmployeeRepository repository;

  @Autowired
  private EmployeeService service;

  @Test
  public void save() {
    repository.save(new Employee(
            "John",
            "Doe",
            "john@doe.com"));
  }

  @Test
  public void update() {
    repository.updateById(
            "Rico",
            "Peter",
            "Pete@gmail.com",
            2l);
  }
}