/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.events.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.alfresco.events.activiti.PackageVariableEvent;
import org.alfresco.events.activiti.ProcessDefinition;
import org.alfresco.events.activiti.ProcessEvent;
import org.alfresco.events.activiti.ProcessEventImpl;
import org.alfresco.events.activiti.ProcessInstance;
import org.alfresco.events.activiti.StepEvent;
import org.alfresco.events.activiti.TaskEvent;
import org.alfresco.events.activiti.VariableEvent;
import org.alfresco.events.types.ActivityEvent;
import org.alfresco.events.types.BasicNodeEvent;
import org.alfresco.events.types.BasicNodeEventImpl;
import org.alfresco.events.types.BrowserEvent;
import org.alfresco.events.types.ContentEvent;
import org.alfresco.events.types.ContentReadRangeEvent;
import org.alfresco.events.types.DataItem;
import org.alfresco.events.types.Event;
import org.alfresco.events.types.RepositoryEvent;
import org.alfresco.events.types.RepositoryEventImpl;
import org.alfresco.events.types.SiteEvent;
import org.alfresco.events.types.SiteManagementEvent;
import org.alfresco.events.types.SyncEvent;
import org.alfresco.events.types.UserManagementEvent;
import org.alfresco.repo.Client;
import org.alfresco.repo.Client.ClientType;

/**
 * Produces Events for testing
 *
 * @author Gethin James
 */
public class EventFactory
{
    private static String TYPE_CONTENT = "{http://www.alfresco.org/model/content/1.0}content";
    /**
     * Produces ActivityEvent objects
     * @param type
     * @param nodeId
     * @param siteId
     * @param name
     * @param mimeType
     * @return ActivityEvent
     */
    public static ActivityEvent createActivityEvent(String type, String username, String nodeId, String siteId, String name, String mimeType)
    {
        return new ActivityEvent(type, "t123", "alfresco.com", username, nodeId,siteId,null,Client.asType(ClientType.aos),
                  "{\"title\": \"exception.docx\", \"nodeRef\": \"workspace://SpacesStore\20a64aa3-392a-449b-abf7-3599a371cc0a\", \"page\": \"document-details?nodeRef=workspace://SpacesStore/20a64aa3-392a-449b-abf7-3599a371cc0a\"}"
                    , name, mimeType, 50l, "UTF-8");
    }
    
    /**
     * Produces RepositoryEvent objects
     * @param type
     * @param usernname
     * @return RepositoryEvent
     */
    public static RepositoryEvent createRepositoryEvent(String type, String username)
    {
        return new RepositoryEventImpl(type, "t123", "alfresco.com", new Date().getTime(), username);
    }
    
    /**
     * Produces BrowserEvent objects
     * @param siteId
     * @param username
     * @param component
     * @param action
     * @return
     */
    public static BrowserEvent createBrowserEvent( String siteId, String username, String component, String action)
    {
        return new BrowserEvent(username,"alfresco.com", "t123", siteId, component, action, null, null);
    }
    
    /**
     * Produces BasicNodeEvent objects
     * @param type
     * @param username
     * @return
     */
    public static BasicNodeEvent createBasicNodeEvent(String type, String username)
    {
        return new BasicNodeEventImpl(type, "t123", null, new Date().getTime(), username);
    }
    
    /**
     * Produces ContentEvent objects
     * @param username
     * @param siteId
     * @param nodeId
     * @param mimeType
     * @return
     */
    public static ContentEvent createContentEvent(String siteId,  String username, String nodeId, String mimeType)
    {
        return new ContentReadRangeEvent(username,"alfresco.com", "t123", nodeId, siteId, TYPE_CONTENT,
                    Client.asType(ClientType.ftp), "filename",mimeType, 50l, "UTF-8", "1-4");
    }
    

    /**
     * Produces SyncEvent objects
     * @param type
     * @param username
     * @param siteId
     * @param nodeId
     * @param mimeType
     * @return
     */
    public static SyncEvent createSyncEvent(String type, String username, String siteId,  String nodeId, String mimeType)
    {
        return new SyncEvent(type, username, "alfresco.com", "t123", nodeId, siteId, TYPE_CONTENT,
                    Client.asType(ClientType.cloud), "filename",mimeType, 50l, "UTF-8", "remote"+nodeId, "remote.alfresco.com", "sync2389");
    }
    
