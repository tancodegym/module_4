package com.example.demo.dto;

import com.example.demo.model.Customer;
import com.example.demo.model.Trade;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class TradeDTO implements Validator {

    private Long id;
    @Pattern(regexp = "MGD-\\d{4}",message = "Không đúng định dạng( MGD-XXXX)")
    private String code;
    private String day;
    private int type;
    @Min(value = 500000,message = "Đơn giá phải lớn hơn 500000 VND")
    private int price;
    @Min(value = 20,message = "Diện tích phải lớn hơn 20m2 !")
    private int area;
    private Customer customer;
    private List<Trade> tradeList;

    public TradeDTO() {
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Trade> getTradeList() {
        return tradeList;
    }

    public void setTradeList(List<Trade> tradeList) {
        this.tradeList = tradeList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        TradeDTO tradeDTO = (TradeDTO) target;
        String day = tradeDTO.getDay();
        final String DATE_OF_BIRTH_REGEX = "[\\d]{4}(-)+((0+[1-9]{1})|(1+[0-2]{1}))+(-)+(([1-2]{1}+[\\d]{1})|(0+[1-9]{1})|(3+[0-1]))";
        if (!day.matches(DATE_OF_BIRTH_REGEX)) {
            errors.rejectValue("day","BD","Ngày giao dịch phải đúng định dạng ngày/tháng/năm  !");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(tradeDTO.getDay());
            Date now = sdf.parse(String.valueOf(LocalDate.now()));
            if(date.compareTo(now)<=0){
                errors.rejectValue("day", "DF", "Ngày giao dịch phải lớn hơn ngày hiện tại!");
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }



    }
}
