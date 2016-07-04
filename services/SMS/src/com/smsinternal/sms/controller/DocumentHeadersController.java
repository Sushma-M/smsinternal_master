/*Copyright (c) 2016-2017 jjrichards.com.au All Rights Reserved.
 This software is the confidential and proprietary information of jjrichards.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with jjrichards.com.au*/
package com.smsinternal.sms.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.smsinternal.sms.service.DocumentHeadersService;
import org.springframework.web.bind.annotation.RequestBody;
import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.TypeMismatchException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wordnik.swagger.annotations.*;
import com.smsinternal.sms.*;
import com.smsinternal.sms.service.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class DocumentHeaders.
 * @see com.smsinternal.sms.DocumentHeaders
 */
@RestController(value = "SMS.DocumentHeadersController")
@RequestMapping("/SMS/DocumentHeaders")
@Api(description = "Exposes APIs to work with DocumentHeaders resource.", value = "DocumentHeadersController")
public class DocumentHeadersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentHeadersController.class);

    @Autowired
    @Qualifier("SMS.DocumentHeadersService")
    private DocumentHeadersService documentHeadersService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of DocumentHeaders instances matching the search criteria.")
    public Page<DocumentHeaders> findDocumentHeaderss(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering DocumentHeaderss list");
        return documentHeadersService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of DocumentHeaders instances.")
    public Page<DocumentHeaders> getDocumentHeaderss(Pageable pageable) {
        LOGGER.debug("Rendering DocumentHeaderss list");
        return documentHeadersService.findAll(pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setDocumentHeadersService(DocumentHeadersService service) {
        this.documentHeadersService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new DocumentHeaders instance.")
    public DocumentHeaders createDocumentHeaders(@RequestBody DocumentHeaders instance) {
        LOGGER.debug("Create DocumentHeaders with information: {}", instance);
        instance = documentHeadersService.create(instance);
        LOGGER.debug("Created DocumentHeaders with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the DocumentHeaders instance associated with the given composite-id.")
    public DocumentHeaders getDocumentHeaders(@RequestParam(value = "id", required = true) Integer id, @RequestParam(value = "columnName", required = true) String columnName, @RequestParam(value = "headerInfo", required = true) String headerInfo, @RequestParam(value = "tableName", required = true) String tableName) throws EntityNotFoundException {
        DocumentHeadersId temp = new DocumentHeadersId();
        temp.setId(id);
        temp.setColumnName(columnName);
        temp.setHeaderInfo(headerInfo);
        temp.setTableName(tableName);
        LOGGER.debug("Getting DocumentHeaders with id: {}", temp);
        DocumentHeaders instance = documentHeadersService.findById(temp);
        LOGGER.debug("DocumentHeaders details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the DocumentHeaders instance associated with the given composite-id.")
    public DocumentHeaders editDocumentHeaders(@RequestParam(value = "id", required = true) Integer id, @RequestParam(value = "columnName", required = true) String columnName, @RequestParam(value = "headerInfo", required = true) String headerInfo, @RequestParam(value = "tableName", required = true) String tableName, @RequestBody DocumentHeaders instance) throws EntityNotFoundException {
        DocumentHeadersId temp = new DocumentHeadersId();
        temp.setId(id);
        temp.setColumnName(columnName);
        temp.setHeaderInfo(headerInfo);
        temp.setTableName(tableName);
        documentHeadersService.delete(temp);
        instance = documentHeadersService.create(instance);
        LOGGER.debug("DocumentHeaders details with id is updated: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the DocumentHeaders instance associated with the given composite-id.")
    public boolean deleteDocumentHeaders(@RequestParam(value = "id", required = true) Integer id, @RequestParam(value = "columnName", required = true) String columnName, @RequestParam(value = "headerInfo", required = true) String headerInfo, @RequestParam(value = "tableName", required = true) String tableName) throws EntityNotFoundException {
        DocumentHeadersId temp = new DocumentHeadersId();
        temp.setId(id);
        temp.setColumnName(columnName);
        temp.setHeaderInfo(headerInfo);
        temp.setTableName(tableName);
        LOGGER.debug("Deleting DocumentHeaders with id: {}", temp);
        DocumentHeaders deleted = documentHeadersService.delete(temp);
        return deleted != null;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of DocumentHeaders instances.")
    public Long countAllDocumentHeaderss() {
        LOGGER.debug("counting DocumentHeaderss");
        Long count = documentHeadersService.countAll();
        return count;
    }
}