/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.events.activiti;

import org.alfresco.events.types.TenantedEvent;

/**
 * Something that happens to an Activiti Process. 
 *
 * @author Gethin James
 * @since 5.0
 *  
 */
public interface ProcessEvent extends TenantedEvent
{
    public static final String ACTIVE = "ACTIVE";
    public static final String COMPLETED = "COMPLETED";
    
    ProcessDefinition getProcessDefinition();
    ProcessInstance getProcess();
}
