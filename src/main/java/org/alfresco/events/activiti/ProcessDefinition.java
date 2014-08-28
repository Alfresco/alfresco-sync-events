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
 * A simplified version of org.activiti.engine.repository.ProcessDefinition
 *
 * An object structure representing an executable process composed of 
 * activities and transitions.
 
 * @author Gethin James
 * @since 5.0
 */
public class ProcessDefinition implements Serializable
{
    private static final long serialVersionUID = 8332075744319010072L;
 
    public ProcessDefinition()
    {
        super();
    }

    public ProcessDefinition(String id, String name, String category, String key,
                String description, Integer version)
    {
        super();
        this.id = id;
        this.name = name;
        this.category = category;
        this.key = key;
        this.description = description;
        this.version = version;
    }


    /** unique identifier */
    String id;

    /** category name which is derived from the targetNamespace attribute in the definitions element */
    String category;
    
    /** label used for display purposes */
    String name;
    
    /** unique name for all versions of this process definitions */
    String key;
    
    /** description of this process **/
    String description;
    
    /** version of this process definition */
    Integer version;

    public String getId()
    {
        return this.id;
    }

    public String getCategory()
    {
        return this.category;
    }

    public String getName()
    {
        return this.name;
    }

    public String getKey()
    {
        return this.key;
    }

    public String getDescription()
    {
        return this.description;
    }

    public Integer getVersion()
    {
        return this.version;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("ProcessDefinition [id=").append(this.id).append(", category=")
                    .append(this.category).append(", name=").append(this.name).append(", key=")
                    .append(this.key).append(", description=").append(this.description)
                    .append(", version=").append(this.version).append("]");
        return builder.toString();
    }

}
