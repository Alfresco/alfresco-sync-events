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
 * A Basic Event that occurs on an Alfresco node.
 * 
 * @author Gethin James
 * @author sglover
 */
public class BasicNodeEventImpl extends RepositoryEventImpl implements BasicNodeEvent
{
    private static final long serialVersionUID = -5915563756442975835L;
    
    protected String nodeId; // node id (guid)
    protected String siteId;
    protected String nodeType;
    protected String name;
    
    public BasicNodeEventImpl()
    {
        super();
    }

    public BasicNodeEventImpl(long sequenceNumber, String type, String txnId, String networkId, long timestamp,
    		String username, Client client)
    {
        super(sequenceNumber, type, txnId, networkId, timestamp, username, client);
    }

    public BasicNodeEventImpl(long sequenceNumber, String type, String txnId, String networkId, long timestamp,
                String username, String nodeId, String siteId, String nodeType, String name, Client client)
    {
        super(sequenceNumber, type, txnId, networkId, timestamp, username, client);
        this.nodeId = nodeId;
        this.siteId = siteId;
        this.nodeType = nodeType;
        this.client = client;
        this.name = name;
    }
    
    /*
     * @see org.alfresco.events.types.BasicNodeEvent#getNodeId()
     */
    @Override
    public String getNodeId()
    {
        return this.nodeId;
    }
    /*
     * @see org.alfresco.events.types.BasicNodeEvent#getSiteId()
     */
    @Override
    public String getSiteId()
    {
        return this.siteId;
    }
    /*
     * @see org.alfresco.events.types.BasicNodeEvent#getNodeType()
     */
    @Override
    public String getNodeType()
    {
        return this.nodeType;
    }

    /*
     * @see org.alfresco.events.types.BasicNodeEvent#getName()
     */
    @Override
    public String getName()
    {
        return name;
    }
    
    @Override
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    public void setNodeId(String nodeId)
    {
        this.nodeId = nodeId;
    }

    @Override
    public void setSiteId(String siteId)
    {
        this.siteId = siteId;
    }

    @Override
    public void setNodeType(String nodeType)
    {
        this.nodeType = nodeType;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.nodeId == null) ? 0 : this.nodeId.hashCode());
        result = prime * result + ((this.nodeType == null) ? 0 : this.nodeType.hashCode());
        result = prime * result + ((this.siteId == null) ? 0 : this.siteId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        BasicNodeEventImpl other = (BasicNodeEventImpl) obj;
        if (this.name == null)
        {
            if (other.name != null) return false;
        }
        else if (!this.name.equals(other.name)) return false;
        if (this.nodeId == null)
        {
            if (other.nodeId != null) return false;
        }
        else if (!this.nodeId.equals(other.nodeId)) return false;
        if (this.nodeType == null)
        {
            if (other.nodeType != null) return false;
        }
        else if (!this.nodeType.equals(other.nodeType)) return false;
        if (this.siteId == null)
        {
            if (other.siteId != null) return false;
        }
        else if (!this.siteId.equals(other.siteId)) return false;
        return true;
    }
}