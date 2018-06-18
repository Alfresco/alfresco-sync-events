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
package org.alfresco.events.activiti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.alfresco.events.types.DataItem;
import org.alfresco.repo.events.JsonUtil;

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
        Map<String, List<String>> data = new HashMap<>();
        if (items != null && !items.isEmpty())
        {
            data.put("items", items);
        }

        return JsonUtil.writeData(data);
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
                    .append(this.items).append("]")
                    .append(" Json is: "+getDataAsJson());
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
