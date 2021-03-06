/*Copyright (c) 2016-2017 jjrichards.com.au All Rights Reserved.
 This software is the confidential and proprietary information of jjrichards.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with jjrichards.com.au*/

package com.smsinternal.sms.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.*;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.smsinternal.sms.*;


/**
 * ServiceImpl object for domain model class WorkersCompensation.
 * @see com.smsinternal.sms.WorkersCompensation
 */
@Service("SMS.WorkersCompensationService")
public class WorkersCompensationServiceImpl implements WorkersCompensationService {


    private static final Logger LOGGER = LoggerFactory.getLogger(WorkersCompensationServiceImpl.class);

    @Autowired
    @Qualifier("SMS.WorkersCompensationDao")
    private WMGenericDao<WorkersCompensation, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<WorkersCompensation, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "SMSTransactionManager")
     public Page<WorkersCompensation> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "SMSTransactionManager")
    @Override
    public WorkersCompensation create(WorkersCompensation workerscompensation) {
        LOGGER.debug("Creating a new workerscompensation with information: {}" , workerscompensation);
        return this.wmGenericDao.create(workerscompensation);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "SMSTransactionManager")
    @Override
    public WorkersCompensation delete(Integer workerscompensationId) throws EntityNotFoundException {
        LOGGER.debug("Deleting workerscompensation with id: {}" , workerscompensationId);
        WorkersCompensation deleted = this.wmGenericDao.findById(workerscompensationId);
        if (deleted == null) {
            LOGGER.debug("No workerscompensation found with id: {}" , workerscompensationId);
            throw new EntityNotFoundException(String.valueOf(workerscompensationId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "SMSTransactionManager")
    @Override
    public Page<WorkersCompensation> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all workerscompensations");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "SMSTransactionManager")
    @Override
    public Page<WorkersCompensation> findAll(Pageable pageable) {
        LOGGER.debug("Finding all workerscompensations");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "SMSTransactionManager")
    @Override
    public WorkersCompensation findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding workerscompensation by id: {}" , id);
        WorkersCompensation workerscompensation=this.wmGenericDao.findById(id);
        if(workerscompensation==null){
            LOGGER.debug("No workerscompensation found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return workerscompensation;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "SMSTransactionManager")
    @Override
    public WorkersCompensation update(WorkersCompensation updated) throws EntityNotFoundException {
        LOGGER.debug("Updating workerscompensation with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getId();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "SMSTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


