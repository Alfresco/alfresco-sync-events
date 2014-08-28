/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.events.activiti;

import java.io.Serializable;

/** Represents one task for a human user.
  * A simplified version of org.activiti.engine.task.Task
 *
 * @author Gethin James
 * @since 5.0
 */
public class TaskEvent extends StepEvent implements Serializable
{
    private static final long serialVersionUID = -6247010247438420546L;
    
    public TaskEvent()
    {
        super();
    }

    public TaskEvent(String type, String username, Long timestamp, String networkId)
    {
        super(type, username, timestamp, networkId);
    }

    /** The id of the activity in the process defining this task or null if this is not related to a process */
    String taskDefinitionKey;
    
    /** Free text description of the task. */
    String description;
    
    /** Indication of how important/urgent this task is */
    int priority;
 
    /** The {@link User.getId() userId} of the person to which this task is delegated. */
    String assignee;
      
    /** The {@link User.getId() userId} of the person that is responsible for this task. */
    String owner;
    
    /** The category of the task. This is an optional field and allows to 'tag' tasks as belonging to a certain category. */
    String category; 
    
    /** Due date of the task. */
    Long dueTime;

    public String getTaskDefinitionKey()
    {
        return this.taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey)
    {
        this.taskDefinitionKey = taskDefinitionKey;
    }

    public int getPriority()
    {
        return this.priority;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }

    public String getAssignee()
    {
        return this.assignee;
    }

    public void setAssignee(String assignee)
    {
        this.assignee = assignee;
    }

    public String getOwner()
    {
        return this.owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public Long getDueTime()
    {
        return this.dueTime;
    }

    public void setDueTime(Long dueTime)
    {
        this.dueTime = dueTime;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getCategory()
    {
        return this.category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("TaskEvent [id=").append(this.id).append(", type=").append(this.type)
                    .append(", username=").append(this.username).append(", timestamp=")
                    .append(this.timestamp).append(", networkId=").append(this.networkId)
                    .append(", stepId=").append(this.stepId).append(", stepName=")
                    .append(this.stepName).append(", processDefinitionId=")
                    .append(this.processDefinitionId).append(", processInstanceId=")
                    .append(this.processInstanceId).append(", activityType=")
                    .append(this.activityType).append(", behaviorClass=")
                    .append(this.behaviorClass).append(", createTime=").append(this.createTime)
                    .append(", endTime=").append(this.endTime).append(", duration=")
                    .append(this.duration).append(", state=").append(this.state)
                    .append(", taskDefinitionKey=").append(this.taskDefinitionKey)
                    .append(", description=").append(this.description).append(", priority=")
                    .append(this.priority).append(", assignee=").append(this.assignee)
                    .append(", owner=").append(this.owner).append(", category=")
                    .append(this.category).append(", dueTime=").append(this.dueTime).append("]");
        return builder.toString();
    }

  /** the parent task for which this task is a subtask */
  //String getParentTaskId();
  
  /** Indicated whether this task is suspended or not. */
  //boolean isSuspended();
  
  
}
