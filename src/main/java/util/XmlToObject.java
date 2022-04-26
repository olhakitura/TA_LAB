package util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import model.TestData;

import java.io.File;

public class XmlToObject {
    public TestData convert(){
        File file = new File("src/main/resources/testdata.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TestData.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            TestData data = (TestData) jaxbUnmarshaller.unmarshal(file);
            return data;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;

    }
}
