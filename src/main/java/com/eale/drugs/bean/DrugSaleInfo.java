package com.eale.drugs.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 销售信息
 */

@Entity
@Table(name = "drugs_manage_drug_sale_info")
public class DrugSaleInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saleinfo_id")
    private Long saleinfoId;//id

    @Column(name = "drugs_id")
    private Long drugsId;//药品信息id

    @Column(name = "saleinfo_number")
    private Long saleinfoNumber;//销售数量

    @Column(name = "saleinfo_price")
    private Double saleinfoPrice;//销售价格

    @Column(name = "sale_date")
    private Timestamp saleDate;//销售时间

    @Column(name = "sale_userid")
    private Long saleUserid;//销售人员

    @Column(name = "update_date")
    private Timestamp updateDate;//修改时间

    @Column(name = "update_userid")
    private Long updateUserid;//修改人员

    public DrugSaleInfo() {
    }

    public Long getSaleinfoId() {
        return saleinfoId;
    }

    public void setSaleinfoId(Long saleinfoId) {
        this.saleinfoId = saleinfoId;
    }

    public Long getDrugsId() {
        return drugsId;
    }

    public void setDrugsId(Long drugsId) {
        this.drugsId = drugsId;
    }

    public Long getSaleinfoNumber() {
        return saleinfoNumber;
    }

    public void setSaleinfoNumber(Long saleinfoNumber) {
        this.saleinfoNumber = saleinfoNumber;
    }

    public Double getSaleinfoPrice() {
        return saleinfoPrice;
    }

    public void setSaleinfoPrice(Double saleinfoPrice) {
        this.saleinfoPrice = saleinfoPrice;
    }

    public Timestamp getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Timestamp saleDate) {
        this.saleDate = saleDate;
    }

    public Long getSaleUserid() {
        return saleUserid;
    }

    public void setSaleUserid(Long saleUserid) {
        this.saleUserid = saleUserid;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Long getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Long updateUserid) {
        this.updateUserid = updateUserid;
    }

    @Override
    public String toString() {
        return "DrugSaleInfo{" +
                "saleinfoId=" + saleinfoId +
                ", drugsId='" + drugsId + '\'' +
                ", saleinfoNumber='" + saleinfoNumber + '\'' +
                ", saleinfoPrice='" + saleinfoPrice + '\'' +
                ", saleDate='" + saleDate + '\'' +
                ", saleUserid=" + saleUserid +
                ", updateDate='" + updateDate + '\'' +
                ", updateUserid='" + updateUserid + '\'' +
                '}';
    }
}