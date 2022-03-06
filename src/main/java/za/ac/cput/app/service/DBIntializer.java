package za.ac.cput.app.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import za.ac.cput.app.model.Employee;
import za.ac.cput.app.repository.EmployeeRepository;

import java.util.Arrays;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 3/6/2022 | 3:18 PM
 *
 * <p>Project spring-boot-crud-app</p>
 */
@AllArgsConstructor
@Service
public class DBIntializer implements CommandLineRunner {

  private EmployeeRepository repository;

  @Override
  public void run(String... args) throws Exception {
    repository.saveAll(Arrays.asList(
            new Employee(
                    "John",
                    "Doe",
                    "john@doe.org"
            ),
            new Employee(
                    "Mark",
                    "Siya",
                    "siya@mark.com"
            )
    ));
  }
}
