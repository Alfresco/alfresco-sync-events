/*
 * Copyright 2017 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.events.types.permission;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.alfresco.repo.Client;

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
