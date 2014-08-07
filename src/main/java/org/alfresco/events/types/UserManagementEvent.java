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

import org.json.simple.JSONObject;

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
        super(type, txnId, networkId, timestamp, username);
        
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

	@Override
	public String getDataAsJson() {
		Map<String,String> data = new HashMap<>();
		data.put("managedUsername", managedUsername);
		data.put("managedForename", managedForename);		
		data.put("managedSurname", managedSurname);

		JSONObject json = new JSONObject(data);
		return json.toJSONString();
	}
}
