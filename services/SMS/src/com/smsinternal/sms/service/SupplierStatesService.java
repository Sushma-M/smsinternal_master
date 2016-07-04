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
 * Service object for domain model class SupplierStates.
 * @see com.smsinternal.sms.SupplierStates
 */

public interface SupplierStatesService {
   /**
	 * Creates a new supplierstates.
	 * 
	 * @param created
	 *            The information of the created supplierstates.
	 * @return The created supplierstates.
	 */
	public SupplierStates create(SupplierStates created);

	/**
	 * Deletes a supplierstates.
	 * 
	 * @param supplierstatesId
	 *            The id of the deleted supplierstates.
	 * @return The deleted supplierstates.
	 * @throws EntityNotFoundException
	 *             if no supplierstates is found with the given id.
	 */
	public SupplierStates delete(SupplierStatesId supplierstatesId) throws EntityNotFoundException;

	/**
	 * Finds all supplierstatess.
	 * 
	 * @return A list of supplierstatess.
	 */
	public Page<SupplierStates> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<SupplierStates> findAll(Pageable pageable);
	
	/**
	 * Finds supplierstates by id.
	 * 
	 * @param id
	 *            The id of the wanted supplierstates.
	 * @return The found supplierstates. If no supplierstates is found, this method returns
	 *         null.
	 */
	public SupplierStates findById(SupplierStatesId id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a supplierstates.
	 * 
	 * @param updated
	 *            The information of the updated supplierstates.
	 * @return The updated supplierstates.
	 * @throws EntityNotFoundException
	 *             if no supplierstates is found with given id.
	 */
	public SupplierStates update(SupplierStates updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the supplierstatess in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the supplierstates.
	 */

	public long countAll();


    public Page<SupplierStates> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
