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
 * An event that denotes a file being unclassified(e.g. the secret/top secret/confidential mark is removed)
 * 
 * @author cpopa
 */
public class FileUnclassifiedEvent extends NodeEvent
{   
    private static final long serialVersionUID = 9219500137234460711L;
    
    public static final String EVENT_TYPE = "FILEUNCLASSIFIED";

    private FileUnclassifiedEvent(long seqNumber, String name, String txnId, long timestamp, String networkId, String siteId,
            String nodeId, String nodeType, List<String> paths, List<List<String>> parentNodeIds, String username, Long nodeModificationTime,
            Client client, Set<String> aspects, Map<String, Serializable> nodeProperties)
    {
        super(seqNumber, name, EVENT_TYPE, txnId, timestamp, networkId, siteId, nodeId, nodeType, paths, parentNodeIds, username, nodeModificationTime,
                client, aspects, nodeProperties);
    }    

    public FileUnclassifiedEvent()
    {
    }
    
    public static class FileUnclassifiedEventBuilder
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

        FileUnclassifiedEventBuilder()
        {
        }
        
        public FileUnclassifiedEventBuilder seqNumber(final long seqNumber)
        {
            this.seqNumber = seqNumber;
            return this;
        }

        public FileUnclassifiedEventBuilder name(final String name)
        {
            this.name = name;
            return this;
        }

        public FileUnclassifiedEventBuilder txnId(final String txnId)
        {
            this.txnId = txnId;
            return this;
        }

        public FileUnclassifiedEventBuilder timestamp(final long timestamp)
        {
            this.timestamp = timestamp;
            return this;
        }

        public FileUnclassifiedEventBuilder networkId(final String networkId)
        {
            this.networkId = networkId;
            return this;
        }

        public FileUnclassifiedEventBuilder siteId(final String siteId)
        {
            this.siteId = siteId;
            return this;
        }

        public FileUnclassifiedEventBuilder nodeId(final String nodeId)
        {
            this.nodeId = nodeId;
            return this;
        }

        public FileUnclassifiedEventBuilder nodeType(final String nodeType)
        {
            this.nodeType = nodeType;
            return this;
        }

        public FileUnclassifiedEventBuilder paths(final List<String> paths)
        {
            this.paths = paths;
            return this;
        }

        public FileUnclassifiedEventBuilder parentNodeIds(final List<List<String>> parentNodeIds)
        {
            this.parentNodeIds = parentNodeIds;
            return this;
        }

        public FileUnclassifiedEventBuilder username(final String username)
        {
            this.username = username;
            return this;
        }

        public FileUnclassifiedEventBuilder nodeModificationTime(final Long nodeModificationTime)
        {
            this.nodeModificationTime = nodeModificationTime;
            return this;
        }

        public FileUnclassifiedEventBuilder client(final Client client)
        {
            this.client = client;
            return this;
        }

        public FileUnclassifiedEventBuilder aspects(final Set<String> aspects)
        {
            this.aspects = aspects;
            return this;
        }

        public FileUnclassifiedEventBuilder nodeProperties(final Map<String, Serializable> nodeProperties)
        {
            this.nodeProperties = nodeProperties;
            return this;
        }

        public FileUnclassifiedEvent build()
        {
            return new FileUnclassifiedEvent(seqNumber, name, txnId, timestamp, networkId, siteId, nodeId, nodeType, paths, parentNodeIds, username,
                    nodeModificationTime, client, aspects, nodeProperties);
        }
    }

    public static FileUnclassifiedEventBuilder builder()
    {
        return new FileUnclassifiedEventBuilder();
    }    
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("FileUnclassifiedEvent [nodeModificationTime=").append(nodeModificationTime).append(", paths=").append(paths)
                .append(", parentNodeIds=").append(parentNodeIds).append(", aspects=").append(aspects).append(", nodeProperties=")
                .append(nodeProperties).append(", nodeId=").append(nodeId).append(", siteId=").append(siteId).append(", nodeType=").append(nodeType)
                .append(", name=").append(name).append(", txnId=").append(txnId).append(", networkId=").append(networkId).append(", client=")
                .append(client).append(", id=").append(id).append(", type=").append(type).append(", username=").append(username)
                .append(", timestamp=").append(timestamp).append(", seqNumber=").append(seqNumber).append("]");
        return builder.toString();
    }
}
