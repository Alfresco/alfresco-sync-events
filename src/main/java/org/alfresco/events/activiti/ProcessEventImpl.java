/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.events.activiti;


/**
 * An implementation of a Process Event
 *
 * @author Gethin James
 * @since 5.0 
 */
public class ProcessEventImpl extends AbstractActivitiEvent implements ProcessEvent
{
    private static final long serialVersionUID = -6236311619284890430L;
    ProcessDefinition processDefinition;
    ProcessInstance process;
    
    public ProcessEventImpl()
    {
        super();
    }

    public ProcessEventImpl(String type, String username, Long timestamp, String networkId,
                ProcessDefinition processDefinition, ProcessInstance process)
    {
        super(type, username, timestamp, networkId);
        this.processDefinition = processDefinition;
        this.process = process;
    }

    @Override
    public ProcessDefinition getProcessDefinition()
    {
        return this.processDefinition;
    }

    @Override
    public ProcessInstance getProcess()
    {
        return this.process;
    }

    public void setProcessDefinition(ProcessDefinition processDefinition)
    {
        this.processDefinition = processDefinition;
    }

    public void setProcess(ProcessInstance process)
    {
        this.process = process;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("ProcessEvent [id=").append(this.id).append(", type=").append(this.type)
                    .append(", username=").append(this.username).append(", timestamp=")
                    .append(this.timestamp).append(", networkId=").append(this.networkId)
                    .append(", processDefinition=").append(this.processDefinition)
                    .append(", process=").append(this.process).append("]");
        return builder.toString();
    }

}
