/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
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
