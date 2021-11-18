package module_4.case_study.dto;

import module_4.case_study.model.Contract;
import module_4.case_study.model.Customer;
import module_4.case_study.model.CustomerType;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomerDTO implements Validator {
    private Long id;
    private String code;
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Wrong name format, please enter again ! ")
    private String name;
    private String birthDate;
    private int gender;
    @Pattern(regexp = "\\d{9}",message = "Please enter again, id card is 9-digit string !")
    private String idCard;
    @Pattern(regexp = "\\d{10}",message ="Please enter again, number phone is 10-digit string !" )
    private String phone;
    @Pattern(regexp = "^[A-z]{1}((\\w)*[.]?(\\w)*|(\\w)*[-]?(\\w)*)@[a-z0-9]+([.][a-z]{2,3}){1,5}",message = "Wrong email format (xxx@xxxx.com), please enter again !")
    private String email;
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Wrong address format, please enter again !")
    private String address;
    private CustomerType customerType;
    private List<Contract> contractList;
    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public CustomerDTO() {
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {

            CustomerDTO customerDTO = (CustomerDTO) target;
           String birthDay = customerDTO.getBirthDate();
        final String DATE_OF_BIRTH_REGEX = "[\\d]{4}(-)+((0+[1-9]{1})|(1+[0-2]{1}))+(-)+(([1-2]{1}+[\\d]{1})|(0+[1-9]{1})|(3+[0-1]))";
        if (!birthDay.matches(DATE_OF_BIRTH_REGEX)) {
            errors.rejectValue("birthDate","BD","Wrong format, please enter again !");
        }
        List<Customer> customerList= customerDTO.getCustomers();
        Long i = customerDTO.getId();
        for (int j = 0; j < customerList.size(); j++) {
            if(customerList.get(j).getId()==i){
                customerList.remove(j);
                break;
            }

        }
        for(Customer customer:customerList){
            if(customerDTO.getIdCard().equals(customer.getIdCard())){
                errors.rejectValue("idCard","sameIdCard","ID Card is exist, please enter another ID Card !");
            }
            if(customerDTO.getEmail().equals(customer.getEmail())){
                errors.rejectValue("email","sameEmail","Email is exist, please enter another Email !");
            }
            if(customerDTO.getPhone().equals(customer.getPhone())){
                errors.rejectValue("phone","samePhone","Number Phone is exist, please enter another Number Phone !");
            }
        }
        try {
            if(checkMaxAge(birthDay)){
                errors.rejectValue("birthDate","MaxAge","Age must be less than 100 !");
            }
            if(checkMinAge(birthDay)){
                errors.rejectValue("birthDate","MinAge","Age must be greater than 18 !");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }
    private boolean checkMaxAge(String date) throws ParseException {
        long days  = getDate(date);
        if(days/365>100||days ==-1){
            return true;
        }
        return false;
    }
    private boolean checkMinAge(String date) throws ParseException {
        long days  = getDate(date);
        if(days/365<18||days ==-1){
            return true;
        }
        return false;

    }
    private long getDate(String date) throws ParseException {
        long days = -1;
        if(date ==null ||date == ""){
            return days;
        }
        if(date !=null || date !="") {
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
