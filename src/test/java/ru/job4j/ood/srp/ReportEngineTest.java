package ru.job4j.ood.srp;

import java.io.StringWriter;
import java.util.Calendar;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import ru.job4j.ood.ocp.Employees;
import ru.job4j.ood.ocp.ReportJson;
import ru.job4j.ood.ocp.ReportXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ReportEngineTest {
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenItGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Sergey", now, now, 80);
        Employee worker2 = new Employee("Pavel", now, now, 60);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportIt(store);
        StringBuilder expect = new StringBuilder()
                .append("<html>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<div>Name; Hired; Fired; Salary;</div>")
                .append(System.lineSeparator())
                .append("<div>")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("</div>").append(System.lineSeparator())
                .append("<div>")
                .append(worker1.getName()).append(";")
                .append(worker1.getHired()).append(";")
                .append(worker1.getFired()).append(";")
                .append(worker1.getSalary()).append(";")
                .append("</div>").append(System.lineSeparator())
                .append("<div>")
                .append(worker2.getName()).append(";")
                .append(worker2.getHired()).append(";")
                .append(worker2.getFired()).append(";")
                .append(worker2.getSalary()).append(";")
                .append("</div>").append(System.lineSeparator());
        expect.append("</body>").append(System.lineSeparator())
                .append("</html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenAccountingGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Sergey", now, now, 80);
        Employee worker2 = new Employee("Pavel", now, now, 60);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportAccounting(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(" $").append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getHired()).append(";")
                .append(worker1.getFired()).append(";")
                .append(worker1.getSalary()).append(" $").append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getHired()).append(";")
                .append(worker2.getFired()).append(";")
                .append(worker2.getSalary()).append(" $").append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker2 = new Employee("Pavel", now, now, 60);
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Sergey", now, now, 80);
        store.add(worker2);
        store.add(worker);
        store.add(worker1);
        Report engine = new ReportHr(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGsonGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker2 = new Employee("Pavel", now, now, 60);
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Sergey", now, now, 80);
        store.add(worker2);
        store.add(worker);
        store.add(worker1);
        Report engine = new ReportJson(store);
        Gson expect = new GsonBuilder().create();
        Employees employees = new Employees();
        for (Employee em : store.findBy(employee -> true)) {
            employees.add(em);
        }
        assertThat(engine.generate(em -> true), is(expect.toJson(employees)));
    }

    @Test
    public void whenXmlGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker2 = new Employee("Pavel", now, now, 60);
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Sergey", now, now, 80);
        store.add(worker2);
        store.add(worker);
        store.add(worker1);
        Report engine = new ReportXml(store);
        StringWriter expect = new StringWriter();
        Employees employees = new Employees();

        for (Employee em : store.findBy(employee -> true)) {
            employees.add(em);
        }
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class, Employee.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(employees, expect);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        assertThat(engine.generate(employee -> true), is(expect.toString()));

    }
}