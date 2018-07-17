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
package org.alfresco.sync.events.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.alfresco.sync.events.activiti.PackageVariableEvent;
import org.alfresco.sync.events.activiti.ProcessDefinition;
import org.alfresco.sync.events.activiti.ProcessEvent;
import org.alfresco.sync.events.activiti.ProcessEventImpl;
import org.alfresco.sync.events.activiti.ProcessInstance;
import org.alfresco.sync.events.activiti.StepEvent;
import org.alfresco.sync.events.activiti.TaskEvent;
import org.alfresco.sync.events.activiti.VariableEvent;
import org.alfresco.sync.events.types.ActivityEvent;
import org.alfresco.sync.events.types.BasicNodeEvent;
import org.alfresco.sync.events.types.BasicNodeEventImpl;
import org.alfresco.sync.events.types.BrowserEvent;
import org.alfresco.sync.events.types.ContentEvent;
import org.alfresco.sync.events.types.ContentReadRangeEvent;
import org.alfresco.sync.events.types.DataItem;
import org.alfresco.sync.events.types.Event;
import org.alfresco.sync.events.types.NodeAddedEvent;
import org.alfresco.sync.events.types.RepositoryEvent;
import org.alfresco.sync.events.types.RepositoryEventImpl;
import org.alfresco.sync.events.types.SiteEvent;
import org.alfresco.sync.events.types.SiteManagementEvent;
import org.alfresco.sync.events.types.SyncEvent;
import org.alfresco.sync.events.types.UserManagementEvent;
import org.alfresco.sync.repo.Client;
import org.alfresco.sync.repo.Client.ClientType;

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
        return new RepositoryEventImpl(1, type, "t123", "alfresco.com", new Date().getTime(), username, null);
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
        return new BasicNodeEventImpl(1, type, "t123", null, new Date().getTime(), username, null);
    }
    
    /**
     * Produces BasicNodeEvent objects
     * @param type
     * @param username
     * @return
     */
    public static NodeAddedEvent createNodeAddedEvent(String type, String username, String nodeId, String siteId)
    {
        List<String> paths = Arrays.asList("path1", "path2");
        List<String> n1 = Arrays.asList("n1", "n2");
        List<String> m1 = Arrays.asList("m1", "m2");
        List<List<String>> pathNodeIds = Arrays.asList(n1, m1);
        return new NodeAddedEvent(34567899l, username, "t123", new Date().getTime(), "alfresco.com", siteId, nodeId, TYPE_CONTENT,
        paths, pathNodeIds, username, new Date().getTime(), Client.asType(ClientType.aos), null, null);
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
        task.setTaskId("23");
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
        events.add(createBasicNodeEvent("basic.node", username));
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