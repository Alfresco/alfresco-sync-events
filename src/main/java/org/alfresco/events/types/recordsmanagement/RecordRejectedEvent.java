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
 * An event that denotes a record being rejected, thus becoming a regular node again
 * 
 * @author cpopa
 */
public class RecordRejectedEvent extends NodeEvent
{   
    private static final long serialVersionUID = 6797117452438369729L;
    
    public static final String EVENT_TYPE = "RECORDCREATED";

    private RecordRejectedEvent(long seqNumber, String name, String txnId, long timestamp, String networkId, String siteId,
            String nodeId, String nodeType, List<String> paths, List<List<String>> parentNodeIds, String username, Long nodeModificationTime,
            Client client, Set<String> aspects, Map<String, Serializable> nodeProperties)
    {
        super(seqNumber, name, EVENT_TYPE, txnId, timestamp, networkId, siteId, nodeId, nodeType, paths, parentNodeIds, username, nodeModificationTime,
                client, aspects, nodeProperties);
    }    

    public RecordRejectedEvent()
    {
    }
    
    public static class RecordRejectedEventBuilder
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

        RecordRejectedEventBuilder()
        {
        }
        
        public RecordRejectedEventBuilder seqNumber(final long seqNumber)
        {
            this.seqNumber = seqNumber;
            return this;
        }

        public RecordRejectedEventBuilder name(final String name)
        {
            this.name = name;
            return this;
        }

        public RecordRejectedEventBuilder txnId(final String txnId)
        {
            this.txnId = txnId;
            return this;
        }

        public RecordRejectedEventBuilder timestamp(final long timestamp)
        {
            this.timestamp = timestamp;
            return this;
        }

        public RecordRejectedEventBuilder networkId(final String networkId)
        {
            this.networkId = networkId;
            return this;
        }

        public RecordRejectedEventBuilder siteId(final String siteId)
        {
            this.siteId = siteId;
            return this;
        }

        public RecordRejectedEventBuilder nodeId(final String nodeId)
        {
            this.nodeId = nodeId;
            return this;
        }

        public RecordRejectedEventBuilder nodeType(final String nodeType)
        {
            this.nodeType = nodeType;
            return this;
        }

        public RecordRejectedEventBuilder paths(final List<String> paths)
        {
            this.paths = paths;
            return this;
        }

        public RecordRejectedEventBuilder parentNodeIds(final List<List<String>> parentNodeIds)
        {
            this.parentNodeIds = parentNodeIds;
            return this;
        }

        public RecordRejectedEventBuilder username(final String username)
        {
            this.username = username;
            return this;
        }

        public RecordRejectedEventBuilder nodeModificationTime(final Long nodeModificationTime)
        {
            this.nodeModificationTime = nodeModificationTime;
            return this;
        }

        public RecordRejectedEventBuilder client(final Client client)
        {
            this.client = client;
            return this;
        }

        public RecordRejectedEventBuilder aspects(final Set<String> aspects)
        {
            this.aspects = aspects;
            return this;
        }

        public RecordRejectedEventBuilder nodeProperties(final Map<String, Serializable> nodeProperties)
        {
            this.nodeProperties = nodeProperties;
            return this;
        }

        public RecordRejectedEvent build()
        {
            return new RecordRejectedEvent(seqNumber, name, txnId, timestamp, networkId, siteId, nodeId, nodeType, paths, parentNodeIds, username,
                    nodeModificationTime, client, aspects, nodeProperties);
        }
    }

    public static RecordRejectedEventBuilder builder()
    {
        return new RecordRejectedEventBuilder();
    }    
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("RecordRejectedEvent [nodeModificationTime=").append(nodeModificationTime).append(", paths=").append(paths)
                .append(", parentNodeIds=").append(parentNodeIds).append(", aspects=").append(aspects).append(", nodeProperties=")
                .append(nodeProperties).append(", nodeId=").append(nodeId).append(", siteId=").append(siteId).append(", nodeType=").append(nodeType)
                .append(", name=").append(name).append(", txnId=").append(txnId).append(", networkId=").append(networkId).append(", client=")
                .append(client).append(", id=").append(id).append(", type=").append(type).append(", username=").append(username)
                .append(", timestamp=").append(timestamp).append(", seqNumber=").append(seqNumber).append("]");
        return builder.toString();
    }
}
