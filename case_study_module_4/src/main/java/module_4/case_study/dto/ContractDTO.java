package module_4.case_study.dto;

import module_4.case_study.model.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ContractDTO implements Validator {


    private Long id;
    private String startDate;
    private String endDate;
    @Min(value = 1000000, message = "Deposit at least 1000000 !")
    private double deposit;
    private double totalMoney;
    private Customer customer;
    private Employee employee;
    private Service service;
    private List<ContractDetail> contractDetailList;

    public ContractDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDTO contractDTO = (ContractDTO) target;
        final String DATE_REGEX = "[\\d]{4}(-)+((0+[1-9]{1})|(1+[0-2]{1}))+(-)+(([1-2]{1}+[\\d]{1})|(0+[1-9]{1})|(3+[0-1]))";
        if (!contractDTO.getStartDate().matches(DATE_REGEX)) {
            errors.rejectValue("startDate", "SD", "Wrong format, please enter again !");
        }
        if (!contractDTO.getEndDate().matches(DATE_REGEX)) {
            errors.rejectValue("endDate", "ED", "Wrong format, please enter again !");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = sdf.parse(contractDTO.startDate);
            Date endDate = sdf.parse(contractDTO.endDate);
            Date now = sdf.parse(String.valueOf(LocalDate.now()));
            if(startDate.compareTo(now)<=0){
                errors.rejectValue("startDate", "SDF", "The start date must be in the future!");
            }
            if(endDate.compareTo(now)<=0){
                errors.rejectValue("endDate", "EDF", "The end date must be in the future!");
            }
            if(endDate.compareTo(startDate)<=0){
                errors.rejectValue("startDate", "SDM", "Start date must be before end date !");
                errors.rejectValue("endDate", "EDM", "End date must be after start date !");

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        try {
//            long startDays = getDate(contractDTO.getStartDate());
//            long endDays = getDate(contractDTO.getEndDate());
//            long nowDay = getDate(String.valueOf(LocalDate.now()));
//            if (endDays - startDays <= 0) {
//                errors.rejectValue("startDate", "SDM", "Start date must be before end date !");
//                errors.rejectValue("endDate", "EDM", "End date must be after start date !");
//            }
//            if (startDays - nowDay <= 0) {
//                errors.rejectValue("startDate", "SDF", "The start date must be in the future!");
//            }
//            if (endDays - nowDay <= 0) {
//                errors.rejectValue("endDate", "EDF", "The end date must be in the future!");
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


    }

//
//    private long getDate(String date) throws ParseException {
//        long days = -1;
//        if (date == null || date == "") {
//            return days;
//        }
//        if (date != null || date != "") {
//            String[] arrayDate = date.split("-");
//            int day = Integer.parseInt(arrayDate[2]);
//            int month = Integer.parseInt(arrayDate[1]);
//            int year = Integer.parseInt(arrayDate[0]);
//            DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//            Date currentDate = new Date();
//            Date date1;
//            Date date2;
//            String startDate = "" + day + "-" + month + "-" + year;
//            String endDate = simpleDateFormat.format(currentDate);
//            date1 = simpleDateFormat.parse(startDate);
//            date2 = simpleDateFormat.parse(endDate);
//            long getDiff = date2.getTime() - date1.getTime();
//
//            return days = getDiff / (24 * 60 * 60 * 1000);
//
//        }
//        return days;
//    }
}
