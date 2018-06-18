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

/**  
 * An ActivitiEvent related to a single variable.
 *
 * @author Gethin James
 * @since 5.0
 */
public class VariableEvent extends AbstractActivitiEvent implements InProcess
{
    private static final long serialVersionUID = 5537228166211779922L;
    
    public VariableEvent()
    {
        super();
    }
    
    public VariableEvent(String type, String username, Long timestamp, String networkId)
    {
        super(type, username, timestamp, networkId);
    }

    /**
     * @return the name of the variable involved.
     */
    String variableName;
    
    /**
     * @return the current value of the variable.
     */
    String variableValue;
    
    /**
     * @return The VariableType of the variable.
     */
    String variableType;
    
    /** unique identifier */
    String processInstanceId;
       
    /**
     * @return the id of the task the variable has been set on.
     */
    String taskId;

    public String getVariableName()
    {
        return this.variableName;
    }

    public void setVariableName(String variableName)
    {
        this.variableName = variableName;
    }

    public String getVariableValue()
    {
        return this.variableValue;
    }

    public void setVariableValue(String variableValue)
    {
        this.variableValue = variableValue;
    }

    public String getVariableType()
    {
        return this.variableType;
    }

    public void setVariableType(String variableType)
    {
        this.variableType = variableType;
    }

    public String getProcessInstanceId()
    {
        return this.processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId)
    {
        this.processInstanceId = processInstanceId;
    }

    public String getTaskId()
    {
        return this.taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public void copyFrom(VariableEvent source)
    {
      this.id = source.id;
      this.networkId = source.networkId;
      this.timestamp = source.timestamp;
      this.type = source.type;
      this.username  = source.username;  
      this.processInstanceId = source.processInstanceId;
      this.taskId = source.taskId;
      this.variableName = source.variableName;
      this.variableType = source.variableType;
      this.variableValue = source.variableValue;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("VariableEvent [id=").append(this.id).append(", type=").append(this.type)
                    .append(", username=").append(this.username).append(", timestamp=")
                    .append(this.timestamp).append(", networkId=").append(this.networkId)
                    .append(", variableName=").append(this.variableName).append(", variableValue=")
                    .append(this.variableValue).append(", variableType=").append(this.variableType)
                    .append(", processInstanceId=").append(this.processInstanceId)
                    .append(", taskId=").append(this.taskId).append("]");
        return builder.toString();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                    + ((this.processInstanceId == null) ? 0 : this.processInstanceId.hashCode());
        result = prime * result + ((this.taskId == null) ? 0 : this.taskId.hashCode());
        result = prime * result + ((this.variableName == null) ? 0 : this.variableName.hashCode());
        result = prime * result + ((this.variableType == null) ? 0 : this.variableType.hashCode());
        result = prime * result
                    + ((this.variableValue == null) ? 0 : this.variableValue.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        VariableEvent other = (VariableEvent) obj;
        if (this.processInstanceId == null)
        {
            if (other.processInstanceId != null) return false;
        }
        else if (!this.processInstanceId.equals(other.processInstanceId)) return false;
        if (this.taskId == null)
        {
            if (other.taskId != null) return false;
        }
        else if (!this.taskId.equals(other.taskId)) return false;
        if (this.variableName == null)
        {
            if (other.variableName != null) return false;
        }
        else if (!this.variableName.equals(other.variableName)) return false;
        if (this.variableType == null)
        {
            if (other.variableType != null) return false;
        }
        else if (!this.variableType.equals(other.variableType)) return false;
        if (this.variableValue == null)
        {
            if (other.variableValue != null) return false;
        }
        else if (!this.variableValue.equals(other.variableValue)) return false;
        return true;
    }

}
