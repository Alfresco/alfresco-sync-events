/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.events.types;

import java.util.Date;

import org.alfresco.repo.Client;
import org.alfresco.repo.Client.ClientType;

/**
 * An event that occurs when using a web browser.
 * This usually takes place within a Share site (but Site information isn't mandatory).
 *
 * @author Gethin James
 */
public class BrowserEvent extends EventImpl implements ClientEvent, SiteEvent
{
    private static final long serialVersionUID = 382560004647243948L;
    public static final String BROWSER_EVENT_TYPE = "browser";
    
    private String siteId;
    private String txnId;
    private String networkId; // network/tenant
    
    private String component; //aka Page
    private String action;
    private String agent;
    private String attributes; //json map of additional attributes

    public BrowserEvent()
    {
        super();
    }
    
    /**
     * Constructor for BrowserEvent
     * @param username - the user
     * @param networkId - network/tenant
     * @param siteId
     * @param txnId
     * @param component - page eg. "documentdetails"
     * @param action - eg. "view"
     * @param agent - browser user agent
     * @param attributes - optional additional attributes as a json map eg. {"liked":"true"}
     */
    public BrowserEvent(String username, String networkId, String txnId, String siteId,
                String component, String action, String agent, String attributes)
    {
        super(-1, BROWSER_EVENT_TYPE, new Date().getTime(), username);
        this.siteId = siteId;
        this.txnId = txnId;
        this.networkId = networkId;
        this.component = component;
        this.action = action;
        this.agent = agent;
        this.attributes = attributes;
    }
    
    @Override
    public Client getClient()
    {
        return Client.asType(ClientType.webclient);
    }

    @Override
    public String getSiteId()
    {
        return this.siteId;
    }

    @Override
    public String getTxnId()
    {
        return this.txnId;
    }

    @Override
    public String getNetworkId()
    {
        return this.networkId;
    }

    public String getComponent()
    {
        return this.component;
    }

    public String getAction()
    {
        return this.action;
    }

    public String getAgent()
    {
        return this.agent;
    }

    public String getAttributes()
    {
        return this.attributes;
    }

    public void setSiteId(String siteId)
    {
        this.siteId = siteId;
    }

    public void setTxnId(String txnId)
    {
        this.txnId = txnId;
    }

    public void setNetworkId(String networkId)
    {
        this.networkId = networkId;
    }

    public void setComponent(String component)
    {
        this.component = component;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public void setAgent(String agent)
    {
        this.agent = agent;
    }

    public void setAttributes(String attributes)
    {
        this.attributes = attributes;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("BrowserEvent [id=").append(this.id).append(", type=").append(this.type)
                    .append(", username=").append(this.username).append(", timestamp=")
                    .append(this.timestamp).append(", siteId=").append(this.siteId)
                    .append(", txnId=").append(this.txnId).append(", networkId=")
                    .append(this.networkId).append(", component=").append(this.component).append(", action=")
                    .append(this.action).append(", agent=").append(this.agent)
                    .append(", attributes=").append(this.attributes).append("]");
        return builder.toString();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.action == null) ? 0 : this.action.hashCode());
        result = prime * result + ((this.agent == null) ? 0 : this.agent.hashCode());
        result = prime * result + ((this.attributes == null) ? 0 : this.attributes.hashCode());
        result = prime * result + ((this.component == null) ? 0 : this.component.hashCode());
        result = prime * result + ((this.networkId == null) ? 0 : this.networkId.hashCode());
        result = prime * result + ((this.siteId == null) ? 0 : this.siteId.hashCode());
        result = prime * result + ((this.txnId == null) ? 0 : this.txnId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        BrowserEvent other = (BrowserEvent) obj;
        if (this.action == null)
        {
            if (other.action != null) return false;
        }
        else if (!this.action.equals(other.action)) return false;
        if (this.agent == null)
        {
            if (other.agent != null) return false;
        }
        else if (!this.agent.equals(other.agent)) return false;
        if (this.attributes == null)
        {
            if (other.attributes != null) return false;
        }
        else if (!this.attributes.equals(other.attributes)) return false;
        if (this.component == null)
        {
            if (other.component != null) return false;
        }
        else if (!this.component.equals(other.component)) return false;
        if (this.networkId == null)
        {
            if (other.networkId != null) return false;
        }
        else if (!this.networkId.equals(other.networkId)) return false;
        if (this.siteId == null)
        {
            if (other.siteId != null) return false;
        }
        else if (!this.siteId.equals(other.siteId)) return false;
        if (this.txnId == null)
        {
            if (other.txnId != null) return false;
        }
        else if (!this.txnId.equals(other.txnId)) return false;
        return true;
    }

}
