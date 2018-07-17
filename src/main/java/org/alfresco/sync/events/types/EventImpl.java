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

import java.io.Serializable;
import java.util.UUID;

/**
 * Abstract event bean.
 * 
 * @author steveglover
 *
 */
public abstract class EventImpl implements Event, TransactionOrderingAware, Serializable
{
    private static final long serialVersionUID = 6734450593395365207L;

    protected String id; // event id
    protected String type;
    protected String username;

    // Event (creation) timestamp. Note separate timestamp field (even though Mongo stores timestamp in the object id, it is not a very
    // accurate timestamp)
    protected Long timestamp;

    // Seq number relative to the transaction in which the event occurs
    protected long seqNumber;

    public EventImpl()
    {
    }

    public EventImpl(long seqNumber, String type, long timestamp, String username)
    {
        this.seqNumber = seqNumber;
        this.type = type;
        this.timestamp = timestamp;
        this.id = UUID.randomUUID().toString();
        this.username = username;
    }

    public Long getSeqNumber()
    {
        return seqNumber;
    }

    public void setSeqNumber(long seqNumber)
    {
        this.seqNumber = seqNumber;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setTimestamp(Long timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getType()
    {
        return type;
    }

    public Long getTimestamp()
    {
        return timestamp;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Event other = (Event) obj;
        if (id == null) {
            if (other.getId() != null)
                return false;
        } else if (!id.equals(other.getId()))
            return false;
        return true;
    }

}
