package ru.job4j.ood.ocp;

import ru.job4j.ood.srp.Employee;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Employees {
    @XmlElementWrapper
    private List<Employee> employee = new ArrayList<>();

    public void add(Employee em) {
        employee.add(em);
    }
}
