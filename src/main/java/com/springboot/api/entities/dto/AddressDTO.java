package com.springboot.api.entities.dto;

import com.springboot.api.entities.Address;
import com.springboot.api.entities.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddressDTO {

    @NotBlank(message = "{zipcode.not.blank}")
    private String zipcode;

    @NotBlank(message = "{street.not.blank}")
    private String street;

    @NotNull(message = "{num.not.blank}")
    private Integer num;

    @NotBlank(message = "{complement.not.blank}")
    private String complement;

    @NotBlank(message = "{district.not.blank}")
    private String district;

    @NotBlank(message = "{city.not.blank}")
    private String city;

    @NotBlank(message = "{state.not.blank}")
    private String state;

    private Long userId;

    public AddressDTO() {

    }
    public AddressDTO(Address address) {
        this.zipcode = address.getZipcode();
        this.street = address.getStreet();
        this.num = address.getNum();
        this.complement = address.getComplement();
        this.district = address.getDistrict();
        this.city = address.getCity();
        this.state = address.getState();

        if(address.getUser() != null)
            this.userId = address.getUser().getId();

    }

    public AddressDTO(String street, Integer num, String complement,
                      String district, String city, String state, String zipcode, Long userId) {

        this.zipcode = zipcode;
        this.street = street;
        this.num = num;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.state = state;
        this.userId = userId;
    }

    public String getZipcode() { return zipcode; }

    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Address toAddress(){
        Address address = new Address();
        User user = new User();

        user.setId(this.userId);

        address.setStreet(this.street);
        address.setNum(this.num);
        address.setComplement(this.complement);
        address.setDistrict(this.district);
        address.setCity(this.city);
        address.setState(this.state);
        address.setZipcode(this.zipcode);
        address.setUser(user);

        return address;
    }
}
