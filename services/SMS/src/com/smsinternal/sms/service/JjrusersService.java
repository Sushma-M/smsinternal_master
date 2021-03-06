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
 * Service object for domain model class Jjrusers.
 * @see com.smsinternal.sms.Jjrusers
 */

public interface JjrusersService {
   /**
	 * Creates a new jjrusers.
	 * 
	 * @param created
	 *            The information of the created jjrusers.
	 * @return The created jjrusers.
	 */
	public Jjrusers create(Jjrusers created);

	/**
	 * Deletes a jjrusers.
	 * 
	 * @param jjrusersId
	 *            The id of the deleted jjrusers.
	 * @return The deleted jjrusers.
	 * @throws EntityNotFoundException
	 *             if no jjrusers is found with the given id.
	 */
	public Jjrusers delete(Integer jjrusersId) throws EntityNotFoundException;

	/**
	 * Finds all jjruserss.
	 * 
	 * @return A list of jjruserss.
	 */
	public Page<Jjrusers> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Jjrusers> findAll(Pageable pageable);
	
	/**
	 * Finds jjrusers by id.
	 * 
	 * @param id
	 *            The id of the wanted jjrusers.
	 * @return The found jjrusers. If no jjrusers is found, this method returns
	 *         null.
	 */
	public Jjrusers findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a jjrusers.
	 * 
	 * @param updated
	 *            The information of the updated jjrusers.
	 * @return The updated jjrusers.
	 * @throws EntityNotFoundException
	 *             if no jjrusers is found with given id.
	 */
	public Jjrusers update(Jjrusers updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the jjruserss in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the jjrusers.
	 */

	public long countAll();


    public Page<Jjrusers> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

