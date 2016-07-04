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
 * ServiceImpl object for domain model class DocumentHeaders.
 * @see com.smsinternal.sms.DocumentHeaders
 */
@Service("SMS.DocumentHeadersService")
public class DocumentHeadersServiceImpl implements DocumentHeadersService {


    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentHeadersServiceImpl.class);

    @Autowired
    @Qualifier("SMS.DocumentHeadersDao")
    private WMGenericDao<DocumentHeaders, DocumentHeadersId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<DocumentHeaders, DocumentHeadersId> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "SMSTransactionManager")
     public Page<DocumentHeaders> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "SMSTransactionManager")
    @Override
    public DocumentHeaders create(DocumentHeaders documentheaders) {
        LOGGER.debug("Creating a new documentheaders with information: {}" , documentheaders);
        return this.wmGenericDao.create(documentheaders);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "SMSTransactionManager")
    @Override
    public DocumentHeaders delete(DocumentHeadersId documentheadersId) throws EntityNotFoundException {
        LOGGER.debug("Deleting documentheaders with id: {}" , documentheadersId);
        DocumentHeaders deleted = this.wmGenericDao.findById(documentheadersId);
        if (deleted == null) {
            LOGGER.debug("No documentheaders found with id: {}" , documentheadersId);
            throw new EntityNotFoundException(String.valueOf(documentheadersId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "SMSTransactionManager")
    @Override
    public Page<DocumentHeaders> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all documentheaderss");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "SMSTransactionManager")
    @Override
    public Page<DocumentHeaders> findAll(Pageable pageable) {
        LOGGER.debug("Finding all documentheaderss");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "SMSTransactionManager")
    @Override
    public DocumentHeaders findById(DocumentHeadersId id) throws EntityNotFoundException {
        LOGGER.debug("Finding documentheaders by id: {}" , id);
        DocumentHeaders documentheaders=this.wmGenericDao.findById(id);
        if(documentheaders==null){
            LOGGER.debug("No documentheaders found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return documentheaders;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "SMSTransactionManager")
    @Override
    public DocumentHeaders update(DocumentHeaders updated) throws EntityNotFoundException {
        LOGGER.debug("Updating documentheaders with information: {}" , updated);
        this.wmGenericDao.update(updated);

        DocumentHeadersId id = new DocumentHeadersId();
        id.setId(updated.getId());
        id.setColumnName(updated.getColumnName());
        id.setHeaderInfo(updated.getHeaderInfo());
        id.setTableName(updated.getTableName());

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "SMSTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

