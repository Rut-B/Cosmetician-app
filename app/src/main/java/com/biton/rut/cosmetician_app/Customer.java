package com.biton.rut.cosmetician_app;

import android.media.Image;

import java.util.List;

public class Customer {

    private String firstName;
    private String lastName;
    private Address Address;
    private int phoneNumber;
    private String email;
    private List<Image> imagesList;
    private List<Treatment> treatmentList;
    private List<Contract> contractList;
    private Image customerImage;

    public Customer(String firstName, String lastName, Address address, int phoneNumber, String email, List<Image> imagesList, List<Treatment> treatmentList, List<Contract> contractList, Image customerImage) {
        this.firstName = firstName;
        this.lastName = lastName;
        Address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.imagesList = imagesList;
        this.treatmentList = treatmentList;
        this.contractList = contractList;
        this.customerImage = customerImage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public com.biton.rut.cosmetician_app.Address getAddress() {
        return Address;
    }

    public void setAddress(com.biton.rut.cosmetician_app.Address address) {
        Address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Image> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<Image> imagesList) {
        this.imagesList = imagesList;
    }

    public List<Treatment> getTreatmentList() {
        return treatmentList;
    }

    public void setTreatmentList(List<Treatment> treatmentList) {
        this.treatmentList = treatmentList;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public Image getCustomerImage() {
        return customerImage;
    }

    public void setCustomerImage(Image customerImage) {
        this.customerImage = customerImage;
    }
}
