/*Copyright (c) 2016-2017 jjrichards.com.au All Rights Reserved.
 This software is the confidential and proprietary information of jjrichards.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with jjrichards.com.au*/

package com.smsinternal.sms;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * WorkersCompensation generated by hbm2java
 */
@Entity
@Table(name="`WorkersCompensation`"
    ,schema="dbo"
)

public class WorkersCompensation  implements java.io.Serializable {

    
    private Integer id;
    
    private String policyNo;
    
    private Date expiryDate;
    
    private Boolean company;
    
    private String insuranceCompany;
    
    private Double limit;
    
    private States states;
    
    private Suppliers suppliers;

    public WorkersCompensation() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`ID`", precision=10)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    

    @Column(name="`PolicyNo`")
    public String getPolicyNo() {
        return this.policyNo;
    }
    
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    @Temporal(TemporalType.DATE)

    @Column(name="`ExpiryDate`", length=10)
    public Date getExpiryDate() {
        return this.expiryDate;
    }
    
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    

    @Column(name="`Company`")
    public Boolean getCompany() {
        return this.company;
    }
    
    public void setCompany(Boolean company) {
        this.company = company;
    }

    

    @Column(name="`InsuranceCompany`")
    public String getInsuranceCompany() {
        return this.insuranceCompany;
    }
    
    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    

    @Column(name="`Limit`", scale=4)
    public Double getLimit() {
        return this.limit;
    }
    
    public void setLimit(Double limit) {
        this.limit = limit;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`StateID`")
    public States getStates() {
        return this.states;
    }
    
    public void setStates(States states) {
        this.states = states;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`SupplierID`")
    public Suppliers getSuppliers() {
        return this.suppliers;
    }
    
    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof WorkersCompensation) )
		    return false;

		 WorkersCompensation that = (WorkersCompensation) o;

		 return ( (this.getId()==that.getId()) || ( this.getId()!=null && that.getId()!=null && this.getId().equals(that.getId()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );

         return result;
    }


}

