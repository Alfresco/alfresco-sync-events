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

import java.util.HashMap;
import java.util.Map;

import org.alfresco.sync.repo.events.JsonUtil;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * An event that occurs when managing an Alfresco Site, e.g Site creation
 * 
 * @author Gethin James
 */
public class SiteManagementEvent extends RepositoryEventImpl implements SiteEvent, DataItem
{
    private static final long serialVersionUID = -7387933680171703729L;
    
    private String siteId;
    private String title;

    private String description;
    private String visibility;
    private String sitePreset;
    
    public SiteManagementEvent()
    {
        super();
    }

    public SiteManagementEvent(String type, String txnId, String networkId, long timestamp,
                String username, String siteId, String title, String description,
                String visibility, String sitePreset)
    {
        super(-1, type, txnId, networkId, timestamp, username, null);
        this.siteId = siteId;
        this.title = title;
        this.description = description;
        this.visibility = visibility;
        this.sitePreset = sitePreset;
    }

    public String getTitle()
    {
        return this.title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getDescription()
    {
        return this.description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public String getVisibility()
    {
        return this.visibility;
    }
    public void setVisibility(String visibility)
    {
        this.visibility = visibility;
    }
    public String getSitePreset()
    {
        return this.sitePreset;
    }
    public void setSitePreset(String sitePreset)
    {
        this.sitePreset = sitePreset;
    }
    public String getSiteId()
    {
        return this.siteId;
    }
    public void setSiteId(String siteId)
    {
        this.siteId = siteId;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("SiteManagementEvent [id=").append(this.id).append(", txnId=")
                    .append(this.txnId).append(", networkId=").append(this.networkId)
                    .append(", type=").append(this.type).append(", username=")
                    .append(this.username).append(", timestamp=").append(this.timestamp)
                    .append(", siteId=").append(this.siteId).append(", title=").append(this.title)
                    .append(", description=").append(this.description).append(", visibility=")
                    .append(this.visibility).append(", sitePreset=").append(this.sitePreset)
                    .append("]");
        return builder.toString();
    }

    @Override
    @JsonIgnore
    public String getDataAsJson()
    {
        Map<String, String> data = new HashMap<>();
        data.put("siteId", siteId);
        data.put("title", title);
        data.put("visibility", visibility);
        data.put("sitePreset", sitePreset);

        return JsonUtil.writeData(data);
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
        result = prime * result + ((this.siteId == null) ? 0 : this.siteId.hashCode());
        result = prime * result + ((this.sitePreset == null) ? 0 : this.sitePreset.hashCode());
        result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
        result = prime * result + ((this.visibility == null) ? 0 : this.visibility.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        SiteManagementEvent other = (SiteManagementEvent) obj;
        if (this.description == null)
        {
            if (other.description != null) return false;
        }
        else if (!this.description.equals(other.description)) return false;
        if (this.siteId == null)
        {
            if (other.siteId != null) return false;
        }
        else if (!this.siteId.equals(other.siteId)) return false;
        if (this.sitePreset == null)
        {
            if (other.sitePreset != null) return false;
        }
        else if (!this.sitePreset.equals(other.sitePreset)) return false;
        if (this.title == null)
        {
            if (other.title != null) return false;
        }
        else if (!this.title.equals(other.title)) return false;
        if (this.visibility == null)
        {
            if (other.visibility != null) return false;
        }
        else if (!this.visibility.equals(other.visibility)) return false;
        return true;
    }
}
