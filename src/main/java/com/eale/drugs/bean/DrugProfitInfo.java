package com.eale.drugs.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 利润信息
 */
@Entity
@Table(name = "drugs_manage_drug_profit_info")
public class DrugProfitInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profitinfo_id")
    private Long profitinfoId;//id

    @Column(name = "drugs_id")
    private Long drugsId;//药品id

    @Column(name = "profitinfo_purchase")
    private Double profitinfoPurchase;//进价

    @Column(name = "profitinfo_sell")
    private Double profitinfoSell;//售价

    @Column(name = "profitinfo_month")
    private String profitinfoMonth;//月份

    @Column(name = "saleinfo_number")
    private Long saleinfoNumber;//销售量

    @Column(name = "profitinfo_return")
    private Double profitinfoReturn;//药品销售利润


    @Column(name = "create_date")
    private Timestamp createDate;//创建时间

    @Column(name = "create_userid")
    private Long createUserid;//创建人

    @Column(name = "update_date")
    private Timestamp updateDate;//修改时间

    @Column(name = "update_userid")
    private Long updateUserid;//修改人

    public DrugProfitInfo(){}

    public Long getProfitinfoId() {
        return profitinfoId;
    }

    public void setProfitinfoId(Long profitinfoId) {
        this.profitinfoId = profitinfoId;
    }

    public Long getDrugsId() {
        return drugsId;
    }

    public void setDrugsId(Long drugsId) {
        this.drugsId = drugsId;
    }

    public Double getProfitinfoPurchase() {
        return profitinfoPurchase;
    }

    public void setProfitinfoPurchase(Double profitinfoPurchase) {
        this.profitinfoPurchase = profitinfoPurchase;
    }

    public Double getProfitinfoSell() {
        return profitinfoSell;
    }

    public void setProfitinfoSell(Double profitinfoSell) {
        this.profitinfoSell = profitinfoSell;
    }

    public String getProfitinfoMonth() {
        return profitinfoMonth;
    }

    public void setProfitinfoMonth(String profitinfoMonth) {
        this.profitinfoMonth = profitinfoMonth;
    }

    public Long getSaleinfoNumber() {
        return saleinfoNumber;
    }

    public void setSaleinfoNumber(Long saleinfoNumber) {
        this.saleinfoNumber = saleinfoNumber;
    }

    public Double getProfitinfoReturn() {
        return profitinfoReturn;
    }

    public void setProfitinfoReturn(Double profitinfoReturn) {
        this.profitinfoReturn = profitinfoReturn;
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
        return "DrugProfitInfo{" +
                "profitinfoId=" + profitinfoId +
                ", drugsId='" + drugsId + '\'' +
                ", profitinfoPurchase='" + profitinfoPurchase + '\'' +
                ", profitinfoSell='" + profitinfoSell + '\'' +
                ", profitinfoMonth='" + profitinfoMonth + '\'' +
                ", saleinfoNumber='" + saleinfoNumber + '\'' +
                ", profitinfoReturn='" + profitinfoReturn + '\'' +
                ", createDate='" + createDate + '\'' +
                ", createUserid=" + createUserid +
                ", updateDate='" + updateDate + '\'' +
                ", updateUserid='" + updateUserid + '\'' +
                '}';
    }


}
