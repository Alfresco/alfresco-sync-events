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
package org.alfresco.sync.repo;

/**
 * Any client that connects to Alfresco, based on FileFilterMode.Client
 * It has additional clients beyond those originally available in FileFilterMode.Client.
 *
 * @author Gethin James
 * @author sglover
 */
public class Client
{
    public Client()
    {
        super();
    }

    public static enum ClientType
    {
        cifs, imap, webdav, nfs, script, webclient, ftp, cmis, admin, aos, cloud, salesforce, restapi;
    }

    private ClientType type;
    private String clientId; // alfrescoClientId, used by device sync to identify a specific client
    
    public Client(ClientType type, String clientId)
    {
        super();
        this.type = type;
        this.clientId = clientId;
    }

    public static Client asType(ClientType type)
    {
        return new Client(type, null);
    }

    public ClientType getType()
    {
        return this.type;
    }

    public String getClientId()
    {
        return this.clientId;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Client [type=").append(this.type).append(", clientId=")
                    .append(this.clientId).append("]");
        return builder.toString();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.clientId == null) ? 0 : this.clientId.hashCode());
        result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Client other = (Client) obj;
        if (this.clientId == null)
        {
            if (other.clientId != null) return false;
        }
        else if (!this.clientId.equals(other.clientId)) return false;
        if (this.type != other.type) return false;
        return true;
    }
}
