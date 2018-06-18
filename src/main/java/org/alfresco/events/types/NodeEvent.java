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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.alfresco.repo.Client;

/**
 * A node event.
 * 
 * @author steveglover
 *
 */
public class NodeEvent extends BasicNodeEventImpl implements Serializable, NodeInfoEvent
{
	private static final long serialVersionUID = 1632258418479600707L;

	protected Long nodeModificationTime;
	protected List<String> paths; // all paths, first one is the primary
	protected List<List<String>> parentNodeIds; // all paths, first one is the primary
	protected Set<String> aspects;
	protected Map<String, Serializable> nodeProperties = new HashMap<String, Serializable>();

    // TODO checksum?
	// TODO changeId?

	public NodeEvent()
	{
	}

	@SuppressWarnings("unchecked")
	public NodeEvent(long seqNumber, String name, String type, String txnId, long timestamp, String networkId, String siteId, 
                   String nodeId, String nodeType, List<String> paths, List<List<String>> parentNodeIds, String username,
                   Long nodeModificationTime, Client client, Set<String> aspects, Map<String, Serializable> nodeProperties)
    {
         super(seqNumber, type, txnId, networkId, timestamp,username, nodeId,  siteId, nodeType, name, client);
         this.paths = (List<String>) (paths==null?new ArrayList<>():paths);
         this.parentNodeIds = (List<List<String>>) (parentNodeIds==null?new ArrayList<>():parentNodeIds);
         this.nodeModificationTime = nodeModificationTime;
         this.aspects = (Set<String>)(aspects==null?new HashSet<>():aspects);
         this.nodeProperties =  (Map<String, Serializable>)(nodeProperties==null?new HashMap<>():nodeProperties);
   }

	public Set<String> getAspects()
	{
		return aspects;
	}

	public void setAspects(Set<String> aspects)
	{
		this.aspects = aspects;
	}

	public Map<String, Serializable> getNodeProperties()
	{
		return nodeProperties;
	}

	public void setNodeProperties(Map<String, Serializable> nodeProperties)
	{
		this.nodeProperties = nodeProperties;
	}

    public Long getNodeModificationTime()
	{
		return nodeModificationTime;
	}

	public void setNodeModificationTime(Long nodeModificationTime)
	{
		this.nodeModificationTime = nodeModificationTime;
	}

	/*
     * @see org.alfresco.events.types.NodeInfoEvent#getPaths()
     */
	@Override
    public List<String> getPaths()
	{
		return paths;
	}

	public void setPaths(List<String> paths)
	{
		this.paths = paths;
	}

	public void setNetworkId(String networkId)
	{
		this.networkId = networkId;
	}

	public String getNetworkId()
	{
		return networkId;
	}
	
	/*
     * @see org.alfresco.events.types.NodeInfoEvent#getParentNodeIds()
     */
	@Override
    public List<List<String>> getParentNodeIds()
	{
        return parentNodeIds;
    }

    public void setParentNodeIds(List<List<String>> parentNodeIds)
    {
        this.parentNodeIds = parentNodeIds;
    }

    @Override
    public String toString()
    {
        return "NodeEvent [name=" + name + ", nodeModificationTime=" + nodeModificationTime + ", nodeId="
                + getNodeId() + ", siteId=" + getSiteId() + ", username=" + username
                + ", networkId=" + networkId + ", paths=" + paths + ", nodeType="
                + ", seqNumber=" + seqNumber + ", parentNodeIds=" + parentNodeIds 
                + getNodeType() + ", type=" + type + ", txnId=" + txnId + ", timestamp="
                + timestamp + "]";
    }

}
