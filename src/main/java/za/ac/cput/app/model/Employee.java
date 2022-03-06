package za.ac.cput.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 2/24/2022 | 6:50 PM
 *
 * <p>Project spring-boot-crud-app</p>
 */
@Entity
@Table
@Data
@ToString
@AllArgsConstructor
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String firstname;

  private String lastname;

  @Column(nullable = false)
  private String email;

  public Employee() {
  }

  public Employee(String firstname, String lastname, String email) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
  }
}
