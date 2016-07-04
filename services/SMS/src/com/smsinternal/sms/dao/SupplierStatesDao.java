/*Copyright (c) 2016-2017 jjrichards.com.au All Rights Reserved.
 This software is the confidential and proprietary information of jjrichards.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with jjrichards.com.au*/

package com.smsinternal.sms.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.smsinternal.sms.*;
/**
* Specifies methods used to obtain and modify SupplierStates related information
* which is stored in the database.
*/
@Repository("SMS.SupplierStatesDao")
public class SupplierStatesDao extends WMGenericDaoImpl <SupplierStates, SupplierStatesId> {

    @Autowired
    @Qualifier("SMSTemplate")
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return this.template;
    }
}

