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
