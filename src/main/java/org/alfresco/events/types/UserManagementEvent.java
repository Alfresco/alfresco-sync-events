/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
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
