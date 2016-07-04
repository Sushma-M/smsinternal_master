/*Copyright (c) 2016-2017 jjrichards.com.au All Rights Reserved.
 This software is the confidential and proprietary information of jjrichards.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with jjrichards.com.au*/

package com.smsinternal.sms.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.smsinternal.sms.*;

/**
 * Service object for domain model class SupplierServices.
 * @see com.smsinternal.sms.SupplierServices
 */

public interface SupplierServicesService {
   /**
	 * Creates a new supplierservices.
	 * 
	 * @param created
	 *            The information of the created supplierservices.
	 * @return The created supplierservices.
	 */
	public SupplierServices create(SupplierServices created);

	/**
	 * Deletes a supplierservices.
	 * 
	 * @param supplierservicesId
	 *            The id of the deleted supplierservices.
	 * @return The deleted supplierservices.
	 * @throws EntityNotFoundException
	 *             if no supplierservices is found with the given id.
	 */
	public SupplierServices delete(Integer supplierservicesId) throws EntityNotFoundException;

	/**
	 * Finds all supplierservicess.
	 * 
	 * @return A list of supplierservicess.
	 */
	public Page<SupplierServices> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<SupplierServices> findAll(Pageable pageable);
	
	/**
	 * Finds supplierservices by id.
	 * 
	 * @param id
	 *            The id of the wanted supplierservices.
	 * @return The found supplierservices. If no supplierservices is found, this method returns
	 *         null.
	 */
	public SupplierServices findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a supplierservices.
	 * 
	 * @param updated
	 *            The information of the updated supplierservices.
	 * @return The updated supplierservices.
	 * @throws EntityNotFoundException
	 *             if no supplierservices is found with given id.
	 */
	public SupplierServices update(SupplierServices updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the supplierservicess in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the supplierservices.
	 */

	public long countAll();


    public Page<SupplierServices> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

