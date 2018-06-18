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
package org.alfresco.events;

import java.util.Date;

/**
 * Node version bean.
 * 
 * @author steveglover
 *
 */
public class NodeVersion
{
	private String versionedId;
	private String versionId;
	private Date modifiedAt;
	private String modifiedBy;
	private String versionLabel;
	private VersionType versionType;
	private String description;
	private String siteId;
	
    public NodeVersion(String siteId, String versionedId, String versionId,
			Date modifiedAt, String modifiedBy, String versionLabel,
			VersionType versionType, String description)
	{
		super();
		this.versionedId = versionedId;
		this.versionId = versionId;
		this.modifiedAt = modifiedAt;
		this.modifiedBy = modifiedBy;
		this.versionLabel = versionLabel;
		this.versionType = versionType;
		this.description = description;
	}

	public String getSiteId()
	{
		return siteId;
	}

	public Date getModifiedAt()
    {
    	return modifiedAt;
    }
    
    public String getModifiedBy()
    {
    	return modifiedBy;
    }
    
    public String getVersionLabel()
    {
        return versionLabel;
    }    
    
    public VersionType getVersionType()
    {
        return versionType;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String getVersionedId()
    {
        return versionedId;
    }
    
    public String getVersionId()
    {
        return versionId;
    }
}
