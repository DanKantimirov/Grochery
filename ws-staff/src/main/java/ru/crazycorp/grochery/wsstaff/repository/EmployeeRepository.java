package ru.crazycorp.grochery.wsstaff.repository;

import org.springframework.stereotype.Component;
import ru.crazycorp.grochery.wsstaff.generated.employee.Employee;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


@Component
public class EmployeeRepository {

    private static final Map<Integer, Employee> emps = new HashMap<>();

    @PostConstruct
    public void init(){
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setFirstname("Dan");
        emp1.setMiddlename("Andreevich");
        emp1.setLastname("Kantimirov");
        emp1.setEmail("kantimirov_da@yahoo.com");
        emp1.setJobtitle("CEO");
        emps.put(emp1.getId(), emp1);

        Employee emp2 = new Employee();
        emp2.setId(1);
        emp2.setFirstname("Li");
        emp2.setLastname("Korg");
        emp2.setEmail("li_korg@yahoo.com");
        emp2.setJobtitle("Senior analyst");
        emps.put(emp2.getId(), emp2);

    }

    public Employee findEmployee(int id){
        return emps.get(id);
    }
}