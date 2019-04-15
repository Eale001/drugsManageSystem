package com.eale.drugs.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 供应商
 */

@Entity
@Table(name = "drugs_manage_drug_supplier")
public class DrugSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long supplierId;//id

    @Column(name = "supplier_name")
    private String supplierName;//名称

    @Column(name = "supplier_address")
    private String supplierAddress;//地址

    @Column(name = "supplier_phone")
    private String supplierPhone;//电话

    @Column(name ="supplier_remark")
    private String supplierRemark;//备注

    @Column(name = "create_date")
    private Timestamp createDate;//创建时间

    @Column(name = "create_userid")
    private Long createUserid;//创建人

    @Column(name = "update_date")
    private Timestamp updateDate;//修改时间

    @Column(name = "update_userid")
    private Long updateUserid;//修改人


    public DrugSupplier(){}

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierRemark() {
        return supplierRemark;
    }

    public void setSupplierRemark(String supplierRemark) {
        this.supplierRemark = supplierRemark;
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
        return "DrugSupplier{" +
                "supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                ", supplierPhone='" + supplierPhone + '\'' +
                ", supplierRemark='" + supplierRemark + '\'' +
                ", createDate='" + createDate + '\'' +
                ", createUserid=" + createUserid +
                ", updateDate='" + updateDate + '\'' +
                ", updateUserid='" + updateUserid + '\'' +
                '}';

}
}
