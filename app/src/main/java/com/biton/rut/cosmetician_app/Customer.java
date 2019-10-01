package com.biton.rut.cosmetician_app;

import android.media.Image;

import java.util.List;

public class Customer {

    private String firstName;
    private String lastName;
    private Address Address;
    private String phoneNumber; // why not string?????????????? can be as string
    private String email;//primary key?????????????????/ no - the phone number is a primary key
    private List<Image> imagesList;
    private List<Treatment> treatmentList;
    private List<Contract> contractList;
    private byte[] customerImage;
    private boolean favorite; // true

    public Customer(String firstName, String lastName, Address address, String phoneNumber, String email, List<Image> imagesList, List<Treatment> treatmentList, List<Contract> contractList, byte[] customerImage) {
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

    public Customer(String firstName, String lastName, String address, String phoneNumber, String email, byte[] customerImage) {
        this.firstName = firstName;
        this.lastName = lastName;
        Address = null;// ???????????????????????????????????
        this.phoneNumber = "0583298226";//????????????
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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

    public byte[] getCustomerImage() {
        return customerImage;
    }

    public void setCustomerImage(byte[] customerImage) {
        this.customerImage = customerImage;
    }

    public String getName(){
      return this.firstName +" " + this.lastName;
    }

    public String getTreatDate() {
        return "12/12/12";
    }
    public boolean getIsFavorite() {
        return this.favorite;
    }
    public  boolean haveTreatments() {
        return true;
    }

    public boolean haveContract() {
        return  true;
    }
}
