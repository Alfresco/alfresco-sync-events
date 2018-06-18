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

import org.alfresco.repo.Client;

/**
 * Authority added to a group
 * 
 * @author cpopa
 */
public class AuthorityAddedToGroupEvent extends AuthorityEvent
{
    private static final long serialVersionUID = -4975064585392761040L;
    public static final String EVENT_TYPE = "AUTHADDEDTOGROUP";

    private String parentGroup;

    private AuthorityAddedToGroupEvent(String parentGroup, String authorityName, long seqNumber, String txnId, String networkId, long timestamp,
            String username, Client client)
    {
        super(authorityName, seqNumber, EVENT_TYPE, txnId, networkId, timestamp, username, client);
        this.parentGroup = parentGroup;
    }

    public static class AuthorityAddedToGroupEventBuilder
    {
        private String parentGroup;
        private String authorityName;
        private long seqNumber;
        private String txnId;
        private String networkId;
        private long timestamp;
        private String username;
        private Client client;

        AuthorityAddedToGroupEventBuilder()
        {
        }

        public AuthorityAddedToGroupEventBuilder parentGroup(final String parentGroup)
        {
            this.parentGroup = parentGroup;
            return this;
        }

        public AuthorityAddedToGroupEventBuilder authorityName(final String authorityName)
        {
            this.authorityName = authorityName;
            return this;
        }

        public AuthorityAddedToGroupEventBuilder seqNumber(final long seqNumber)
        {
            this.seqNumber = seqNumber;
            return this;
        }

        public AuthorityAddedToGroupEventBuilder txnId(final String txnId)
        {
            this.txnId = txnId;
            return this;
        }

        public AuthorityAddedToGroupEventBuilder networkId(final String networkId)
        {
            this.networkId = networkId;
            return this;
        }

        public AuthorityAddedToGroupEventBuilder timestamp(final long timestamp)
        {
            this.timestamp = timestamp;
            return this;
        }

        public AuthorityAddedToGroupEventBuilder username(final String username)
        {
            this.username = username;
            return this;
        }

        public AuthorityAddedToGroupEventBuilder client(final Client client)
        {
            this.client = client;
            return this;
        }

        public AuthorityAddedToGroupEvent build()
        {
            return new AuthorityAddedToGroupEvent(parentGroup, authorityName, seqNumber, txnId, networkId, timestamp, username, client);
        }
    }

    public static AuthorityAddedToGroupEventBuilder builder()
    {
        return new AuthorityAddedToGroupEventBuilder();
    }

    public AuthorityAddedToGroupEvent()
    {
    }

    public String getParentGroup()
    {
        return this.parentGroup;
    }

    public void setParentGroup(final String parentGroup)
    {
        this.parentGroup = parentGroup;
    }

    @Override
    public String toString()
    {
        return "AuthorityAddedToGroupEvent(super=" + super.toString() + ", parentGroup=" + this.getParentGroup() + ")";
    }
}
