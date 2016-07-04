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
 * Service object for domain model class PublicLiability.
 * @see com.smsinternal.sms.PublicLiability
 */

public interface PublicLiabilityService {
   /**
	 * Creates a new publicliability.
	 * 
	 * @param created
	 *            The information of the created publicliability.
	 * @return The created publicliability.
	 */
	public PublicLiability create(PublicLiability created);

	/**
	 * Deletes a publicliability.
	 * 
	 * @param publicliabilityId
	 *            The id of the deleted publicliability.
	 * @return The deleted publicliability.
	 * @throws EntityNotFoundException
	 *             if no publicliability is found with the given id.
	 */
	public PublicLiability delete(Integer publicliabilityId) throws EntityNotFoundException;

	/**
	 * Finds all publicliabilitys.
	 * 
	 * @return A list of publicliabilitys.
	 */
	public Page<PublicLiability> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<PublicLiability> findAll(Pageable pageable);
	
	/**
	 * Finds publicliability by id.
	 * 
	 * @param id
	 *            The id of the wanted publicliability.
	 * @return The found publicliability. If no publicliability is found, this method returns
	 *         null.
	 */
	public PublicLiability findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a publicliability.
	 * 
	 * @param updated
	 *            The information of the updated publicliability.
	 * @return The updated publicliability.
	 * @throws EntityNotFoundException
	 *             if no publicliability is found with given id.
	 */
	public PublicLiability update(PublicLiability updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the publicliabilitys in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the publicliability.
	 */

	public long countAll();


    public Page<PublicLiability> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

