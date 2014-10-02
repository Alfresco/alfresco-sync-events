/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.events.activiti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.alfresco.events.types.DataItem;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**  
 * An ActivitiEvent related to the Alfresco-specific "bpm_package" variable
 *
 * @author Gethin James
 * @since 5.0
 */
public class PackageVariableEvent extends VariableEvent implements DataItem
{
    private static final long serialVersionUID = -3709657782849421550L;
    
    List<String> items;
    
    public PackageVariableEvent()
    {
        super();
    }

    public PackageVariableEvent(String type, String username, Long timestamp, String networkId)
    {
        super(type, username, timestamp, networkId);
    }

    public PackageVariableEvent(VariableEvent variableEvent)
    {
        super();
        copyFrom(variableEvent);
    }
    
    @Override
    public String getDataAsJson()
    {
        Map<String,String> data = new HashMap<>(); 
        if (items != null && !items.isEmpty())
        {
          data.put("items", JSONValue.toJSONString(items));
        }
        JSONObject json = new JSONObject(data);
        return json.toJSONString();
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("PackageVariableEvent [variableName=").append(this.variableName)
                    .append(", variableValue=").append(this.variableValue)
                    .append(", variableType=").append(this.variableType)
                    .append(", processInstanceId=").append(this.processInstanceId)
                    .append(", taskId=").append(this.taskId).append(", id=").append(this.id)
                    .append(", type=").append(this.type).append(", username=")
                    .append(this.username).append(", timestamp=").append(this.timestamp)
                    .append(", networkId=").append(this.networkId).append(", items=")
                    .append(this.items).append("]");
        return builder.toString();
    }

    public List<String> getItems()
    {
        return this.items;
    }

    public void setItems(List<String> items)
    {
        this.items = items;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.items == null) ? 0 : this.items.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        PackageVariableEvent other = (PackageVariableEvent) obj;
        if (this.items == null)
        {
            if (other.items != null) return false;
        }
        else if (!this.items.equals(other.items)) return false;
        return true;
    }

}
