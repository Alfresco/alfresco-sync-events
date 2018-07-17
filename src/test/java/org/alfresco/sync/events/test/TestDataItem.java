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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.alfresco.sync.events.activiti.PackageVariableEvent;
import org.alfresco.sync.events.types.DataItem;
import org.alfresco.sync.events.types.Event;
import org.alfresco.sync.events.types.SiteManagementEvent;
import org.alfresco.sync.events.types.UserManagementEvent;
import org.alfresco.sync.repo.events.JsonUtil;
import org.gytheio.messaging.jackson.ObjectMapperFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Tests DataItem serialization
 *
 * @author Gethin James
 */
public class TestDataItem {

    ObjectMapper messagingObjectMapper = ObjectMapperFactory.createInstance();
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testUser() {
        
        DataItem item = (DataItem) EventFactory.createUserEvent("user.update", "userna", "barbie", "Barbie", "Doll");
        Map<String,String> items = (Map<String, String>) JsonUtil.readData(item.getDataAsJson());
        assertNotNull(items);
        assertEquals ("barbie",items.get("managedUsername"));
        assertEquals ("Barbie",items.get("managedForename"));
        assertEquals ("Doll",items.get("managedSurname"));      
    }
    
    @Test
    public void testDataItemRoundTrip() throws IOException {
        UserManagementEvent uEvent = EventFactory.createUserEvent("user.update", "userna", "barbie", "Barbie", "Doll");
        UserManagementEvent res = (UserManagementEvent) serializeAndDeserialEvent(uEvent);
        assertEquals(uEvent, res);
        Map<String,String> items = (Map<String, String>) JsonUtil.readData(res.getDataAsJson());
        assertNotNull(items);
        assertEquals ("barbie",items.get("managedUsername"));
        assertEquals ("Barbie",items.get("managedForename"));
        assertEquals ("Doll",items.get("managedSurname"));        
        
        SiteManagementEvent sEvent = (SiteManagementEvent) EventFactory.createSiteEvent("site.create", "userna", "nice site");
        SiteManagementEvent result =  (SiteManagementEvent) serializeAndDeserialEvent(sEvent);
        assertEquals(sEvent, result);      
        items = (Map<String, String>) JsonUtil.readData(result.getDataAsJson());
        assertNotNull(items);
        assertEquals ("nice site",items.get("siteId"));
        assertEquals ("PUBLIC",items.get("visibility"));
    }
    
    protected Event serializeAndDeserialEvent(Event event) throws IOException,
                JsonGenerationException, JsonMappingException, JsonParseException
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        messagingObjectMapper.writeValue(out, event);

        Object b = messagingObjectMapper.readValue(out.toString(), Object.class);
        assertTrue(b instanceof Event);
        return (Event) b;
    }

    @Test
    public void testPackageVariableEvent() throws ParseException {
        
        PackageVariableEvent pve = new PackageVariableEvent(EventFactory.createActivitiVariableEvent("ACTIVITI_VARIABLE_CREATED", "user", "bpm_package"));
        Map<String,String> items = (Map<String, String>) JsonUtil.readData(pve.getDataAsJson());
        assertNotNull(items);
        pve.setItems(null);
        items = (Map<String, String>) JsonUtil.readData(pve.getDataAsJson());
        assertNotNull(items);
        List<String> nodeList = new ArrayList<String>();
        pve.setItems(nodeList);
        items = (Map<String, String>) JsonUtil.readData(pve.getDataAsJson());
        assertNotNull(items);
        nodeList.add("node1");
        nodeList.add("node2");
        String jsonItems = pve.getDataAsJson();
        System.out.println(jsonItems);
        assertEquals ("{\"items\":[\"node1\",\"node2\"]}", jsonItems);
        Map<String,List<String>> nodeitems = (Map<String,List<String>>) JsonUtil.readData(pve.getDataAsJson());
        assertNotNull(nodeitems);
        List<String> nodes = nodeitems.get("items");
        assertEquals ("node1",nodes.get(0));
        assertEquals ("node2",nodes.get(1));
        
    }
    
    @Test
    public void testSite() throws ParseException {
        String siteId = "nice site";
        DataItem item = (DataItem) EventFactory.createSiteEvent("site.create", "userna", "nice site");
        Map<String,String> items = (Map<String, String>) JsonUtil.readData(item.getDataAsJson());
        assertNotNull(items);
        assertTrue (items.containsKey("title"));
        assertTrue (items.containsKey("siteId"));
        assertTrue (items.containsKey("visibility"));
        assertTrue (items.containsKey("sitePreset"));
        assertEquals (siteId,items.get("siteId"));
    }

}
