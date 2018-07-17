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
package org.alfresco.sync.events.types.permission;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.alfresco.sync.repo.Client;

/**
 * Local permission revoked from an authority for a specific node
 * 
 * @author cpopa
 */
public class LocalPermissionRevokedEvent extends LocalPermissionUpdatedEvent
{
    private static final long serialVersionUID = 2368305203084987455L;
    public static final String EVENT_TYPE = "LOCALPERMISSIONREVOKED";

    private LocalPermissionRevokedEvent(String authority, String permission, long seqNumber, String name, String txnId, long timestamp,
            String networkId, String siteId, String nodeId, String nodeType, List<String> paths, List<List<String>> parentNodeIds, String username,
            Long nodeModificationTime, Client client, Set<String> aspects, Map<String, Serializable> nodeProperties)
    {
        super(authority, permission, seqNumber, name, EVENT_TYPE, txnId, timestamp, networkId, siteId, nodeId, nodeType, paths, parentNodeIds,
                username, nodeModificationTime, client, aspects, nodeProperties);
    }

    public static class LocalPermissionRevokedEventBuilder
    {
        private String authority;
        private String permission;
        private long seqNumber;
        private String name;
        private String txnId;
        private long timestamp;
        private String networkId;
        private String siteId;
        private String nodeId;
        private String nodeType;
        private List<String> paths;
        private List<List<String>> parentNodeIds;
        private String username;
        private Long nodeModificationTime;
        private Client client;
        private Set<String> aspects;
        private Map<String, Serializable> nodeProperties;

        LocalPermissionRevokedEventBuilder()
        {
        }

        public LocalPermissionRevokedEventBuilder authority(final String authority)
        {
            this.authority = authority;
            return this;
        }

        public LocalPermissionRevokedEventBuilder permission(final String permission)
        {
            this.permission = permission;
            return this;
        }

        public LocalPermissionRevokedEventBuilder seqNumber(final long seqNumber)
        {
            this.seqNumber = seqNumber;
            return this;
        }

        public LocalPermissionRevokedEventBuilder name(final String name)
        {
            this.name = name;
            return this;
        }

        public LocalPermissionRevokedEventBuilder txnId(final String txnId)
        {
            this.txnId = txnId;
            return this;
        }

        public LocalPermissionRevokedEventBuilder timestamp(final long timestamp)
        {
            this.timestamp = timestamp;
            return this;
        }

        public LocalPermissionRevokedEventBuilder networkId(final String networkId)
        {
            this.networkId = networkId;
            return this;
        }

        public LocalPermissionRevokedEventBuilder siteId(final String siteId)
        {
            this.siteId = siteId;
            return this;
        }

        public LocalPermissionRevokedEventBuilder nodeId(final String nodeId)
        {
            this.nodeId = nodeId;
            return this;
        }

        public LocalPermissionRevokedEventBuilder nodeType(final String nodeType)
        {
            this.nodeType = nodeType;
            return this;
        }

        public LocalPermissionRevokedEventBuilder paths(final List<String> paths)
        {
            this.paths = paths;
            return this;
        }

        public LocalPermissionRevokedEventBuilder parentNodeIds(final List<List<String>> parentNodeIds)
        {
            this.parentNodeIds = parentNodeIds;
            return this;
        }

        public LocalPermissionRevokedEventBuilder username(final String username)
        {
            this.username = username;
            return this;
        }

        public LocalPermissionRevokedEventBuilder nodeModificationTime(final Long nodeModificationTime)
        {
            this.nodeModificationTime = nodeModificationTime;
            return this;
        }

        public LocalPermissionRevokedEventBuilder client(final Client client)
        {
            this.client = client;
            return this;
        }

        public LocalPermissionRevokedEventBuilder aspects(final Set<String> aspects)
        {
            this.aspects = aspects;
            return this;
        }

        public LocalPermissionRevokedEventBuilder nodeProperties(final Map<String, Serializable> nodeProperties)
        {
            this.nodeProperties = nodeProperties;
            return this;
        }

        public LocalPermissionRevokedEvent build()
        {
            return new LocalPermissionRevokedEvent(authority, permission, seqNumber, name, txnId, timestamp, networkId, siteId, nodeId, nodeType,
                    paths, parentNodeIds, username, nodeModificationTime, client, aspects, nodeProperties);
        }
    }

    public static LocalPermissionRevokedEventBuilder builder()
    {
        return new LocalPermissionRevokedEventBuilder();
    }

    public LocalPermissionRevokedEvent()
    {
    }
}
