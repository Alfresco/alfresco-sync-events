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

import org.alfresco.sync.repo.Client;

/**
 * 
 * @author steveglover
 *
 */
public class RepositoryEventImpl extends EventImpl implements RepositoryEvent, Serializable
{
    private static final long serialVersionUID = 8016433304529447871L;

    protected String txnId;
    protected String networkId; // network/tenant
    protected Client client;
    
    public RepositoryEventImpl()
    {
    }

    public RepositoryEventImpl(long seqNumber, String type, String txnId, String networkId,
            long timestamp, String username, Client client)
    {
        super(seqNumber, type, timestamp, username);
        this.txnId = txnId;
        this.networkId = networkId;
        this.client = client;
    }

    public String getNetworkId()
    {
        return networkId;
    }

    public void setNetworkId(String networkId)
    {
        this.networkId = networkId;
    }

    public void setTxnId(String txnId)
    {
        this.txnId = txnId;
    }

    public String getTxnId()
    {
        return txnId;
    }

    @Override
    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client) 
    {
        this.client = client;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("RepositoryEventImpl [id=").append(this.id).append(", type=")
                    .append(this.type).append(", username=").append(this.username)
                    .append(", client=").append(this.client)
                    .append(", timestamp=").append(this.timestamp).append(", txnId=")
                    .append(this.txnId).append(", networkId=").append(this.networkId).append("]");
        return builder.toString();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.client == null) ? 0 : this.client.hashCode());
        result = prime * result + ((this.networkId == null) ? 0 : this.networkId.hashCode());
        result = prime * result + ((this.txnId == null) ? 0 : this.txnId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        RepositoryEventImpl other = (RepositoryEventImpl) obj;
        if (this.client == null)
        {
            if (other.client != null) return false;
        }
        else if (!this.client.equals(other.client)) return false;
        if (this.networkId == null)
        {
            if (other.networkId != null) return false;
        }
        else if (!this.networkId.equals(other.networkId)) return false;
        if (this.txnId == null)
        {
            if (other.txnId != null) return false;
        }
        else if (!this.txnId.equals(other.txnId)) return false;
        return true;
    }

}
