package za.ac.cput.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
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

  @Query("UPDATE Employee e SET e.firstname = :firstname, " +
          "e.lastname = :lastname, e.email = :email WHERE e.id = :id")
  public void updateById(@Param("id") Long id, @Param("firstname") String firstname,
                         @Param("lastname") String lastname, @Param("email") String email);
}
