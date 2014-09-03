package org.alfresco.events.activiti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.alfresco.events.types.DataItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
        Map<String,String> data = new HashMap<>(); 
        if (items != null && !items.isEmpty())
        {
          data.put("items", JSONArray.toJSONString(items));
        }
        JSONObject json = new JSONObject(data);
        return json.toJSONString();
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
                    .append(this.items).append("]");
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

}
