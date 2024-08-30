using Microsoft.AspNetCore.Mvc;
using SPAWebApplication.Models;

namespace SPAWebApplication.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Home()
        {
            List<Employee> employees = new List<Employee>();

            employees.Add(new Employee
            {
                Name = "Ivan",
                Age = 30,
                Id = 1001
            });
            employees.Add(new Employee
            {
                Name = "Petr",
                Age = 33,
                Id = 1002
            });
            employees.Add(new Employee
            {
                Name = "Sergey",
                Age = 35,
                Id = 1003
            });
            employees.Add(new Employee
            {
                Name = "Oleg",
                Age = 45,
                Id = 1004
            });

            return View(employees);
        }

        public IActionResult About()
        {
            return View();
        }

        public IActionResult Contact()
        {
            return View();
        }
    }
}
