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
 * Service object for domain model class DocumentHeaders.
 * @see com.smsinternal.sms.DocumentHeaders
 */

public interface DocumentHeadersService {
   /**
	 * Creates a new documentheaders.
	 * 
	 * @param created
	 *            The information of the created documentheaders.
	 * @return The created documentheaders.
	 */
	public DocumentHeaders create(DocumentHeaders created);

	/**
	 * Deletes a documentheaders.
	 * 
	 * @param documentheadersId
	 *            The id of the deleted documentheaders.
	 * @return The deleted documentheaders.
	 * @throws EntityNotFoundException
	 *             if no documentheaders is found with the given id.
	 */
	public DocumentHeaders delete(DocumentHeadersId documentheadersId) throws EntityNotFoundException;

	/**
	 * Finds all documentheaderss.
	 * 
	 * @return A list of documentheaderss.
	 */
	public Page<DocumentHeaders> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<DocumentHeaders> findAll(Pageable pageable);
	
	/**
	 * Finds documentheaders by id.
	 * 
	 * @param id
	 *            The id of the wanted documentheaders.
	 * @return The found documentheaders. If no documentheaders is found, this method returns
	 *         null.
	 */
	public DocumentHeaders findById(DocumentHeadersId id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a documentheaders.
	 * 
	 * @param updated
	 *            The information of the updated documentheaders.
	 * @return The updated documentheaders.
	 * @throws EntityNotFoundException
	 *             if no documentheaders is found with given id.
	 */
	public DocumentHeaders update(DocumentHeaders updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the documentheaderss in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the documentheaders.
	 */

	public long countAll();


    public Page<DocumentHeaders> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

