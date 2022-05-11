package util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import model.Filters;

import java.io.File;

public class XmlToObject {
    public Filters convert(){
        File file = new File("src/main/resources/filters.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Filters.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Filters data = (Filters) jaxbUnmarshaller.unmarshal(file);
            return data;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;

    }
}
