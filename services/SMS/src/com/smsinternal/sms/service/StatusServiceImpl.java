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
 * ServiceImpl object for domain model class Status.
 * @see com.smsinternal.sms.Status
 */
@Service("SMS.StatusService")
public class StatusServiceImpl implements StatusService {


    private static final Logger LOGGER = LoggerFactory.getLogger(StatusServiceImpl.class);

    @Autowired
    @Qualifier("SMS.StatusDao")
    private WMGenericDao<Status, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Status, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "SMSTransactionManager")
     public Page<Status> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "SMSTransactionManager")
    @Override
    public Status create(Status status) {
        LOGGER.debug("Creating a new status with information: {}" , status);
        return this.wmGenericDao.create(status);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "SMSTransactionManager")
    @Override
    public Status delete(Integer statusId) throws EntityNotFoundException {
        LOGGER.debug("Deleting status with id: {}" , statusId);
        Status deleted = this.wmGenericDao.findById(statusId);
        if (deleted == null) {
            LOGGER.debug("No status found with id: {}" , statusId);
            throw new EntityNotFoundException(String.valueOf(statusId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "SMSTransactionManager")
    @Override
    public Page<Status> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all statuss");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "SMSTransactionManager")
    @Override
    public Page<Status> findAll(Pageable pageable) {
        LOGGER.debug("Finding all statuss");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "SMSTransactionManager")
    @Override
    public Status findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding status by id: {}" , id);
        Status status=this.wmGenericDao.findById(id);
        if(status==null){
            LOGGER.debug("No status found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return status;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "SMSTransactionManager")
    @Override
    public Status update(Status updated) throws EntityNotFoundException {
        LOGGER.debug("Updating status with information: {}" , updated);
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


