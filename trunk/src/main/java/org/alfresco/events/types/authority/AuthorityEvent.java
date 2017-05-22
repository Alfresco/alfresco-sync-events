/*
 * Copyright 2017 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.events.types.authority;

import org.alfresco.events.types.RepositoryEventImpl;
import org.alfresco.repo.Client;

/**
 * An event which pertains to authorities(user or groups)
 * 
 * @author cpopa
 */
public abstract class AuthorityEvent extends RepositoryEventImpl
{
    private static final long serialVersionUID = -3217767152720757859L;
    protected String authorityName;

    protected AuthorityEvent(String authorityName, long seqNumber, String type, String txnId, String networkId, long timestamp, String username,
            Client client)
    {
        super(seqNumber, type, txnId, networkId, timestamp, username, client);
        this.authorityName = authorityName;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("AuthorityEvent [authorityName=").append(authorityName).append(", txnId=").append(txnId).append(", networkId=")
                .append(networkId).append(", client=").append(client).append(", id=").append(id).append(", type=").append(type).append(", username=")
                .append(username).append(", timestamp=").append(timestamp).append(", seqNumber=").append(seqNumber).append("]");
        return builder.toString();
    }

    public AuthorityEvent()
    {
    }

    public String getAuthorityName()
    {
        return this.authorityName;
    }

    public void setAuthorityName(final String authorityName)
    {
        this.authorityName = authorityName;
    }
}
