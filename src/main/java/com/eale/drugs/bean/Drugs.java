package com.eale.drugs.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 药品信息
 */

@Entity
@Table(name = "drugs_manage_drugs")
public class Drugs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drugs_id")
    private Long drugsId;//id

    @Column(name = "drugs_name")
    private String drugsName;//名称

    @Column(name = "cate_id")
    private Long cateId;//类别id

    @Column(name = "drugs_picture")
    private String drugsPicture;//图片

    @Column(name = "drugs_price")
    private Double drugsPrice;//价格

    @Column(name = "drugs_remark")
    private String drugsRemark;//备注

    @Column(name = "create_date")
    private Timestamp createDate;//创建时间

    @Column(name = "create_userid")
    private Long createUserid;//创建人

    @Column(name = "update_date")
    private Timestamp updateDate;//修改时间

    @Column(name = "update_userid")
    private Long updateUserid;//修改人

    public Drugs(){}

    public Long getDrugsId() {
        return drugsId;
    }

    public void setDrugsId(Long drugsId) {
        this.drugsId = drugsId;
    }

    public String getDrugsName() {
        return drugsName;
    }

    public void setDrugsName(String drugsName) {
        this.drugsName = drugsName;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getDrugsPicture() {
        return drugsPicture;
    }

    public void setDrugsPicture(String drugsPicture) {
        this.drugsPicture = drugsPicture;
    }

    public Double getDrugsPrice() {
        return drugsPrice;
    }

    public void setDrugsPrice(Double drugsPrice) {
        this.drugsPrice = drugsPrice;
    }

    public String getDrugsRemark() {
        return drugsRemark;
    }

    public void setDrugsRemark(String drugsRemark) {
        this.drugsRemark = drugsRemark;
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
        return "Drugs [drugsId=" + drugsId + ", drugsName=" + drugsName + ", cateId=" + cateId + ", drugsPicture="
                + drugsPicture + ", drugsPrice=" + drugsPrice + ", drugsRemark=" + drugsRemark + ", createDate=" + createDate + ", createUserid="
                + createUserid + ", updateDate=" + updateDate + ", updateUserid=" + updateUserid + "]";
}
}
