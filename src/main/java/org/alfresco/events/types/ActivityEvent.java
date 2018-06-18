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
 * An event raised by using the {@link ActivityService}
 *
 * @author Gethin James
 * @since 5.0
 */
public class ActivityEvent extends ContentEventImpl
{
    public ActivityEvent()
    {
        super();
        activityData = null;
    }

    public ActivityEvent(String type, String username, String networkId, long timestamp,
                String txnId, String nodeId, String siteId, String nodeType, Client client,
                String name, String mimeType, long size, String encoding)
    {
        super(type, username, networkId, timestamp, txnId, nodeId, siteId, nodeType, client, name,
                    mimeType, size, encoding);
        activityData = null;
    }

    public ActivityEvent(String type, String username, String networkId, String txnId,
                String nodeId, String siteId, String nodeType, Client client, String name,
                String mimeType, long size, String encoding)
    {
        super(type, username, networkId, txnId, nodeId, siteId, nodeType, client, name, mimeType, size,
                    encoding);
        activityData = null;
    }

    public static final String ACTIVITY_TYPE = "activity.";
    private static final long serialVersionUID = -8101613202921138060L;
    private final transient String activityData;
    
    public ActivityEvent(String type, String txnId, String networkId, String username, 
                String nodeId, String siteId, String nodeType, Client client,
                String activityData, String name, String mimeType, long size, String encoding)
    {
        super(ACTIVITY_TYPE+type, username, networkId, txnId, nodeId, siteId, nodeType, client, name, mimeType, size, encoding);
        this.activityData = activityData;
    }
    
    public ActivityEvent(String type, String txnId, String networkId, long timestamp, String username, 
                String nodeId, String siteId, String nodeType, Client client,
                String activityData, String name, String mimeType, long size, String encoding)
    {
        super(ACTIVITY_TYPE+type, username, networkId, timestamp, txnId, nodeId, siteId, nodeType, client, name, mimeType, size, encoding);
        this.activityData = activityData;
    }

    public String getActivityData()
    {
        return this.activityData;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("ActivityEvent [id=").append(this.id).append(", type=").append(this.type)
                    .append(", username=").append(this.username).append(", timestamp=")
                    .append(this.timestamp).append(", networkId=").append(this.networkId)
                    .append(", nodeId=").append(this.nodeId).append(", txnId=").append(this.txnId)
                    .append(", siteId=").append(this.siteId).append(", nodeType=")
                    .append(this.nodeType).append(", client=").append(this.client)
                    .append(", name=").append(this.name)
                    .append(", mimeType=").append(this.mimeType).append(", size=")
                    .append(this.size).append(", encoding=").append(this.encoding)
                    .append(", activityData=").append(this.activityData).append("]");
        return builder.toString();
    }

}
