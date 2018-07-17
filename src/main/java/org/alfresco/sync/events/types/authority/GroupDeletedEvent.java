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
package org.alfresco.sync.events.types.authority;

import org.alfresco.sync.repo.Client;

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
