package com.eale.drugs.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 药物类别
 */
@Entity
@Table(name="drugs_manage_drug_cate")
public class DrugCate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id")
    private Long cateId;//类别id

    @Column(name = "cate_name")
    private String cateName;//名称

    @Column(name = "create_date")
    private Timestamp createDate;//创建时间

    @Column(name = "create_userid")
    private Long createUserid;//创建人

    @Column(name = "update_date")
    private Timestamp updateDate;//修改时间

    @Column(name = "update_userid")
    private Long updateUserid;//修改人

    public DrugCate() {
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
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
        return "DrugCate [cateId=" + cateId + ", cateName=" + cateName + ", createDate=" + createDate + ", createUserid="
                + createUserid + ", updateDate=" + updateDate + ", updateUserid=" + updateUserid + "]";
    }
}