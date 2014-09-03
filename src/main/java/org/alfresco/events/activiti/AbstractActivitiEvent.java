/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.events.activiti;

import java.io.Serializable;
import java.util.UUID;

import org.alfresco.events.types.TenantedEvent;

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
