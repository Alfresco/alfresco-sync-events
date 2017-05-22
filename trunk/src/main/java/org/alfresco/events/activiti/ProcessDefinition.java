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

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.category == null) ? 0 : this.category.hashCode());
        result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.key == null) ? 0 : this.key.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.version == null) ? 0 : this.version.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ProcessDefinition other = (ProcessDefinition) obj;
        if (this.category == null)
        {
            if (other.category != null) return false;
        }
        else if (!this.category.equals(other.category)) return false;
        if (this.description == null)
        {
            if (other.description != null) return false;
        }
        else if (!this.description.equals(other.description)) return false;
        if (this.id == null)
        {
            if (other.id != null) return false;
        }
        else if (!this.id.equals(other.id)) return false;
        if (this.key == null)
        {
            if (other.key != null) return false;
        }
        else if (!this.key.equals(other.key)) return false;
        if (this.name == null)
        {
            if (other.name != null) return false;
        }
        else if (!this.name.equals(other.name)) return false;
        if (this.version == null)
        {
            if (other.version != null) return false;
        }
        else if (!this.version.equals(other.version)) return false;
        return true;
    }

}
