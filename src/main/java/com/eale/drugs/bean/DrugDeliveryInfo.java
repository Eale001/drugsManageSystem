package com.eale.drugs.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 出库信息
 */

@Entity
@Table(name = "drugs_manage_drug_delivery_info")
public class DrugDeliveryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deliveryinfo_id")
    private Long deliveryinfoId;//id


    @Column(name = "drugs_id")
    private Long drugsId;//药品id

    @Column(name = "deliveryinfo_number")
    private Long deliveryinfoNumber;//出库数量

    @Column(name = "deliveryinfo_price")
    private Double deliveryinfoPrice;//出库价格

    @Column(name = "deliveryinfo_remark")
    private String deliveryinfoRemark;//备注

    @Column(name = "create_date")
    private Timestamp createDate;//创建时间

    @Column(name = "create_userid")
    private Long createUserid;//创建人

    @Column(name = "update_date")
    private Timestamp updateDate;//修改时间

    @Column(name = "update_userid")
    private Long updateUserid;//修改人

    public DrugDeliveryInfo(){}

    public Long getDeliveryinfoId() {
        return deliveryinfoId;
    }

    public void setDeliveryinfoId(Long deliveryinfoId) {
        this.deliveryinfoId = deliveryinfoId;
    }

    public Long getDrugsId() {
        return drugsId;
    }

    public void setDrugsId(Long drugsId) {
        this.drugsId = drugsId;
    }

    public Long getDeliveryinfoNumber() {
        return deliveryinfoNumber;
    }

    public void setDeliveryinfoNumber(Long deliveryinfoNumber) {
        this.deliveryinfoNumber = deliveryinfoNumber;
    }

    public Double getDeliveryinfoPrice() {
        return deliveryinfoPrice;
    }

    public void setDeliveryinfoPrice(Double deliveryinfoPrice) {
        this.deliveryinfoPrice = deliveryinfoPrice;
    }

    public String getDeliveryinfoRemark() {
        return deliveryinfoRemark;
    }

    public void setDeliveryinfoRemark(String deliveryinfoRemark) {
        this.deliveryinfoRemark = deliveryinfoRemark;
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
        return "DrugDeliveryInfo{" +
                "deliveryinfoId=" + deliveryinfoId +
                ", drugsId='" + drugsId + '\'' +
                ", deliveryinfoNumber='" + deliveryinfoNumber + '\'' +
                ", deliveryinfoPrice='" + deliveryinfoPrice + '\'' +
                ", deliveryinfoRemark='" + deliveryinfoRemark + '\'' +
                ", createDate='" + createDate + '\'' +
                ", createUserid=" + createUserid +
                ", updateDate='" + updateDate + '\'' +
                ", updateUserid='" + updateUserid + '\'' +
                '}';
    }
}
