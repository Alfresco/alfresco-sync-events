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
package org.alfresco.sync.events.types;

/**
 * Exception generated event bean. Used to convey a repository exception event.
 * 
 * @author steveglover
 *
 */
public class ExceptionGeneratedEvent extends RepositoryEventImpl implements TransactionOrderingAware
{
    private static final long serialVersionUID = -7936576493028335953L;

    public static final String EVENT_TYPE = "EXCEPTIONGENERATED";
    // Seq number relative to the transaction in which the event occurs
    protected Long seqNumber;
    private Throwable cause;

    public ExceptionGeneratedEvent()
    {
    }

    public ExceptionGeneratedEvent(long seqNumber, String txnId, long time, String networkId, Throwable cause, String username)
    {
        super(seqNumber, EVENT_TYPE, txnId, networkId, time, username, null);
        this.seqNumber = seqNumber;
        this.cause = cause;
    }

    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause)
    {
        this.cause = cause;
    }

    @Override
    public String toString()
    {
        return "ExceptionGeneratedEvent [cause=" + cause + ", type=" + type + ", txnId=" + txnId + ", timestamp=" + timestamp
                + "]";
    }


}
