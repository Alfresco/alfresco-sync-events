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
package org.alfresco.events.types;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.alfresco.repo.Client;

/**
 * Node checked in event.
 * 
 * @author steveglover
 *
 */
public class NodeCheckedInEvent extends NodeEvent
{
    private static final long serialVersionUID = -4171154321512563593L;

    public static final String EVENT_TYPE = "NODECHECKEDIN";

    public NodeCheckedInEvent()
    {
    }

    public NodeCheckedInEvent(long seqNumber, String name, String txnId, long time, String networkId, String siteId,
            String nodeId, String nodeType, List<String> paths, List<List<String>> pathNodeIds, String userId,
            Long modificationTime, Client client, Set<String> aspects, Map<String, Serializable> properties)
    {
        super(seqNumber, name, EVENT_TYPE, txnId, time, networkId, siteId, nodeId, nodeType, paths, pathNodeIds, userId,
                modificationTime, client, aspects, properties);
    }

    @Override
    public String toString()
    {
        return "NodeCheckedInEvent [name=" + name + ", nodeModificationTime="
                + nodeModificationTime + ", nodeId=" + nodeId + ", siteId="
                + siteId + ", paths=" + paths + ", parentNodeIds="
                + parentNodeIds + ", nodeType=" + nodeType + ", client="
                + client + ", aspects=" + aspects + ", properties="
                + nodeProperties + ", txnId=" + txnId + ", networkId=" + networkId
                + ", id=" + id + ", type=" + type + ", username=" + username
                + ", timestamp=" + timestamp + "]";
    }
}
