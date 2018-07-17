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

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.alfresco.sync.events.types.Event;
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
