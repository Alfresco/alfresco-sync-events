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

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.process == null) ? 0 : this.process.hashCode());
        result = prime * result
                    + ((this.processDefinition == null) ? 0 : this.processDefinition.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ProcessEventImpl other = (ProcessEventImpl) obj;
        if (this.process == null)
        {
            if (other.process != null) return false;
        }
        else if (!this.process.equals(other.process)) return false;
        if (this.processDefinition == null)
        {
            if (other.processDefinition != null) return false;
        }
        else if (!this.processDefinition.equals(other.processDefinition)) return false;
        return true;
    }

}
