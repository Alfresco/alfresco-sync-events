/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.events.activiti;

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
