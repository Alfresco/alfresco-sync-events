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
import org.alfresco.events.types.NodeEvent;
import org.alfresco.repo.Client;

/**
 * Permission change on a specific node.
 * 
 * @author cpopa
 */
public abstract class PermissionsEvent extends NodeEvent
{
    private static final long serialVersionUID = -4845100780200687517L;

    protected PermissionsEvent(long seqNumber, String name, String type, String txnId, long timestamp, String networkId, String siteId,
            String nodeId, String nodeType, List<String> paths, List<List<String>> parentNodeIds, String username, Long nodeModificationTime,
            Client client, Set<String> aspects, Map<String, Serializable> nodeProperties)
    {
        super(seqNumber, name, type, txnId, timestamp, networkId, siteId, nodeId, nodeType, paths, parentNodeIds, username, nodeModificationTime,
                client, aspects, nodeProperties);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("PermissionsEvent [nodeModificationTime=").append(nodeModificationTime).append(", paths=").append(paths)
                .append(", parentNodeIds=").append(parentNodeIds).append(", aspects=").append(aspects).append(", nodeProperties=")
                .append(nodeProperties).append(", nodeId=").append(nodeId).append(", siteId=").append(siteId).append(", nodeType=").append(nodeType)
                .append(", name=").append(name).append(", txnId=").append(txnId).append(", networkId=").append(networkId).append(", client=")
                .append(client).append(", id=").append(id).append(", type=").append(type).append(", username=").append(username)
                .append(", timestamp=").append(timestamp).append(", seqNumber=").append(seqNumber).append("]");
        return builder.toString();
    }

    public PermissionsEvent()
    {
    }
}
