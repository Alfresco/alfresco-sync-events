/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.events.types;

import org.alfresco.repo.Client;

/**
 * A Basic Event that occurs on an Alfresco node.
 * 
 * @author Gethin James
 * @author sglover
 */
public class BasicNodeEventImpl extends RepositoryEventImpl implements BasicNodeEvent
{
    private static final long serialVersionUID = -5915563756442975835L;
    
    protected String nodeId; // node id (guid)
    protected String siteId;
    protected String nodeType;
    protected String name;
    
    public BasicNodeEventImpl()
    {
        super();
    }

    public BasicNodeEventImpl(long sequenceNumber, String type, String txnId, String networkId, long timestamp,
    		String username, Client client)
    {
        super(sequenceNumber, type, txnId, networkId, timestamp, username, client);
    }

    public BasicNodeEventImpl(long sequenceNumber, String type, String txnId, String networkId, long timestamp,
                String username, String nodeId, String siteId, String nodeType, String name, Client client)
    {
        super(sequenceNumber, type, txnId, networkId, timestamp, username, client);
        this.nodeId = nodeId;
        this.siteId = siteId;
        this.nodeType = nodeType;
        this.client = client;
        this.name = name;
    }
    
    /*
     * @see org.alfresco.events.types.BasicNodeEvent#getNodeId()
     */
    @Override
    public String getNodeId()
    {
        return this.nodeId;
    }
    /*
     * @see org.alfresco.events.types.BasicNodeEvent#getSiteId()
     */
    @Override
    public String getSiteId()
    {
        return this.siteId;
    }
    /*
     * @see org.alfresco.events.types.BasicNodeEvent#getNodeType()
     */
    @Override
    public String getNodeType()
    {
        return this.nodeType;
    }

    /*
     * @see org.alfresco.events.types.BasicNodeEvent#getName()
     */
    @Override
    public String getName()
    {
        return name;
    }
    
    @Override
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    public void setNodeId(String nodeId)
    {
        this.nodeId = nodeId;
    }

    @Override
    public void setSiteId(String siteId)
    {
        this.siteId = siteId;
    }

    @Override
    public void setNodeType(String nodeType)
    {
        this.nodeType = nodeType;
    }
}