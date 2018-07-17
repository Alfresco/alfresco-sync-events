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
package org.alfresco.sync.events.types.permission;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.alfresco.sync.repo.Client;

/**
 * Local permission event
 * 
 * @author cpopa
 */
public abstract class LocalPermissionUpdatedEvent extends PermissionsEvent
{
    private static final long serialVersionUID = -6529830631955623978L;
    protected String authority;
    protected String permission;

    protected LocalPermissionUpdatedEvent(String authority, String permission, long seqNumber, String name, String type, String txnId,
            long timestamp, String networkId, String siteId, String nodeId, String nodeType, List<String> paths, List<List<String>> parentNodeIds,
            String username, Long nodeModificationTime, Client client, Set<String> aspects, Map<String, Serializable> nodeProperties)
    {
        super(seqNumber, name, type, txnId, timestamp, networkId, siteId, nodeId, nodeType, paths, parentNodeIds, username, nodeModificationTime,
                client, aspects, nodeProperties);
        this.authority = authority;
        this.permission = permission;
    }

    public LocalPermissionUpdatedEvent()
    {
    }

    public String getAuthority()
    {
        return this.authority;
    }

    public String getPermission()
    {
        return this.permission;
    }

    public void setAuthority(final String authority)
    {
        this.authority = authority;
    }

    public void setPermission(final String permission)
    {
        this.permission = permission;
    }

    @Override
    public String toString()
    {
        return "LocalPermissionUpdatedEvent(super=" + super.toString() + ", authority=" + this.getAuthority() + ", permission="
                + this.getPermission() + ")";
    }
}
