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
 * Local permission granted to an authority for a specific node
 * 
 * @author cpopa
 */
public class LocalPermissionGrantedEvent extends LocalPermissionUpdatedEvent
{
    private static final long serialVersionUID = 3768414604735034832L;
    public static final String EVENT_TYPE = "LOCALPERMISSIONGRANTED";

    private LocalPermissionGrantedEvent(String authority, String permission, long seqNumber, String name, String txnId, long timestamp,
            String networkId, String siteId, String nodeId, String nodeType, List<String> paths, List<List<String>> parentNodeIds, String username,
            Long nodeModificationTime, Client client, Set<String> aspects, Map<String, Serializable> nodeProperties)
    {
        super(authority, permission, seqNumber, name, EVENT_TYPE, txnId, timestamp, networkId, siteId, nodeId, nodeType, paths, parentNodeIds,
                username, nodeModificationTime, client, aspects, nodeProperties);
    }

    public static class LocalPermissionGrantedEventBuilder
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

        LocalPermissionGrantedEventBuilder()
        {
        }

        public LocalPermissionGrantedEventBuilder authority(final String authority)
        {
            this.authority = authority;
            return this;
        }

        public LocalPermissionGrantedEventBuilder permission(final String permission)
        {
            this.permission = permission;
            return this;
        }

        public LocalPermissionGrantedEventBuilder seqNumber(final long seqNumber)
        {
            this.seqNumber = seqNumber;
            return this;
        }

        public LocalPermissionGrantedEventBuilder name(final String name)
        {
            this.name = name;
            return this;
        }

        public LocalPermissionGrantedEventBuilder txnId(final String txnId)
        {
            this.txnId = txnId;
            return this;
        }

        public LocalPermissionGrantedEventBuilder timestamp(final long timestamp)
        {
            this.timestamp = timestamp;
            return this;
        }

        public LocalPermissionGrantedEventBuilder networkId(final String networkId)
        {
            this.networkId = networkId;
            return this;
        }

        public LocalPermissionGrantedEventBuilder siteId(final String siteId)
        {
            this.siteId = siteId;
            return this;
        }

        public LocalPermissionGrantedEventBuilder nodeId(final String nodeId)
        {
            this.nodeId = nodeId;
            return this;
        }

        public LocalPermissionGrantedEventBuilder nodeType(final String nodeType)
        {
            this.nodeType = nodeType;
            return this;
        }

        public LocalPermissionGrantedEventBuilder paths(final List<String> paths)
        {
            this.paths = paths;
            return this;
        }

        public LocalPermissionGrantedEventBuilder parentNodeIds(final List<List<String>> parentNodeIds)
        {
            this.parentNodeIds = parentNodeIds;
            return this;
        }

        public LocalPermissionGrantedEventBuilder username(final String username)
        {
            this.username = username;
            return this;
        }

        public LocalPermissionGrantedEventBuilder nodeModificationTime(final Long nodeModificationTime)
        {
            this.nodeModificationTime = nodeModificationTime;
            return this;
        }

        public LocalPermissionGrantedEventBuilder client(final Client client)
        {
            this.client = client;
            return this;
        }

        public LocalPermissionGrantedEventBuilder aspects(final Set<String> aspects)
        {
            this.aspects = aspects;
            return this;
        }

        public LocalPermissionGrantedEventBuilder nodeProperties(final Map<String, Serializable> nodeProperties)
        {
            this.nodeProperties = nodeProperties;
            return this;
        }

        public LocalPermissionGrantedEvent build()
        {
            return new LocalPermissionGrantedEvent(authority, permission, seqNumber, name, txnId, timestamp, networkId, siteId, nodeId, nodeType,
                    paths, parentNodeIds, username, nodeModificationTime, client, aspects, nodeProperties);
        }
    }

    public static LocalPermissionGrantedEventBuilder builder()
    {
        return new LocalPermissionGrantedEventBuilder();
    }

    public LocalPermissionGrantedEvent()
    {
    }
}
