/*Copyright (c) 2016-2017 jjrichards.com.au All Rights Reserved.
 This software is the confidential and proprietary information of jjrichards.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with jjrichards.com.au*/
package com.smsinternal.sms.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.smsinternal.sms.service.MontorVehicleInsuranceService;
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
 * Controller object for domain model class MontorVehicleInsurance.
 * @see com.smsinternal.sms.MontorVehicleInsurance
 */
@RestController(value = "SMS.MontorVehicleInsuranceController")
@RequestMapping("/SMS/MontorVehicleInsurance")
@Api(description = "Exposes APIs to work with MontorVehicleInsurance resource.", value = "MontorVehicleInsuranceController")
public class MontorVehicleInsuranceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MontorVehicleInsuranceController.class);

    @Autowired
    @Qualifier("SMS.MontorVehicleInsuranceService")
    private MontorVehicleInsuranceService montorVehicleInsuranceService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of MontorVehicleInsurance instances matching the search criteria.")
    public Page<MontorVehicleInsurance> findMontorVehicleInsurances(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering MontorVehicleInsurances list");
        return montorVehicleInsuranceService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of MontorVehicleInsurance instances.")
    public Page<MontorVehicleInsurance> getMontorVehicleInsurances(Pageable pageable) {
        LOGGER.debug("Rendering MontorVehicleInsurances list");
        return montorVehicleInsuranceService.findAll(pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setMontorVehicleInsuranceService(MontorVehicleInsuranceService service) {
        this.montorVehicleInsuranceService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new MontorVehicleInsurance instance.")
    public MontorVehicleInsurance createMontorVehicleInsurance(@RequestBody MontorVehicleInsurance instance) {
        LOGGER.debug("Create MontorVehicleInsurance with information: {}", instance);
        instance = montorVehicleInsuranceService.create(instance);
        LOGGER.debug("Created MontorVehicleInsurance with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of MontorVehicleInsurance instances.")
    public Long countAllMontorVehicleInsurances() {
        LOGGER.debug("counting MontorVehicleInsurances");
        Long count = montorVehicleInsuranceService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the MontorVehicleInsurance instance associated with the given id.")
    public MontorVehicleInsurance getMontorVehicleInsurance(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting MontorVehicleInsurance with id: {}", id);
        MontorVehicleInsurance instance = montorVehicleInsuranceService.findById(id);
        LOGGER.debug("MontorVehicleInsurance details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the MontorVehicleInsurance instance associated with the given id.")
    public MontorVehicleInsurance editMontorVehicleInsurance(@PathVariable(value = "id") Integer id, @RequestBody MontorVehicleInsurance instance) throws EntityNotFoundException {
        LOGGER.debug("Editing MontorVehicleInsurance with id: {}", instance.getId());
        instance.setId(id);
        instance = montorVehicleInsuranceService.update(instance);
        LOGGER.debug("MontorVehicleInsurance details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the MontorVehicleInsurance instance associated with the given id.")
    public boolean deleteMontorVehicleInsurance(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting MontorVehicleInsurance with id: {}", id);
        MontorVehicleInsurance deleted = montorVehicleInsuranceService.delete(id);
        return deleted != null;
    }
}
