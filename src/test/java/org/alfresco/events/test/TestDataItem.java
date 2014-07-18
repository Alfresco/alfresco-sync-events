package org.alfresco.events.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.alfresco.events.types.DataItem;
import org.alfresco.events.types.SiteManagementEvent;
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
	public void testGetDataAsJson() throws ParseException {
		String siteId = "nice site";
		DataItem item = new SiteManagementEvent("site.create", "t123", "alfresco.com", new Date().getTime(), "userna", siteId,
                "title for"+siteId, "desc for"+siteId, "PUBLIC", "site-dashboard");
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
