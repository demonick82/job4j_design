package ru.job4j.ood.srp;

import java.util.List;
import java.util.function.Predicate;

public class ReportHr implements Report {
    private Store store;

    public ReportHr(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> sortStore = store.findBy(filter);
        sortStore.sort(new EmpSortBySalary());
        StringBuilder text = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee em : sortStore) {
            text.append(em.getName()).append(";")
                    .append(em.getSalary()).append(";")
                    .append(System.lineSeparator());
        }

        return text.toString();
    }
}
