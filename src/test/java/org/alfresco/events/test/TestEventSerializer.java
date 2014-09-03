/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.events.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.alfresco.events.types.Event;
import org.gytheio.messaging.jackson.ObjectMapperFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Basic test for jackson serialization for Alfresco events.
 * 
 * @author Gethin James
 *
 */
public class TestEventSerializer {

	ObjectMapper messagingObjectMapper = ObjectMapperFactory.createInstance();
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRoundTrip() throws IOException {
		List<Event> events = EventFactory.createEvents("testsite1", "jsmith");
		
		for (Event event : events) {
			serializeAndDeserialEvent(event);
		}
		
		events = EventFactory.createActivitiEvents("my user");
		
		for (Event event : events) {
			serializeAndDeserialEvent(event);
		}
		
		serializeAndDeserialEvent(EventFactory.createNodeAddedEvent("node.add", "my user", "nodeId1", "testexsite"));
	}

	protected void serializeAndDeserialEvent(Event event) throws IOException,
			JsonGenerationException, JsonMappingException, JsonParseException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		messagingObjectMapper.writeValue(out, event);
		
		Object b =  messagingObjectMapper.readValue(out.toString(), Object.class);
		assertTrue(b instanceof Event);
		assertEquals(b,event);
	}

}
