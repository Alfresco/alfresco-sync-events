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
