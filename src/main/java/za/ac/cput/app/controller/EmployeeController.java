package za.ac.cput.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.app.model.Employee;
import za.ac.cput.app.service.EmployeeService;

import javax.validation.Valid;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 2/24/2022 | 5:46 PM
 *
 * <p>Project spring-boot-crud-app</p>
 */
@Controller
public class EmployeeController {

  private EmployeeService empService;

  public EmployeeController(EmployeeService _emp) {
    this.empService = _emp;
  }

  /**
   * <p>returnViewAllEmployees, this method get all employees
   * from service and return them to the client (view layer)
   * through HTTP Request GetMapping</p>
   *
   *
   */
  @GetMapping("/")
  public String sendToHome(Model model) {

    model.addAttribute(
            "allemployees",
            empService.getAllEmployee());
    return "index";
  }
  /**
   * <p>Method saves employee into the database</p>
   *
   * @param     employee
   * @return    Return a string that redirect to home page
   */
  @PostMapping("/SaveEmployee")
  public String saveEmployee(@ModelAttribute("employee") Employee employee) {
    empService.saveEmployee(employee);
    return "redirect:/";
  }

  /**
   * <p>Methods to delete employee from db</p>
   */
  @GetMapping("/DeleteEmp/{id}")
  public String deleteEmployee(@PathVariable(value = "id") Long id) {
    empService.deleteById(id);
    return "redirect:/";
  }

  @RequestMapping("/Create")
  public String CreateEmployee(Model model) {
    model.addAttribute("employee", new Employee());
    return "create";
  }

  /**
   * <p>This method redirect to the update form</p>
   *
   * @param     id
   * @param     model
   * @return    Return string indicating name of the view
   */
  @GetMapping("/ShowEmployee/{id}")
  public String showEmployee(@PathVariable("id") Long id, Model model) {
    model.addAttribute("employee",
            empService.selectById(id));
    return "update";
  }

  /**
   * <p>Find a single employe and commit changes to a new</p>
   * @return String
   */
  @PostMapping("/UpdateEmployee/{id}")
  public String doUpdate(@PathVariable("id") Long id,
                         @ModelAttribute("employee") @Valid Employee employee) {

    String firstname = employee.getFirstname();
    String lastname = employee.getLastname();
    String email = employee.getEmail();

    empService.updateEmployee(firstname, lastname, email, id);
    return "redirect:/";
  }
}
