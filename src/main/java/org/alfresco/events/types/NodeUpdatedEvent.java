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
 * Node properties update event.
 * 
 * @author steveglover
 *
 */
public class NodeUpdatedEvent extends NodeEvent
{
    private static final long serialVersionUID = 2475045139546824298L;

    public static final String EVENT_TYPE = "NODEUPDATED";

    private Map<String, Property> propertiesAdded;
    private Set<String> propertiesRemoved;
    private Map<String, Property> propertiesChanged;
    private Set<String> aspectsAdded;
    private Set<String> aspectsRemoved;

    public NodeUpdatedEvent()
    {
    }

    public NodeUpdatedEvent(long seqNumber, String name, String txnId, long time, String networkId, String siteId, String nodeId, String nodeType,
            List<String> paths, List<List<String>> pathNodeIds, String userId, Long modificationTime, Map<String, Property> propertiesAdded,
            Set<String> propertiesRemoved, Map<String, Property> propertiesChanged,
            Set<String> aspectsAdded, Set<String> aspectsRemoved, Client client, Set<String> aspects,
            Map<String, Serializable> properties)
    {
        super(seqNumber, name, EVENT_TYPE, txnId, time, networkId, siteId, nodeId, nodeType, paths, pathNodeIds, userId,
                modificationTime, client, aspects, properties);
        this.propertiesAdded = propertiesAdded;
        this.propertiesRemoved = propertiesRemoved;
        this.propertiesChanged = propertiesChanged;
        this.aspectsAdded = aspectsAdded;
        this.aspectsRemoved = aspectsRemoved;
    }

    public Set<String> getAspectsAdded()
    {
        return aspectsAdded;
    }

    public Set<String> getAspectsRemoved()
    {
        return aspectsRemoved;
    }

    public void setAspectsAdded(Set<String> aspectsAdded)
    {
        this.aspectsAdded = aspectsAdded;
    }

    public void setAspectsRemoved(Set<String> aspectsRemoved)
    {
        this.aspectsRemoved = aspectsRemoved;
    }

    public Map<String, Property> getPropertiesAdded()
    {
        return propertiesAdded;
    }

    public void setPropertiesAdded(Map<String, Property> propertiesAdded)
    {
        this.propertiesAdded = propertiesAdded;
    }

    public Set<String> getPropertiesRemoved()
    {
        return propertiesRemoved;
    }

    public void setPropertiesRemoved(Set<String> propertiesRemoved)
    {
        this.propertiesRemoved = propertiesRemoved;
    }

    public Map<String, Property> getPropertiesChanged()
    {
        return propertiesChanged;
    }

    public void setPropertiesChanged(Map<String, Property> propertiesChanged)
    {
        this.propertiesChanged = propertiesChanged;
    }

    @Override
    public String toString()
    {
        return "NodeUpdatedEvent [propertiesAdded=" + propertiesAdded
                + ", propertiesRemoved=" + propertiesRemoved
                + ", propertiesChanged=" + propertiesChanged
                + ", aspectsAdded=" + aspectsAdded + ", aspectsRemoved="
                + aspectsRemoved + ", nodeModificationTime=" + nodeModificationTime
                + ", nodeId=" + nodeId + ", siteId=" + siteId + ", username="
                + username + ", networkId=" + networkId + ", paths=" + paths
                + ", type=" + type + ", txnId=" + txnId + ", timestamp=" + timestamp
                + "]";
    }

}
