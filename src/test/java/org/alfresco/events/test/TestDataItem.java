/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.events.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.alfresco.events.activiti.PackageVariableEvent;
import org.alfresco.events.types.DataItem;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDataItem {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

    @Test
    public void testUser() throws ParseException {
        
        DataItem item = (DataItem) EventFactory.createUserEvent("user.update", "userna", "barbie", "Barbie", "Doll");
        JSONParser parser = new JSONParser();
        JSONObject jo = (JSONObject) parser.parse(item.getDataAsJson());
        assertNotNull(jo);
        assertEquals ("barbie",jo.get("managedUsername"));
        assertEquals ("Barbie",jo.get("managedForename"));
        assertEquals ("Doll",jo.get("managedSurname"));      
    }

    @Test
    public void testPackageVariableEvent() throws ParseException {
        
        PackageVariableEvent pve = new PackageVariableEvent(EventFactory.createActivitiVariableEvent("ACTIVITI_VARIABLE_CREATED", "user", "bpm_package"));
        JSONParser parser = new JSONParser();
        JSONObject jo = (JSONObject) parser.parse(pve.getDataAsJson());
        assertNotNull(jo);
        assertNull(jo.get("items"));
        pve.setItems(null);
        jo = (JSONObject) parser.parse(pve.getDataAsJson());
        assertNotNull(jo);
        assertNull(jo.get("items"));
        List<String> nodeList = new ArrayList<String>();
        pve.setItems(nodeList);
        jo = (JSONObject) parser.parse(pve.getDataAsJson());
        assertNotNull(jo);
        assertNull(jo.get("items"));
        nodeList.add("node1");
        nodeList.add("node2");
        jo = (JSONObject) parser.parse(pve.getDataAsJson());
        assertNotNull(jo);
        Object items = jo.get("items");
        assertNotNull(items);
    }
    
	@Test
	public void testSite() throws ParseException {
		String siteId = "nice site";
		DataItem item = (DataItem) EventFactory.createSiteEvent("site.create", "userna", "nice site");
		assertNotNull(item);
		JSONParser parser = new JSONParser();
		JSONObject jo = (JSONObject) parser.parse(item.getDataAsJson());
		assertNotNull(jo);
		assertTrue (jo.containsKey("title"));
		assertTrue (jo.containsKey("siteId"));
		assertTrue (jo.containsKey("visibility"));
		assertTrue (jo.containsKey("sitePreset"));
		assertEquals (siteId,jo.get("siteId"));
	}

}
