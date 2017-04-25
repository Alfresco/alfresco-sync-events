/*
 * Copyright 2017 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
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
