/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
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
}
