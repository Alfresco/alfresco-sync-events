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

import java.util.Date;

import org.alfresco.repo.Client;

/**
 * Occurs when content is read.
 *
 * @author Gethin James
 * @since 5.0
 */
public class ContentEventImpl extends BasicNodeEventImpl implements ContentEvent
{
    private static final long serialVersionUID = 6471232122343040380L;

    String mimeType;
    long size;
    String encoding;

    public ContentEventImpl()
    {
        super();
    }
    
    public ContentEventImpl(String type, String username, String networkId, String txnId,  String nodeId,
                            String siteId, String nodeType, Client client, String name, String mimeType, long size,
                            String encoding)
    {
        super(-1, type, txnId, networkId, new Date().getTime(), username, nodeId, siteId, nodeType, name, client);
        this.mimeType = mimeType;
        this.size = size;
        this.encoding = encoding;
    }

    public ContentEventImpl(String type, String username, String networkId, long timestamp, String txnId,  String nodeId,
                String siteId, String nodeType, Client client, String name, String mimeType, long size, String encoding)
    {
        super(-1, type, txnId, networkId, timestamp, username, nodeId, siteId, nodeType, name, client);
        this.mimeType = mimeType;
        this.size = size;
        this.encoding = encoding;
    }
    @Override
    public String getMimeType()
    {
        return this.mimeType;
    }
    @Override
    public long getSize()
    {
        return this.size;
    }
    @Override
    public String getEncoding()
    {
        return this.encoding;
    }

    @Override
    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }

    @Override
    public void setSize(long size)
    {
        this.size = size;
    }

    @Override
    public void setEncoding(String encoding)
    {
        this.encoding = encoding;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("ContentReadEvent [id=").append(this.id).append(", type=").append(this.type)
               .append(", timestamp=").append(this.timestamp).append(", username=")
               .append(this.username).append(", client=").append(this.client)
               .append(", networkId=").append(this.networkId).append(", siteId=")
               .append(this.siteId).append(", txnId=").append(this.txnId).append(", nodeId=")
               .append(this.nodeId).append(", nodeType=").append(this.nodeType)
               .append(", name=").append(this.name)
               .append(", mimeType=").append(this.mimeType).append(", size=")
               .append(this.size).append(", encoding=").append(this.encoding).append("]");
        return builder.toString();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.encoding == null) ? 0 : this.encoding.hashCode());
        result = prime * result + ((this.mimeType == null) ? 0 : this.mimeType.hashCode());
        result = prime * result + (int) (this.size ^ (this.size >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        ContentEventImpl other = (ContentEventImpl) obj;
        if (this.encoding == null)
        {
            if (other.encoding != null) return false;
        }
        else if (!this.encoding.equals(other.encoding)) return false;
        if (this.mimeType == null)
        {
            if (other.mimeType != null) return false;
        }
        else if (!this.mimeType.equals(other.mimeType)) return false;
        if (this.size != other.size) return false;
        return true;
    }
}