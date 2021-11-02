package com.codegym.model;
import javax.validation.constraints.*;


public class User   {
    @NotEmpty
    @Size(min = 5, max = 45)
    @Pattern(regexp = "",message = "Nam")
    private String firstname;
    @NotEmpty
    @Size(min = 5, max = 45)
    @Pattern(regexp = "^[A-Z][A-z]*",message = "Name must be capitalized and between 5-45 characters")
    private String lastname;
    @Pattern(regexp = "0[0-9]{9}",message = "Number Phone must be 10 diggits and start by zero  !")
    private String numberPhone;
    @Min(18)
    private int age;
    @Pattern(regexp = "^[A-z]{1}((\\w)*[.]?(\\w)*|(\\w)*[-]?(\\w)*)@[a-z0-9]+([.][a-z]{2,3}){1,5}",message = "Email must be in the correct format ! ")
    private String email;

    public User() {
    }

    public User(@NotEmpty @Size(min = 5, max = 45) @Pattern(regexp = "^A[A-z]*",
            message = "Name must be capitalized and between 5-45 characters") String firstname,
                @NotEmpty @Size(min = 5, max = 45) @Pattern(regexp = "^A[A-z]*",
                        message = "Name must be capitalized and between 5-45 characters") String lastname, @Pattern(regexp = "0[0-9]{9}", message = "Number Phone must be 10 diggits and start by zero  !") String numberPhone, @Min(18) int age, @Pattern(regexp = "^[A-z]{1}((\\w)*[.]?(\\w)*|(\\w)*[-]?(\\w)*)@[a-z0-9]+([.][a-z]{2,3}){1,5}", message = "Email must be in the correct format ! ") String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.numberPhone = numberPhone;
        this.age = age;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
