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
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.alfresco.events.activiti.PackageVariableEvent;
import org.alfresco.events.types.DataItem;
import org.alfresco.repo.events.JsonUtil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests DataItem serialization
 *
 * @author Gethin James
 */
public class TestDataItem {

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
