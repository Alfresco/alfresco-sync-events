/*
 * #%L
 * Alfresco Repository
 * %%
 * Copyright (C) 2005 - 2018 Alfresco Software Limited
 * %%
 * This file is part of the Alfresco software.
 * If the software was purchased under a paid Alfresco license, the terms of
 * the paid license agreement will prevail.  Otherwise, the software is
 * provided under the following open source license terms:
 *
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */
package org.alfresco.events.types;

import org.alfresco.repo.Client;

/**
 * Transaction rollback event.
 * 
 * @author steveglover
 *
 */
public class TransactionRolledBackEvent extends TransactionEvent
{
	private static final long serialVersionUID = -921613586043213951L;

	public static final String EVENT_TYPE = "TRANSACTION_ROLLBACK";

	public TransactionRolledBackEvent()
	{
	}

	public TransactionRolledBackEvent(long seqNumber, String txnId, String networkId, long timestamp, String username,
	            Client client)
	{
		super(seqNumber, EVENT_TYPE, txnId, networkId, timestamp, username, client);
	}

	@Override
	public String toString()
	{
		return "TransactionRollbackEvent [id=" + id + ", type=" + type
				+ ", txnId=" + txnId + ", timestamp=" + timestamp + "]";
	}
}
