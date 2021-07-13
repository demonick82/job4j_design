package ru.job4j.ood.ocp;

import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.MemStore;
import ru.job4j.ood.srp.Report;
import ru.job4j.ood.srp.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportXml implements Report {
    private Store store;

    public ReportXml(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringWriter writer = new StringWriter();
        Employees employees = new Employees();
        for (Employee em : store.findBy(employee -> true)) {
            employees.add(em);
        }

        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class, Employee.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(employees, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker2 = new Employee("Pavel", now, now, 60);
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Sergey", now, now, 80);
        store.add(worker2);
        store.add(worker);
        store.add(worker1);
        ReportXml reportXml = new ReportXml(store);
        System.out.println(reportXml.generate(employee -> true));

    }

}
