package com.eale.drugs.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 入库信息
 */
@Entity
@Table(name = "drugs_manage_drug_incoming_info")
public class DrugIncomingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "incominginfo_id")
    private Long incominginfoId;//id

    @Column(name = "drugs_id")
    private Long drugsId;//yaopinid

    @Column(name = "incominginfo_number")
    private Long incominginfoNumber;

    @Column(name = "incominginfo_price")
    private Double incominginfoPrice;//入库价格

    @Column(name = "incominginfo_remark")
    private String incominginfoRemark;//备注

    @Column(name = "supplier_id")
    private Long supplierId;//供应商id

    @Column(name = "create_date")
    private Timestamp createDate;//创建时间

    @Column(name = "create_userid")
    private Long createUserid;//创建人

    @Column(name = "update_date")
    private Timestamp updateDate;//修改时间

    @Column(name = "update_userid")
    private Long updateUserid;//修改人
    public DrugIncomingInfo(){}

    public Long getIncominginfoId() {
        return incominginfoId;
    }

    public void setIncominginfoId(Long incominginfoId) {
        this.incominginfoId = incominginfoId;
    }

    public Long getDrugsId() {
        return drugsId;
    }

    public void setDrugsId(Long drugsId) {
        this.drugsId = drugsId;
    }

    public Long getIncominginfoNumber() {
        return incominginfoNumber;
    }

    public void setIncominginfoNumber(Long incominginfoNumber) {
        this.incominginfoNumber = incominginfoNumber;
    }

    public Double getIncominginfoPrice() {
        return incominginfoPrice;
    }

    public void setIncominginfoPrice(Double incominginfoPrice) {
        this.incominginfoPrice = incominginfoPrice;
    }

    public String getIncominginfoRemark() {
        return incominginfoRemark;
    }

    public void setIncominginfoRemark(String incominginfoRemark) {
        this.incominginfoRemark = incominginfoRemark;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Long createUserid) {
        this.createUserid = createUserid;
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
        return "DrugIncomingInfo{" +
                "incominginfoId=" + incominginfoId +
                ", drugsId='" + drugsId + '\'' +
                ", incominginfoNumber='" + incominginfoNumber + '\'' +
                ", incominginfoPrice='" + incominginfoPrice + '\'' +
                ", incominginfoRemark='" + incominginfoRemark + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", createDate='" + createDate + '\'' +
                ", createUserid=" + createUserid +
                ", updateDate='" + updateDate + '\'' +
                ", updateUserid='" + updateUserid + '\'' +
                '}';
    }

}
