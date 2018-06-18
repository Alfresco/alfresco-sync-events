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
 * Node content put/change event.
 * 
 * @author steveglover
 *
 */
public class NodeContentPutEvent extends NodeEvent implements ContentEvent
{
    private static final long serialVersionUID = -6657727955748547081L;

    public static final String EVENT_TYPE = "CONTENTPUT";

    public static final String FIELD_SIZE = "size";
    public static final String FIELD_MIME_TYPE = "mimeType";
    public static final String FIELD_ENCODING = "encoding";

    private long size;
    private String mimeType;
    private String encoding;

    public NodeContentPutEvent()
    {
    }

    public NodeContentPutEvent(long seqNumber, String name, String txnId, long time, String networkId, String siteId, String nodeId,
            String nodeType, List<String> paths, List<List<String>> pathNodeIds, String userId, Long modificationTime,
            long size, String mimeType, String encoding, Client client, Set<String> aspects, Map<String, Serializable> properties)
    {
        super(seqNumber, name, EVENT_TYPE, txnId, time, networkId, siteId, nodeId, nodeType,
                paths, pathNodeIds, userId, modificationTime, client, aspects, properties);
        this.size = size;
        this.mimeType = mimeType;
        this.encoding = encoding;
    }

    public long getSize()
    {
        return size;
    }

    public void setSize(long size)
    {
        this.size = size;
    }

    public String getMimeType()
    {
        return mimeType;
    }

    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }

    public String getEncoding()
    {
        return encoding;
    }

    public void setEncoding(String encoding)
    {
        this.encoding = encoding;
    }

    @Override
    public String toString()
    {
        return "NodeContentPutEvent [size=" + size + ", mimeType=" + mimeType
                + ", encoding=" + encoding + ", nodeModificationTime="
                + nodeModificationTime + ", nodeId=" + nodeId + ", siteId="
                + siteId + ", username=" + username + ", networkId=" + networkId
                + ", paths=" + paths + ", nodeType=" + nodeType + ", id=" + id
                + ", type=" + type + ", txnId=" + txnId + ", timestamp="
                + timestamp + "]";
    }

}
