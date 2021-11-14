package module_4.case_study.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class CustomerType {
    @Id
    private Long id;
    private String name;
    @OneToMany(mappedBy = "customerType")
    private List<Customer> customerList;
    public CustomerType() {
    }

    public CustomerType(String name, List<Customer> customerList) {
        this.name = name;
        this.customerList = customerList;
    }

    public CustomerType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
