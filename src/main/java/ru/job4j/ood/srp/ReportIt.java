package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class ReportIt implements Report {
    private Store store;

    public ReportIt(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder()
                .append("<html>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<div>Name; Hired; Fired; Salary;</div>")
                .append(System.lineSeparator());
        for (Employee worker : store.findBy(filter)) {
            text.append("<div>")
                    .append(worker.getName()).append(";")
                    .append(worker.getHired()).append(";")
                    .append(worker.getFired()).append(";")
                    .append(worker.getSalary()).append(";")
                    .append("</div>").append(System.lineSeparator());
        }
        text.append("</body>").append(System.lineSeparator())
                .append("</html>");
        return text.toString();
    }
}
