package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "filters")
@XmlAccessorType(XmlAccessType.FIELD)
public class Filters {

    @XmlElement(name = "filter")
    private List<Filter> filters = null;

    public List<Filter> getFilters(){ return filters;}

    public void setFilters(List<Filter> filters){ this.filters = filters;}

    public Filters() {
    }
}
