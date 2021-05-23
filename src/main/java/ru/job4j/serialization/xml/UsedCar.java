package ru.job4j.serialization.xml;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "usedCar")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsedCar {

    @XmlAttribute
    private boolean carMove;
    @XmlAttribute
    private int yearOfRelease;
    @XmlAttribute
    private String brand;
    private Engine engine;
    private String[] replacementParts;

    public UsedCar() {
    }

    public UsedCar(boolean carMove, int yearOfRelease, String brand, Engine engine, String... replacementParts) {
        this.carMove = carMove;
        this.yearOfRelease = yearOfRelease;
        this.brand = brand;
        this.engine = engine;
        this.replacementParts = replacementParts;
    }

    @Override
    public String toString() {
        return "UsedCar{"
                + "CarMove=" + carMove
                + ", yearOfRelease=" + yearOfRelease
                + ", brand='" + brand + '\''
                + ", engine=" + engine
                + ", replacementParts=" + Arrays.toString(replacementParts)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        UsedCar usedCar = new UsedCar(true, 2002, "Opel",
                new Engine("GH34564", 2.0), "Oil", "brake pads");
        JAXBContext context = JAXBContext.newInstance(UsedCar.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(usedCar, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            UsedCar result = (UsedCar) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
