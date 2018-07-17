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
package org.alfresco.sync.events.activiti;

import java.io.Serializable;

/**
 * A simplified version of org.activiti.engine.runtime.ProcessInstance
 *
 * Represents one execution of a ProcessDefinition
 * 
 * @author Gethin James
 * @since 5.0
 */
public class ProcessInstance implements Serializable
{
    private static final long serialVersionUID = -6162556141654634489L;
    
    public ProcessInstance()
    {
        super();
    }

    public ProcessInstance(String id, String name, String businessKey, String processDefinitionId)
    {
        super();
        this.id = id;
        this.name = name;
        this.businessKey = businessKey;
        this.processDefinitionId = processDefinitionId;
    }
 
    /** unique identifier */
    String id;

    /**
     * Returns the name of this process instance. 
     */
    String name;
    
    /**
     * The business key of this process instance.
     */
    String businessKey;   

    /**
     * The id of the process definition of the process instance.
     */
    String processDefinitionId;
    
    /** The date/time when this process was created */
    Long createTime;
    
    /** The date/time when this process ended */
    Long endTime;
    
   // Long duration;
    
    String state;
    
    /** The {@link User.getId() userId} of the person who started the process. */
    String startUser;


    public String getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getBusinessKey()
    {
        return this.businessKey;
    }

    public String getProcessDefinitionId()
    {
        return this.processDefinitionId;
    }

    public Long getCreateTime()
    {
        return this.createTime;
    }

    public Long getEndTime()
    {
        return this.endTime;
    }

    public String getState()
    {
        return this.state;
    }

    public String getStartUser()
    {
        return this.startUser;
    }

    public void setCreateTime(Long createTime)
    {
        this.createTime = createTime;
    }

    public void setEndTime(Long endTime)
    {
        this.endTime = endTime;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public void setStartUser(String startUser)
    {
        this.startUser = startUser;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Process [id=").append(this.id).append(", name=").append(this.name)
                    .append(", businessKey=").append(this.businessKey)
                    .append(", processDefinitionId=").append(this.processDefinitionId)
                    .append(", createTime=").append(this.createTime).append(", endTime=")
                    .append(this.endTime)
                    .append(", state=").append(this.state).append(", startUser=")
                    .append(this.startUser).append("]");
        return builder.toString();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.businessKey == null) ? 0 : this.businessKey.hashCode());
        result = prime * result + ((this.createTime == null) ? 0 : this.createTime.hashCode());
        result = prime * result + ((this.endTime == null) ? 0 : this.endTime.hashCode());
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime
                    * result
                    + ((this.processDefinitionId == null) ? 0 : this.processDefinitionId.hashCode());
        result = prime * result + ((this.startUser == null) ? 0 : this.startUser.hashCode());
        result = prime * result + ((this.state == null) ? 0 : this.state.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ProcessInstance other = (ProcessInstance) obj;
        if (this.businessKey == null)
        {
            if (other.businessKey != null) return false;
        }
        else if (!this.businessKey.equals(other.businessKey)) return false;
        if (this.createTime == null)
        {
            if (other.createTime != null) return false;
        }
        else if (!this.createTime.equals(other.createTime)) return false;
        if (this.endTime == null)
        {
            if (other.endTime != null) return false;
        }
        else if (!this.endTime.equals(other.endTime)) return false;
        if (this.id == null)
        {
            if (other.id != null) return false;
        }
        else if (!this.id.equals(other.id)) return false;
        if (this.name == null)
        {
            if (other.name != null) return false;
        }
        else if (!this.name.equals(other.name)) return false;
        if (this.processDefinitionId == null)
        {
            if (other.processDefinitionId != null) return false;
        }
        else if (!this.processDefinitionId.equals(other.processDefinitionId)) return false;
        if (this.startUser == null)
        {
            if (other.startUser != null) return false;
        }
        else if (!this.startUser.equals(other.startUser)) return false;
        if (this.state == null)
        {
            if (other.state != null) return false;
        }
        else if (!this.state.equals(other.state)) return false;
        return true;
    }
    
    /** 
     * Returns the process variables if requested in the process instance query 
     */
   // Map<String, Object> processVariablesOrItems;
    
  //  String bpm_description;//variable
  //  String bpm_percentComplete; //variable  //How does this get updated? //This is on task?
   // String bpm_package; //variable

    /**
     * returns true if the process instance is suspended
     */
    //boolean isSuspended();
    //String getDeleteReason();

}
