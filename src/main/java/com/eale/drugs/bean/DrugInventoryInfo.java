package com.eale.drugs.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 库存信息
 */
@Entity
@Table(name = "drugs_manage_drug_inventory_info")
public class DrugInventoryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventoryinfo_id")
    private Long inventoryinfoId;//id

    @Column(name = "drugs_id")
    private Long drugsId;//药品id

    @Column(name = "inventoryinfo_number")
    private Long inventoryinfoNumber;//库存量

    @Column(name = "create_date")
    private Timestamp createDate;//创建时间

    @Column(name = "create_userid")
    private Long createUserid;//创建人

    @Column(name = "update_date")
    private Timestamp updateDate;//修改时间

    @Column(name = "update_userid")
    private Long updateUserid;//修改人

    public DrugInventoryInfo(){}

    public Long getInventoryinfoId() {
        return inventoryinfoId;
    }

    public void setInventoryinfoId(Long inventoryinfoId) {
        this.inventoryinfoId = inventoryinfoId;
    }

    public Long getDrugsId() {
        return drugsId;
    }

    public void setDrugsId(Long drugsId) {
        this.drugsId = drugsId;
    }

    public Long getInventoryinfoNumber() {
        return inventoryinfoNumber;
    }

    public void setInventoryinfoNumber(Long inventoryinfoNumber) {
        this.inventoryinfoNumber = inventoryinfoNumber;
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
        return "DrugInventoryInfo{" +
                "inventoryinfoId=" + inventoryinfoId +
                ", drugsId='" + drugsId + '\'' +
                ", inventoryinfoNumber='" + inventoryinfoNumber+ '\'' +
                ", createDate='" + createDate + '\'' +
                ", createUserid=" + createUserid +
                ", updateDate='" + updateDate + '\'' +
                ", updateUserid='" + updateUserid + '\'' +
                '}';
    }

}
