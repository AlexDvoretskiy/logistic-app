package com.logisticApp.dto;


import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


public class EmployeeDto {

    private Long empId;

    @NotNull(message = "Данное поле должно быть заполнено")
    @Size(min = 1, message = "Данное поле должно быть заполнено")
    private String lastName;

    @NotNull(message = "Данное поле должно быть заполнено")
    @Size(min = 1, message = "Данное поле должно быть заполнено")
    private String firstName;

    @NotNull(message = "Данное поле должно быть заполнено")
    @Size(min = 1, message = "Данное поле должно быть заполнено")
    private String middleName;

    @Min(18)
    @NotNull(message = "Данное поле должно быть заполнено")
    @Digits(integer=3, fraction=0, message = "Не более 3-х знаков")
    private short age;

    @NotNull(message = "Данное поле должно быть заполнено")
    private List<Long> licenceIdList;

    @NotNull(message = "Данное поле должно быть заполнено")
    private String hireDate;

    @NotNull(message = "Данное поле должно быть заполнено")
    private Long statusId;

    public EmployeeDto() {

    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public List<Long> getLicenceIdList() {
        return licenceIdList;
    }

    public void setLicenceIdList(List<Long> licenceIdList) {
        this.licenceIdList = licenceIdList;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
}
