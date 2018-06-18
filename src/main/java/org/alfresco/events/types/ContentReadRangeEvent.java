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

import org.alfresco.repo.Client;

/**
 * Occurs when content is read using a range request (for a part of the content).
 *
 * @author Gethin James
 * @since 5.0
 */
public class ContentReadRangeEvent extends ContentEventImpl
{
    private static final long serialVersionUID = 6438882751635793990L;
    String range;

    public ContentReadRangeEvent()
    {
        super();
    }

    public ContentReadRangeEvent(String username, String networkId, String txnId,
                String nodeId, String siteId, String nodeType, Client client, String name, String mimeType,
                long size, String encoding, String range)
    {
        super(ContentEventImpl.READ_RANGE, username, networkId, txnId, nodeId, siteId, nodeType, client, name, mimeType, size, encoding);
        this.range = range;
    }

    public String getRange()
    {
        return this.range;
    }

    public void setRange(String range)
    {
        this.range = range;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("ContentReadRangeEvent [id=").append(this.id).append(", type=").append(this.type)
               .append(", timestamp=").append(this.timestamp).append(", username=")
               .append(this.username).append(", client=").append(this.client)
               .append(", networkId=").append(this.networkId).append(", siteId=")
               .append(this.siteId).append(", txnId=").append(this.txnId).append(", nodeId=")
               .append(this.nodeId).append(", nodeType=").append(this.nodeType)
               .append(", mimeType=").append(this.mimeType).append(", size=")
               .append(this.size).append(", encoding=").append(this.encoding)
               .append(", range=").append(this.range).append("]");
        return builder.toString();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.range == null) ? 0 : this.range.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        ContentReadRangeEvent other = (ContentReadRangeEvent) obj;
        if (this.range == null)
        {
            if (other.range != null) return false;
        }
        else if (!this.range.equals(other.range)) return false;
        return true;
    }

}
