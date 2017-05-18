/*
 * Copyright 2017 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.events.types.recordsmanagement;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.alfresco.events.types.NodeEvent;
import org.alfresco.repo.Client;

/**
 * An event that denotes a record being created
 * 
 * @author cpopa
 */
public class RecordCreatedEvent extends NodeEvent
{
    private static final long serialVersionUID = 6259164966648897548L;

    public static final String EVENT_TYPE = "RECORDCREATED";

    private RecordCreatedEvent(long seqNumber, String name, String txnId, long timestamp, String networkId, String siteId,
            String nodeId, String nodeType, List<String> paths, List<List<String>> parentNodeIds, String username, Long nodeModificationTime,
            Client client, Set<String> aspects, Map<String, Serializable> nodeProperties)
    {
        super(seqNumber, name, EVENT_TYPE, txnId, timestamp, networkId, siteId, nodeId, nodeType, paths, parentNodeIds, username, nodeModificationTime,
                client, aspects, nodeProperties);
    }    

    public RecordCreatedEvent()
    {
    }
    
    public static class RecordCreatedEventBuilder
    {
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

        RecordCreatedEventBuilder()
        {
        }
        
        public RecordCreatedEventBuilder seqNumber(final long seqNumber)
        {
            this.seqNumber = seqNumber;
            return this;
        }

        public RecordCreatedEventBuilder name(final String name)
        {
            this.name = name;
            return this;
        }

        public RecordCreatedEventBuilder txnId(final String txnId)
        {
            this.txnId = txnId;
            return this;
        }

        public RecordCreatedEventBuilder timestamp(final long timestamp)
        {
            this.timestamp = timestamp;
            return this;
        }

        public RecordCreatedEventBuilder networkId(final String networkId)
        {
            this.networkId = networkId;
            return this;
        }

        public RecordCreatedEventBuilder siteId(final String siteId)
        {
            this.siteId = siteId;
            return this;
        }

        public RecordCreatedEventBuilder nodeId(final String nodeId)
        {
            this.nodeId = nodeId;
            return this;
        }

        public RecordCreatedEventBuilder nodeType(final String nodeType)
        {
            this.nodeType = nodeType;
            return this;
        }

        public RecordCreatedEventBuilder paths(final List<String> paths)
        {
            this.paths = paths;
            return this;
        }

        public RecordCreatedEventBuilder parentNodeIds(final List<List<String>> parentNodeIds)
        {
            this.parentNodeIds = parentNodeIds;
            return this;
        }

        public RecordCreatedEventBuilder username(final String username)
        {
            this.username = username;
            return this;
        }

        public RecordCreatedEventBuilder nodeModificationTime(final Long nodeModificationTime)
        {
            this.nodeModificationTime = nodeModificationTime;
            return this;
        }

        public RecordCreatedEventBuilder client(final Client client)
        {
            this.client = client;
            return this;
        }

        public RecordCreatedEventBuilder aspects(final Set<String> aspects)
        {
            this.aspects = aspects;
            return this;
        }

        public RecordCreatedEventBuilder nodeProperties(final Map<String, Serializable> nodeProperties)
        {
            this.nodeProperties = nodeProperties;
            return this;
        }

        public RecordCreatedEvent build()
        {
            return new RecordCreatedEvent(seqNumber, name, txnId, timestamp, networkId, siteId, nodeId, nodeType, paths, parentNodeIds, username,
                    nodeModificationTime, client, aspects, nodeProperties);
        }
    }

    public static RecordCreatedEventBuilder builder()
    {
        return new RecordCreatedEventBuilder();
    }    
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("RecordCreatedEvent [txnId=").append(txnId).append(", networkId=").append(networkId).append(", client=").append(client)
                .append(", id=").append(id).append(", type=").append(type).append(", username=").append(username).append(", timestamp=")
                .append(timestamp).append(", seqNumber=").append(seqNumber).append("]");
        return builder.toString();
    }
}
