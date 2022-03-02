package za.ac.cput.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.app.model.Employee;

import java.util.Optional;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 2/24/2022 | 5:47 PM
 *
 * <p>Project spring-boot-crud-app</p>
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  @Modifying
  @Transactional
  @Query(value = "UPDATE Employee SET firstname = ?1, " +
          "lastname = ?2, email = ?3 WHERE id = ?4", nativeQuery = true)
  void updateById(String firstname, String lastname, String email, Long id);
}
