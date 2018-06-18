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
 * An Activity (also known as Step) that is part of an Activiti process.
 * 
 * Task is one type of Activity. See TaskEvent.
 *
 * @author Gethin James
 * @since 5.0
 */
public class StepEvent extends AbstractActivitiEvent implements InProcess
{
    private static final long serialVersionUID = 965409539663152885L;
    public static final String ACTIVE = "ACTIVE";
    public static final String COMPLETED = "COMPLETED";

    public StepEvent()
    {
        super();
    }
    
    public StepEvent(String type, String username, Long timestamp, String networkId)
    {
        super(type, username, timestamp, networkId);
    }

    /** id of the step. */
    String stepId;
    
    /** Name or title of the step. */
    String stepName;
    /**
     * The id of the process definition of the process instance.
     */
    String processDefinitionId;
    
    /** unique identifier */
    String processInstanceId;
    
    /**
     * @return the type of the activity (if set during parsing).
     */
    String activityType;
    
    /**
     * @return the behaviourclass of the activity (if it could be determined)
     */
    String behaviorClass;
    
    /** The date/time when this task was created */
    Long createTime;

    /** The date/time when this task ended */
    Long endTime;
    
    Long duration;
    
    String state;

    public String getStepId()
    {
        return this.stepId;
    }

    public void setStepId(String stepId)
    {
        this.stepId = stepId;
    }

    public String getStepName()
    {
        return this.stepName;
    }

    public void setStepName(String stepName)
    {
        this.stepName = stepName;
    }

    public String getProcessDefinitionId()
    {
        return this.processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId)
    {
        this.processDefinitionId = processDefinitionId;
    }

    public String getProcessInstanceId()
    {
        return this.processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId)
    {
        this.processInstanceId = processInstanceId;
    }

    public String getActivityType()
    {
        return this.activityType;
    }

    public void setActivityType(String activityType)
    {
        this.activityType = activityType;
    }

    public String getBehaviorClass()
    {
        return this.behaviorClass;
    }

    public void setBehaviorClass(String behaviorClass)
    {
        this.behaviorClass = behaviorClass;
    }

    public Long getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Long createTime)
    {
        this.createTime = createTime;
    }

    public Long getEndTime()
    {
        return this.endTime;
    }

    public void setEndTime(Long endTime)
    {
        this.endTime = endTime;
    }

    public Long getDuration()
    {
        return this.duration;
    }

    public void setDuration(Long duration)
    {
        this.duration = duration;
    }

    public String getState()
    {
        return this.state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("StepEvent [id=").append(this.id).append(", type=").append(this.type)
                    .append(", username=").append(this.username).append(", timestamp=")
                    .append(this.timestamp).append(", networkId=").append(this.networkId)
                    .append(", stepId=").append(this.stepId).append(", stepName=")
                    .append(this.stepName).append(", processDefinitionId=")
                    .append(this.processDefinitionId).append(", processInstanceId=")
                    .append(this.processInstanceId).append(", activityType=")
                    .append(this.activityType).append(", behaviorClass=")
                    .append(this.behaviorClass).append(", createTime=").append(this.createTime)
                    .append(", endTime=").append(this.endTime).append(", duration=")
                    .append(this.duration).append(", state=").append(this.state).append("]");
        return builder.toString();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.activityType == null) ? 0 : this.activityType.hashCode());
        result = prime * result
                    + ((this.behaviorClass == null) ? 0 : this.behaviorClass.hashCode());
        result = prime * result + ((this.createTime == null) ? 0 : this.createTime.hashCode());
        result = prime * result + ((this.duration == null) ? 0 : this.duration.hashCode());
        result = prime * result + ((this.endTime == null) ? 0 : this.endTime.hashCode());
        result = prime
                    * result
                    + ((this.processDefinitionId == null) ? 0 : this.processDefinitionId.hashCode());
        result = prime * result
                    + ((this.processInstanceId == null) ? 0 : this.processInstanceId.hashCode());
        result = prime * result + ((this.state == null) ? 0 : this.state.hashCode());
        result = prime * result + ((this.stepId == null) ? 0 : this.stepId.hashCode());
        result = prime * result + ((this.stepName == null) ? 0 : this.stepName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        StepEvent other = (StepEvent) obj;
        if (this.activityType == null)
        {
            if (other.activityType != null) return false;
        }
        else if (!this.activityType.equals(other.activityType)) return false;
        if (this.behaviorClass == null)
        {
            if (other.behaviorClass != null) return false;
        }
        else if (!this.behaviorClass.equals(other.behaviorClass)) return false;
        if (this.createTime == null)
        {
            if (other.createTime != null) return false;
        }
        else if (!this.createTime.equals(other.createTime)) return false;
        if (this.duration == null)
        {
            if (other.duration != null) return false;
        }
        else if (!this.duration.equals(other.duration)) return false;
        if (this.endTime == null)
        {
            if (other.endTime != null) return false;
        }
        else if (!this.endTime.equals(other.endTime)) return false;
        if (this.processDefinitionId == null)
        {
            if (other.processDefinitionId != null) return false;
        }
        else if (!this.processDefinitionId.equals(other.processDefinitionId)) return false;
        if (this.processInstanceId == null)
        {
            if (other.processInstanceId != null) return false;
        }
        else if (!this.processInstanceId.equals(other.processInstanceId)) return false;
        if (this.state == null)
        {
            if (other.state != null) return false;
        }
        else if (!this.state.equals(other.state)) return false;
        if (this.stepId == null)
        {
            if (other.stepId != null) return false;
        }
        else if (!this.stepId.equals(other.stepId)) return false;
        if (this.stepName == null)
        {
            if (other.stepName != null) return false;
        }
        else if (!this.stepName.equals(other.stepName)) return false;
        return true;
    }
}
