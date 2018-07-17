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
package org.alfresco.sync.events.activiti;

import java.io.Serializable;
import java.util.UUID;

import org.alfresco.sync.events.types.TenantedEvent;

/**
 * Activiti has a lot of events that we can listen to.  In Alfresco we are listening
 * to a sub-set of these events.  This class follows the general pattern of other Alfresco events
 * but its children are slim versions of Activiti Events.
 * 
 * They are designed with no reference to the Activiti Engine.  This allows the POJOs to be 
 * serialized and de-serialized with just basic java dependencies.
 *
 * @author Gethin James
 * @since 5.0
 */
public class AbstractActivitiEvent implements TenantedEvent, Serializable
{
    private static final long serialVersionUID = -4359988616517211627L;
    
    protected String id; // event id
    protected String type;
    protected String username;
    protected Long timestamp;
    protected String networkId; // network/tenant
 
    public AbstractActivitiEvent()
    {
        super();
    }

    public AbstractActivitiEvent(String type, String username, Long timestamp, String networkId)
    {
        super();
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.username = username;
        this.timestamp = timestamp;
        this.networkId = networkId;
    }
    
    @Override
    public String getId()
    {
        return this.id;
    }

    @Override
    public String getType()
    {
        return this.type;
    }

    @Override
    public String getUsername()
    {
        return this.username;
    }

    @Override
    public Long getTimestamp()
    {
        return this.timestamp;
    }

    @Override
    public String getNetworkId()
    {
        return this.networkId;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setTimestamp(Long timestamp)
    {
        this.timestamp = timestamp;
    }

    public void setNetworkId(String networkId)
    {
        this.networkId = networkId;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.networkId == null) ? 0 : this.networkId.hashCode());
        result = prime * result + ((this.timestamp == null) ? 0 : this.timestamp.hashCode());
        result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
        result = prime * result + ((this.username == null) ? 0 : this.username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        AbstractActivitiEvent other = (AbstractActivitiEvent) obj;
        if (this.id == null)
        {
            if (other.id != null) return false;
        }
        else if (!this.id.equals(other.id)) return false;
        if (this.networkId == null)
        {
            if (other.networkId != null) return false;
        }
        else if (!this.networkId.equals(other.networkId)) return false;
        if (this.timestamp == null)
        {
            if (other.timestamp != null) return false;
        }
        else if (!this.timestamp.equals(other.timestamp)) return false;
        if (this.type == null)
        {
            if (other.type != null) return false;
        }
        else if (!this.type.equals(other.type)) return false;
        if (this.username == null)
        {
            if (other.username != null) return false;
        }
        else if (!this.username.equals(other.username)) return false;
        return true;
    }
}
