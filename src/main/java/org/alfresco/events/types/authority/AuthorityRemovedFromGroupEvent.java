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
 * Authority removed from a group
 * 
 * @author cpopa
 */
public class AuthorityRemovedFromGroupEvent extends AuthorityEvent
{
    private static final long serialVersionUID = -4975064585392761040L;
    public static final String EVENT_TYPE = "AUTHREMOVEDFROMGROUP";
    private String parentGroup;

    private AuthorityRemovedFromGroupEvent(String parentGroup, String authorityName, long seqNumber, String txnId, String networkId, long timestamp,
            String username, Client client)
    {
        super(authorityName, seqNumber, EVENT_TYPE, txnId, networkId, timestamp, username, client);
        this.parentGroup = parentGroup;
    }

    public static class AuthorityRemovedFromGroupEventBuilder
    {
        private String parentGroup;
        private String authorityName;
        private long seqNumber;
        private String txnId;
        private String networkId;
        private long timestamp;
        private String username;
        private Client client;

        AuthorityRemovedFromGroupEventBuilder()
        {
        }

        public AuthorityRemovedFromGroupEventBuilder parentGroup(final String parentGroup)
        {
            this.parentGroup = parentGroup;
            return this;
        }

        public AuthorityRemovedFromGroupEventBuilder authorityName(final String authorityName)
        {
            this.authorityName = authorityName;
            return this;
        }

        public AuthorityRemovedFromGroupEventBuilder seqNumber(final long seqNumber)
        {
            this.seqNumber = seqNumber;
            return this;
        }

        public AuthorityRemovedFromGroupEventBuilder txnId(final String txnId)
        {
            this.txnId = txnId;
            return this;
        }

        public AuthorityRemovedFromGroupEventBuilder networkId(final String networkId)
        {
            this.networkId = networkId;
            return this;
        }

        public AuthorityRemovedFromGroupEventBuilder timestamp(final long timestamp)
        {
            this.timestamp = timestamp;
            return this;
        }

        public AuthorityRemovedFromGroupEventBuilder username(final String username)
        {
            this.username = username;
            return this;
        }

        public AuthorityRemovedFromGroupEventBuilder client(final Client client)
        {
            this.client = client;
            return this;
        }

        public AuthorityRemovedFromGroupEvent build()
        {
            return new AuthorityRemovedFromGroupEvent(parentGroup, authorityName, seqNumber, txnId, networkId, timestamp, username, client);
        }
    }

    public static AuthorityRemovedFromGroupEventBuilder builder()
    {
        return new AuthorityRemovedFromGroupEventBuilder();
    }

    public AuthorityRemovedFromGroupEvent()
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
        return "AuthorityRemovedFromGroupEvent(super=" + super.toString() + ", parentGroup=" + this.getParentGroup() + ")";
    }
}
