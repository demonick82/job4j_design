package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class ReportAccounting implements Report {
    private Store store;

    public ReportAccounting(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        text.append(System.lineSeparator());
        for (Employee em : store.findBy(filter)) {
            text.append(em.getName()).append(";")
                    .append(em.getHired()).append(";")
                    .append(em.getFired()).append(";")
                    .append(em.getSalary()).append(" $").append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
