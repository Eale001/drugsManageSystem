package com.eale.drugs.common;

import com.eale.drugs.bean.*;
import com.eale.drugs.service.DrugsService;

public class DrgusVO {

    private Drugs drugs;

    private DrugDeliveryInfo data;

    private DrugIncomingInfo drugIncomingInfo;

    private DrugSupplier drugSupplier;

    private DrugInventoryInfo drugInventoryInfo;

    private DrugSaleInfo drugSaleInfo;

    private DrugCate drugCate;

    private String userName;

    public DrgusVO() {
    }

    public Drugs getDrugs() {
        return drugs;
    }

    public void setDrugs(Drugs drugs) {
        this.drugs = drugs;
    }

    public DrugDeliveryInfo getData() {
        return data;
    }

    public void setData(DrugDeliveryInfo data) {
        this.data = data;
    }

    public DrugIncomingInfo getDrugIncomingInfo() {
        return drugIncomingInfo;
    }

    public void setDrugIncomingInfo(DrugIncomingInfo drugIncomingInfo) {
        this.drugIncomingInfo = drugIncomingInfo;
    }

    public DrugSupplier getDrugSupplier() {
        return drugSupplier;
    }

    public void setDrugSupplier(DrugSupplier drugSupplier) {
        this.drugSupplier = drugSupplier;
    }

    public DrugInventoryInfo getDrugInventoryInfo() {
        return drugInventoryInfo;
    }

    public void setDrugInventoryInfo(DrugInventoryInfo drugInventoryInfo) {
        this.drugInventoryInfo = drugInventoryInfo;
    }

    public DrugSaleInfo getDrugSaleInfo() {
        return drugSaleInfo;
    }

    public void setDrugSaleInfo(DrugSaleInfo drugSaleInfo) {
        this.drugSaleInfo = drugSaleInfo;
    }

    public DrugCate getDrugCate() {
        return drugCate;
    }

    public void setDrugCate(DrugCate drugCate) {
        this.drugCate = drugCate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
