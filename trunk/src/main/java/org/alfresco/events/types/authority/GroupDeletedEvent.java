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
 * Group deleted event
 * 
 * @author cpopa
 */
public class GroupDeletedEvent extends AuthorityEvent {
    private static final long serialVersionUID = -3217767152720757859L;
    public static final String EVENT_TYPE = "GROUPDELETED";
    private boolean cascade;

    private GroupDeletedEvent(String authorityName, boolean cascade, long seqNumber, String txnId, String networkId, long timestamp, String username, Client client) {
        super(authorityName, seqNumber, EVENT_TYPE, txnId, networkId, timestamp, username, client);
        this.cascade = cascade;
    }


    public static class GroupDeletedEventBuilder {
        private String authorityName;
        private boolean cascade;
        private long seqNumber;
        private String txnId;
        private String networkId;
        private long timestamp;
        private String username;
        private Client client;

        GroupDeletedEventBuilder() {
        }

        public GroupDeletedEventBuilder authorityName(final String authorityName) {
            this.authorityName = authorityName;
            return this;
        }

        public GroupDeletedEventBuilder cascade(final boolean cascade) {
            this.cascade = cascade;
            return this;
        }

        public GroupDeletedEventBuilder seqNumber(final long seqNumber) {
            this.seqNumber = seqNumber;
            return this;
        }

        public GroupDeletedEventBuilder txnId(final String txnId) {
            this.txnId = txnId;
            return this;
        }

        public GroupDeletedEventBuilder networkId(final String networkId) {
            this.networkId = networkId;
            return this;
        }

        public GroupDeletedEventBuilder timestamp(final long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public GroupDeletedEventBuilder username(final String username) {
            this.username = username;
            return this;
        }

        public GroupDeletedEventBuilder client(final Client client) {
            this.client = client;
            return this;
        }

        public GroupDeletedEvent build() {
            return new GroupDeletedEvent(authorityName, cascade, seqNumber, txnId, networkId, timestamp, username, client);
        }
    }

    public static GroupDeletedEventBuilder builder() {
        return new GroupDeletedEventBuilder();
    }

    public GroupDeletedEvent() {
    }

    public boolean isCascade() {
        return this.cascade;
    }

    public void setCascade(final boolean cascade) {
        this.cascade = cascade;
    }

    @Override
    public String toString() {
        return "GroupDeletedEvent(super=" + super.toString() + ", cascade=" + this.isCascade() + ")";
    }
}
