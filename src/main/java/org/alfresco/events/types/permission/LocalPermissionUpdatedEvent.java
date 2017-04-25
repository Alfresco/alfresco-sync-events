/*
 * Copyright 2017 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.events.types.permission;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.alfresco.repo.Client;

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
