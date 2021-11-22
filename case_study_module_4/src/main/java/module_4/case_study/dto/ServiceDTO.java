package module_4.case_study.dto;

import module_4.case_study.model.Contract;
import module_4.case_study.model.RentType;
import module_4.case_study.model.Service;
import module_4.case_study.model.ServiceType;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.util.List;

public class ServiceDTO implements Validator {
    private Long id;
    private String code;
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Wrong name format, please enter again ! ")
    private String name;
    @Min(value = 100,message = "Area must be more than 100 square meters !")
//    @Pattern(regexp = "^(\\d+)(\\.\\d+)?$",message = "Area cant be empty !")
//    @DecimalMin(value = "0.0001", message = "Area not null ")

    private int area;
    @Min(value = 500000,message = "Cost must be greater than 500000 !")
    private double cost;
    @Range(min=1,max=20,message = "Number of people must be greaten than 1 and less than 20 !")
    private int maxPeople;
    private RentType rentType;
    private ServiceType serviceType;
    @NotBlank(message = "Room Standard can not blank or empty !")
    private String roomStandard;
    @NotBlank(message = "Convenient can not blank or empty !")
    private String convenient;
    @Min(value = 20,message = "Swimming pool area must be more than 20 square meters !")
    private double poolArea;
    @Min(value = 1,message = "Number of Floor must be greater than 1 !")
    private int numberOfFloors;
    private List<Contract> contractList;
    private List<Service> services;

    public ServiceDTO() {
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getConvenient() {
        return convenient;
    }

    public void setConvenient(String convenient) {
        this.convenient = convenient;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDTO serviceValidate = (ServiceDTO) target;
        String area = String.valueOf(serviceValidate.getArea());
        String REGEX = "^(\\d+)(\\.\\d+)?$";
        if(!area.matches(REGEX)){
            errors.rejectValue("area", "AREA", "Area can not be empty !");
        }
    }
}
