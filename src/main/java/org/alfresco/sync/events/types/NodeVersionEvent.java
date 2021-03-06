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
package org.alfresco.sync.events.types;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.alfresco.sync.events.NodeVersion;
import org.alfresco.sync.repo.Client;

/**
 * Node versioned events.
 * 
 * @author steveglover
 *
 */
public class NodeVersionEvent extends NodeEvent
{
    private static final long serialVersionUID = -2382018139356315699L;

    public static final String EVENT_TYPE = "NODEVERSIONED";

    private NodeVersion version;

    public NodeVersionEvent(long seqNumber, String name, String txnId, long time, String networkId, String siteId, String nodeId, String nodeType,
            List<String> paths, List<List<String>> pathNodeIds, String userId, Long modificationTime, NodeVersion version,
            Client client, Set<String> aspects, Map<String, Serializable> properties)
    {
        super(seqNumber, name, EVENT_TYPE, txnId, time, networkId, siteId, nodeId, nodeType, paths, pathNodeIds, userId,
                modificationTime, client, aspects, properties);
        this.version = version;
    }

    public NodeVersion getVersion()
    {
        return version;
    }

    @Override
    public String toString()
    {
        return "NodeVersionEvent [version=" + version + ", nodeModificationTime="
                + nodeModificationTime + ", nodeId=" + nodeId + ", siteId="
                + siteId + ", username=" + username + ", networkId=" + networkId
                + ", paths=" + paths + ", type=" + type + ", txnId=" + txnId
                + ", timestamp=" + timestamp + "]";
    }
}
