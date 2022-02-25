package za.ac.cput.app.exceptions;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 2/25/2022 | 4:21 PM
 *
 * <p>Project spring-boot-crud-app</p>
 */
public class EmployeeNotFoundException extends Throwable {
  public EmployeeNotFoundException(String message) {
    super(message);
  }
}
