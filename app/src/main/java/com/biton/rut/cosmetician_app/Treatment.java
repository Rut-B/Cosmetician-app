package com.biton.rut.cosmetician_app;
import android.media.Image;
import android.widget.ImageView;

import java.util.Date;
import java.util.List;

public class Treatment {

    private Date date;
    private Customer customerTreatment;
    private String treatment_type;
    private String machine_type;
    private ColorTreatment colorTreatment;
    private List<Image> treatmentImages;
    private float treatmentCost;
    private  byte[] treatmentImage;

    public Treatment(Date date, Customer customerTreatment, String treatment_type, String machine_type, ColorTreatment colorTreatment, List<Image> treatmentImages, float treatmentCost, byte[] treatmentImage) {
        this.date = date;
        this.customerTreatment = customerTreatment;
        this.treatment_type = treatment_type;
        this.machine_type = machine_type;
        this.colorTreatment = colorTreatment;
        this.treatmentImages = treatmentImages;
        this.treatmentCost = treatmentCost;
        this.treatmentImage = treatmentImage;
    }
    public byte[] getTreatmentImage() {
        return treatmentImage;
    }

    public void setTreatmentImage(byte[] treatmentImage) {
        this.treatmentImage = treatmentImage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomerTreatment() {
        return customerTreatment;
    }

    public void setCustomerTreatment(Customer customerTreatment) {
        this.customerTreatment = customerTreatment;
    }

    public String getTreatment_type() {
        return treatment_type;
    }

    public void setTreatment_type(String treatment_type) {
        this.treatment_type = treatment_type;
    }

    public String getMachine_type() {
        return machine_type;
    }

    public void setMachine_type(String machine_type) {
        this.machine_type = machine_type;
    }

    public ColorTreatment getColorTreatment() {
        return colorTreatment;
    }

    public void setColorTreatment(ColorTreatment colorTreatment) {
        this.colorTreatment = colorTreatment;
    }

    public List<Image> getTreatmentImages() {
        return treatmentImages;
    }

    public void setTreatmentImages(List<Image> treatmentImages) {
        this.treatmentImages = treatmentImages;
    }

    public float getTreatmentCost() {
        return treatmentCost;
    }

    public void setTreatmentCost(float treatmentCost) {
        this.treatmentCost = treatmentCost;
    }
}
