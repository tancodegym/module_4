package module_4.case_study.dto;

import module_4.case_study.model.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EmployeeDTO implements Validator {
    private Long id;
    private String code;
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "Wrong name format, please enter again ! ")
    private String name;
    private String birthDate;
    @Pattern(regexp = "\\d{9}", message = "Please enter again, id card is 9-digit string !")
    private String idCard;
    @Min(value = 5000000, message = "Salary must be greater than 5000000 !")
    private double salary;
    @Pattern(regexp = "\\d{10}", message = "Please enter again, number phone is 10-digit string !")
    private String phone;
    @Pattern(regexp = "^[A-z]{1}((\\w)*[.]?(\\w)*|(\\w)*[-]?(\\w)*)@[a-z0-9]+([.][a-z]{2,3}){1,5}", message = "Wrong email format (xxx@xxxx.com), please enter again !")
    private String email;
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "Wrong address format, please enter again !")
    private String address;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private User user;
    private List<Contract> contractList;
    private List<Employee> employeeList;
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public EmployeeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDTO employeeDTO = (EmployeeDTO) target;
        String birthDay = employeeDTO.getBirthDate();
        final String DATE_OF_BIRTH_REGEX = "[\\d]{4}(-)+((0+[1-9]{1})|(1+[0-2]{1}))+(-)+(([1-2]{1}+[\\d]{1})|(0+[1-9]{1})|(3+[0-1]))";
        if (!birthDay.matches(DATE_OF_BIRTH_REGEX)) {
            errors.rejectValue("birthDate", "BD", "Wrong format, please enter again !");
        }

        final String USER_NAME_REGEX = "(\\w){5,10}";
        if(!employeeDTO.getUser().getUserName().matches(USER_NAME_REGEX)){
            errors.rejectValue("user.userName", "UN", "Wrong format username (Accounts containing only characters or numbers, minimum 5 and maximum 10 characters), please enter again !");
        }
        final String PASS_WORD_REGEX = "(.){6,10}";
        if(!employeeDTO.getUser().getPassword().matches(PASS_WORD_REGEX)){
            errors.rejectValue("user.password","PW","Wrong format password (Minimum 6 and maximum 10 characters), please enter again ! ");
        }
        try {
            if (checkMaxAge(birthDay)) {
                errors.rejectValue("birthDate", "MaxAge", "Age must be less than 100 !");
            }
            if (checkMinAge(birthDay)) {
                errors.rejectValue("birthDate", "MinAge", "Age must be greater than 18 !");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Employee> employeeList = employeeDTO.getEmployeeList();
        Long i = employeeDTO.getId();
        for (int j = 0; j < employeeList.size(); j++) {
            if (employeeList.get(j).getId() == i) {
                employeeList.remove(j);
                break;
            }
        }
        for(Employee employee:employeeList){
            if(employeeDTO.getIdCard().equals(employee.getIdCard())){
                errors.rejectValue("idCard","sameIdCard","ID Card is exist, please enter another ID Card !");
            }
            if(employeeDTO.getEmail().equals(employee.getEmail())){
                errors.rejectValue("email","sameEmail","Email is exist, please enter another Email !");
            }
            if(employeeDTO.getPhone().equals(employee.getPhone())){
                errors.rejectValue("phone","samePhone","Number Phone is exist, please enter another Number Phone !");
            }
        }
        List<User> userList = employeeDTO.getUserList();
        Long m = employeeDTO.getUser().getId();
        for (int j = 0; j <userList.size() ; j++) {
            if(userList.get(j).getId()==m){
                userList.remove(j);
                        break;
            }
        }
        for(User user: userList){
            if(employeeDTO.getUser().getUserName().equals(user.getUserName())){
                errors.rejectValue("user.userName","sameUser","Username is exist, please enter another username !");
            }
        }






    }

    private boolean checkMaxAge(String date) throws ParseException {
        long days = getDate(date);
        if (days / 365 > 100 || days == -1) {
            return true;
        }
        return false;
    }

    private boolean checkMinAge(String date) throws ParseException {
        long days = getDate(date);
        if (days / 365 < 18 || days == -1) {
            return true;
        }
        return false;

    }

    private long getDate(String date) throws ParseException {
        long days = -1;
        if (date == null || date == "") {
            return days;
        }
        if (date != null || date != "") {
            String[] arrayDate = date.split("-");
            int day = Integer.parseInt(arrayDate[2]);
            int month = Integer.parseInt(arrayDate[1]);
            int year = Integer.parseInt(arrayDate[0]);
            DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date currentDate = new Date();
            Date date1;
            Date date2;
            String startDate = "" + day + "-" + month + "-" + year;
            String endDate = simpleDateFormat.format(currentDate);
            date1 = simpleDateFormat.parse(startDate);
            date2 = simpleDateFormat.parse(endDate);
            long getDiff = date2.getTime() - date1.getTime();

            return days = getDiff / (24 * 60 * 60 * 1000);

        }
        return days;
    }
}
