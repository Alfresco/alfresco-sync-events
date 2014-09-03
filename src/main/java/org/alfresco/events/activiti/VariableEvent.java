/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
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

}
