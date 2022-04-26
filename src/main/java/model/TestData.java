package model;


import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "testdata")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestData {
    @XmlElement(name = "name")
    private String name;;
    @XmlElement(name = "sum")
    private String sum;

    public TestData() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "name='" + name + '\'' +
                ", sum='" + sum + '\'' +
                '}';
    }
}
