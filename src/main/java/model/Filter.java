package model;


import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "filter")
@XmlAccessorType(XmlAccessType.FIELD)
public class Filter extends Filters {
    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "sum")
    private String sum;

    @XmlElement(name = "filtersearch")
    private String filtersearch;

    public Filter() {
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

    public String getFiltersearch() {
        return filtersearch;
    }

    public void setFiltersearch(String filtersearch) {
        this.filtersearch = filtersearch;
    }




    @Override
    public String toString() {
        return "TestData{" +
                "name='" + name + '\'' +
                "sum='" + sum + '\'' +
                '}';
    }
}
