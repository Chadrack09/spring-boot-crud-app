package za.ac.cput.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import za.ac.cput.app.exceptions.EmployeeNotFoundException;
import za.ac.cput.app.model.Employee;
import za.ac.cput.app.service.EmployeeService;

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
   * @return    Return string that indicate the name of the view
   */
  @GetMapping("/ShowEmployee/{id}")
  public String showEmployee(@PathVariable("id") Long id, Model model) {
    model.addAttribute("employee",
            empService.selectById(id));
    return "update";
  }

  /**
   * <p>Find a single employe and commit changes to a new</p>
   * @param id
   * @param model
   * @return String
   */
  @GetMapping("/UpdateEmployee/{id}")
  public String updateEmployee(@PathVariable("id") Long id,
                               Model model, RedirectAttributes redirect) {
    try {
      Employee employee = empService.get(id);
      model.addAttribute("employee",employee);
      return "redirect:/";
    }
    catch(EmployeeNotFoundException ex) {
      redirect.addFlashAttribute("message", "The user was saved");
              return "redirect:/";
    }
  }
}
