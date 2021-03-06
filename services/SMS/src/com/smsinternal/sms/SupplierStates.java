/*Copyright (c) 2016-2017 jjrichards.com.au All Rights Reserved.
 This software is the confidential and proprietary information of jjrichards.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with jjrichards.com.au*/

package com.smsinternal.sms;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * SupplierStates generated by hbm2java
 */
@Entity
@Table(name="`SupplierStates`"
    ,schema="dbo"
)
@IdClass(value=SupplierStatesId.class)
public class SupplierStates  implements java.io.Serializable {

    
    private Integer id;
    
    private Integer supplierId;
    
    private Integer statesId;
    
    private States states;
    
    private Suppliers suppliers;

    public SupplierStates() {
    }


    @Id 
    

    @Column(name="`ID`", insertable=false, updatable=false, precision=10)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    @Id 
    

    @Column(name="`SupplierID`", insertable=false, updatable=false, precision=10)
    public Integer getSupplierId() {
        return this.supplierId;
    }
    
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }
    @Id 
    

    @Column(name="`StatesID`", insertable=false, updatable=false, precision=10)
    public Integer getStatesId() {
        return this.statesId;
    }
    
    public void setStatesId(Integer statesId) {
        this.statesId = statesId;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`StatesID`", insertable=false, updatable=false)
    public States getStates() {
        return this.states;
    }
    
    public void setStates(States states) {
        
        this.statesId = states.getId();
      
        this.states = states;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`SupplierID`", insertable=false, updatable=false)
    public Suppliers getSuppliers() {
        return this.suppliers;
    }
    
    public void setSuppliers(Suppliers suppliers) {
        
        this.supplierId = suppliers.getId();
      
        this.suppliers = suppliers;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof SupplierStates) )
		    return false;

		 SupplierStates that = (SupplierStates) o;

         return ( (this.getId()==that.getId()) || ( this.getId()!=null && that.getId()!=null && this.getId().equals(that.getId()) ) )
 && ( (this.getSupplierId()==that.getSupplierId()) || ( this.getSupplierId()!=null && that.getSupplierId()!=null && this.getSupplierId().equals(that.getSupplierId()) ) )
 && ( (this.getStatesId()==that.getStatesId()) || ( this.getStatesId()!=null && that.getStatesId()!=null && this.getStatesId().equals(that.getStatesId()) ) )
 && ( (this.getStates()==that.getStates()) || ( this.getStates()!=null && that.getStates()!=null && this.getStates().equals(that.getStates()) ) )
 && ( (this.getSuppliers()==that.getSuppliers()) || ( this.getSuppliers()!=null && that.getSuppliers()!=null && this.getSuppliers().equals(that.getSuppliers()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getSupplierId() == null ? 0 : this.getSupplierId().hashCode() );
         result = 37 * result + ( getStatesId() == null ? 0 : this.getStatesId().hashCode() );
         result = 37 * result + ( getStates() == null ? 0 : this.getStates().hashCode() );
         result = 37 * result + ( getSuppliers() == null ? 0 : this.getSuppliers().hashCode() );

         return result;
    }


}

