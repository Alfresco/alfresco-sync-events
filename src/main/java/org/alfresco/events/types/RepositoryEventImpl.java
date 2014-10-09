/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.events.types;

import java.io.Serializable;

import org.alfresco.repo.Client;

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

}
