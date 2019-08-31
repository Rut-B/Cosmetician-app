package com.biton.rut.cosmetician_app;

public class Address {

    private String streetAddress;
    private String cityAddress;
    private int buildingNumber;
    private int apartmentNumber;

    public Address(String streetAddress, String cityAddress, int buildingNumber, int apartmentNumber) {
        this.streetAddress = streetAddress;
        this.cityAddress = cityAddress;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
    }
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCityAddress() {
        return cityAddress;
    }

    public void setCityAddress(String cityAddress) {
        this.cityAddress = cityAddress;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
}
