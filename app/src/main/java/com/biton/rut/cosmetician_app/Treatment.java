package com.biton.rut.cosmetician_app;
import android.media.Image;

import java.util.Date;
import java.util.List;

public class Treatment {

    private Date date;
    private Customer customerTreatment;
    private TREATMENT_TYPE treatment_type;
    private MACHINE_TYPE machine_type;
    private ColorTreatment colorTreatment;
    private List<Image> treatmentImages;
    private float treatmentCost;

    public Treatment(Date date, Customer customerTreatment, TREATMENT_TYPE treatment_type, MACHINE_TYPE machine_type, ColorTreatment colorTreatment, List<Image> treatmentImages, float treatmentCost) {
        this.date = date;
        this.customerTreatment = customerTreatment;
        this.treatment_type = treatment_type;
        this.machine_type = machine_type;
        this.colorTreatment = colorTreatment;
        this.treatmentImages = treatmentImages;
        this.treatmentCost = treatmentCost;
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

    public TREATMENT_TYPE getTreatment_type() {
        return treatment_type;
    }

    public void setTreatment_type(TREATMENT_TYPE treatment_type) {
        this.treatment_type = treatment_type;
    }

    public MACHINE_TYPE getMachine_type() {
        return machine_type;
    }

    public void setMachine_type(MACHINE_TYPE machine_type) {
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
