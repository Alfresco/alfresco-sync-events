/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.repo;

/**
 * Any client that connects to Alfresco, based on FileFilterMode.Client
 * It has additional clients beyond those originally available in FileFilterMode.Client.
 *
 * @author Gethin James
 */
public class Client
{
    public Client()
    {
        super();
    }

    public static enum ClientType
    {
        cifs, imap, webdav, nfs, script, webclient, ftp, cmis, admin, spp, cloud;
    }

    private ClientType type;
    
    public Client(ClientType type)
    {
        super();
        this.type = type;
    }

    public static Client asType(ClientType type)
    {
        return new Client(type);
    }

    public ClientType getType()
    {
        return this.type;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Client [type=").append(this.type).append("]");
        return builder.toString();
    }
    

}
