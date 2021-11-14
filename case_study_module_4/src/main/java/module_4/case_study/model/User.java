package module_4.case_study.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;

    @ManyToMany
    @JoinTable(name="user_role",
    joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name= "role_id"))
    private Set<Role> roleList;
    @OneToMany(mappedBy = "user")
    private List<Employee> employeeList;
    public User() {
    }

    public User(String userName, String password, Set<Role> roleList) {
        this.userName = userName;
        this.password = password;
        this.roleList = roleList;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(Long id, String userName, String password, Set<Role> roleList) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.roleList = roleList;
    }

    public User(Long id, String userName, String password, Set<Role> roleList, List<Employee> employeeList) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.roleList = roleList;
        this.employeeList = employeeList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Set<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<Role> roleList) {
        this.roleList = roleList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
