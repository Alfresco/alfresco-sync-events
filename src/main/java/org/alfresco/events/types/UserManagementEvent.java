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

import java.util.HashMap;
import java.util.Map;

import org.alfresco.repo.events.JsonUtil;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * An event that occurs when managing an Alfresco User
 * 
 * @author Harpritt Kalsi
 */
public class UserManagementEvent extends RepositoryEventImpl implements DataItem
{
    private static final long serialVersionUID = -19686678748247457L;
    
    private String managedUsername;
    private String managedForename;
    private String managedSurname;
    
    public UserManagementEvent()
    {
        super();
    }

    public UserManagementEvent(String type, String txnId, String networkId, long timestamp,
                String username, String managedUsername, String managedForename, String managedSurname)
    {
        super(-1, type, txnId, networkId, timestamp, username, null);
        
        this.managedUsername = managedUsername;
        this.managedForename = managedForename;
        this.managedSurname = managedSurname;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("UserManagementEvent [id=").append(this.id).append(", txnId=")
                    .append(this.txnId).append(", networkId=").append(this.networkId)
                    .append(", type=").append(this.type).append(", username=")
                    .append(this.username).append(", timestamp=").append(this.timestamp)
                    .append(", managedUsername=").append(this.managedUsername).append(", managedForename=").append(this.managedForename)
                    .append(", managedSurname=").append(this.managedSurname).append("]");
        return builder.toString();
    }

    public String getManagedUsername()
    {
        return this.managedUsername;
    }

    public String getManagedForename()
    {
        return this.managedForename;
    }

    public String getManagedSurname()
    {
        return this.managedSurname;
    }
    
    @Override
    @JsonIgnore
    public String getDataAsJson()
    {
        Map<String, String> data = new HashMap<>();
        data.put("managedUsername", managedUsername);
        data.put("managedForename", managedForename);
        data.put("managedSurname", managedSurname);

        return JsonUtil.writeData(data);
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                    + ((this.managedForename == null) ? 0 : this.managedForename.hashCode());
        result = prime * result
                    + ((this.managedSurname == null) ? 0 : this.managedSurname.hashCode());
        result = prime * result
                    + ((this.managedUsername == null) ? 0 : this.managedUsername.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        UserManagementEvent other = (UserManagementEvent) obj;
        if (this.managedForename == null)
        {
            if (other.managedForename != null) return false;
        }
        else if (!this.managedForename.equals(other.managedForename)) return false;
        if (this.managedSurname == null)
        {
            if (other.managedSurname != null) return false;
        }
        else if (!this.managedSurname.equals(other.managedSurname)) return false;
        if (this.managedUsername == null)
        {
            if (other.managedUsername != null) return false;
        }
        else if (!this.managedUsername.equals(other.managedUsername)) return false;
        return true;
    }

}
