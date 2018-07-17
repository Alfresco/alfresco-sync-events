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

import org.alfresco.sync.repo.Client;

/**
 * Node checked out event.
 * 
 * @author steveglover
 *
 */
public class NodeCheckedOutEvent extends NodeEvent
{
    private static final long serialVersionUID = 4054013931468777166L;

    public static final String EVENT_TYPE = "NODECHECKEDOUT";

    private String checkedOutNodeId;

    public NodeCheckedOutEvent()
    {
    }

    public NodeCheckedOutEvent(long seqNumber, String checkedOutNodeId, String name, String txnId, long time, String networkId,
            String siteId, String nodeId, String nodeType, List<String> paths, List<List<String>> pathNodeIds, String userId,
            Long modificationTime, Client client, Set<String> aspects, Map<String, Serializable> properties)
    {
        super(seqNumber, name, EVENT_TYPE, txnId, time, networkId, siteId, nodeId, nodeType, paths, pathNodeIds, userId,
                modificationTime, client, aspects, properties);
        this.checkedOutNodeId = checkedOutNodeId;
    }

    @Override
    public String toString()
    {
        return "NodeCheckedOutEvent [name=" + name + ", nodeModificationTime="
                + nodeModificationTime + ", nodeId=" + nodeId + ", siteId="
                + siteId + ", paths=" + paths + ", parentNodeIds="
                + parentNodeIds + ", nodeType=" + nodeType + ", client="
                + client + ", aspects=" + aspects + ", properties="
                + nodeProperties + ", txnId=" + txnId + ", networkId=" + networkId
                + ", id=" + id + ", type=" + type + ", username=" + username
                + ", checkedOutNodeId=" + checkedOutNodeId + ", timestamp=" + timestamp + "]";
    }

    public String getCheckedOutNodeId()
    {
        return checkedOutNodeId;
    }

    public void setCheckedOutNodeId(String checkedOutNodeId)
    {
        this.checkedOutNodeId = checkedOutNodeId;
    }
}