    /**
     * Produces UserManagementEvent objects
     * @param type
     * @param username
     * @param managedUsername
     * @param managedForename
     * @param managedSurname
     * @return
     */
    public static UserManagementEvent createUserEvent(String type, String username, String managedUsername, String managedForename, String managedSurname)
    {
        return new UserManagementEvent(type, "t123", "alfresco.com", new Date().getTime(), username, managedUsername,
                   managedForename, managedSurname);
    }
    
    /**
     * Produces SiteEvent objects
     * @param type
     * @param username
     * @param siteId
     * @return
     */
    public static SiteEvent createSiteEvent(String type, String username, String siteId)
    {
        return new SiteManagementEvent(type, "t123", "alfresco.com", new Date().getTime(), username, siteId,
                    "title for"+siteId, "desc for"+siteId, "PUBLIC", "site-dashboard");
    }

    /**
     * Produces DataItem objects
     * @param type
     * @param username
     * @param siteId
     * @return
     */
    public static DataItem createDataItem(String type, String username, String siteId)
    {
        return new SiteManagementEvent(type, "t123", "alfresco.com", new Date().getTime(), username, siteId,
                    "title for"+siteId, "desc for"+siteId, "PUBLIC", "site-dashboard");
    }
    
    public static ProcessEvent createActivitiProcessEvent(String type, String username)
    {
       ProcessDefinition processDefinition = new ProcessDefinition("my-process:1:17", "my-process:1:17", "http://www.activiti.org/test", "my-process", null, null);
       ProcessInstance process = new ProcessInstance("18", null, "bKey", "my-process:1:17");     
       return new ProcessEventImpl(type, username, new Date().getTime(), null, processDefinition, process);
    }
 
    public static StepEvent createActivitiStepEvent(String type, String username, String stepId)
    {
        StepEvent step = new StepEvent(type, username, new Date().getTime(), null);
        step.setProcessDefinitionId("my-process:1:17");
        step.setProcessInstanceId("18");
        step.setStepId(stepId);
        step.setStepName("name"+stepId);
        step.setState(StepEvent.ACTIVE);
        return step;
    }
 
    public static TaskEvent createActivitiTaskEvent(String type, String username, String stepId)
    {
        long now = new Date().getTime();
        TaskEvent task = new TaskEvent(type, username, now, null);
        task.setProcessDefinitionId("my-process:1:19");
        task.setProcessInstanceId("19");
        task.setStepId(stepId);
        task.setStepName("name"+stepId);
        task.setTaskDefinitionKey("key1");
        task.setPriority(5);
        task.setAssignee(username);
        task.setOwner(username);
        task.setCreateTime(now);
        task.setState(StepEvent.ACTIVE);
        return task;
    }
    
    public static VariableEvent createActivitiVariableEvent(String type, String username, String varName)
    {
        VariableEvent event = new VariableEvent(type,username,new Date().getTime(),null);
        event.setVariableName(varName);
        event.setVariableType("String");
        event.setVariableValue(varName.toUpperCase());
        event.setProcessInstanceId("19");
        return event;
    }
    
    public static List<Event> createEvents(String siteId, String username)
    {
        List<Event> events = new ArrayList<Event>();
        events.add(createActivityEvent("org.alfresco.documentlibrary.file-added",username, null, siteId, "filename.txt", "text/html"));
        events.add(createActivityEvent("org.alfresco.documentlibrary.file-created", username, null, siteId, "filename1.txt", "text/plain"));
        events.add(createBrowserEvent(siteId, username, "webpage", "view"));
        events.add(createContentEvent(siteId, username, "node234", "application/pdf"));   
        events.add(createRepositoryEvent("login", username));
        events.add(createSyncEvent("to.cloud", username, siteId, "node134", "application/pdf"));                    
        events.add(createSiteEvent("site.create", username, siteId));
        return events;
    }
    
    public static List<Event> createActivitiEvents(String username)
    {
        List<Event> events = new ArrayList<Event>();
        events.add(createActivitiProcessEvent("ACTIVITI_PROCESS_STARTED", username));
        events.add(createActivitiStepEvent("ACTIVITI_ACTIVITY_STARTED", username, "3"));
        events.add(createActivitiTaskEvent("ACTIVITI_TASK_CREATED", username, "4"));
        events.add(createActivitiVariableEvent("ACTIVITI_VARIABLE_CREATED", username, "var55"));
        events.add(new PackageVariableEvent(createActivitiVariableEvent("ACTIVITI_VARIABLE_CREATED", username, "bpm_package")));
        return events;
    }
  
}