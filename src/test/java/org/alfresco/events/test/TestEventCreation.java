/*
 * Copyright 2014 Alfresco Software, Ltd.  All rights reserved.
 *
 * License rights for this program may be obtained from Alfresco Software, Ltd. 
 * pursuant to a written agreement and any use of this program without such an 
 * agreement is prohibited. 
 */
package org.alfresco.events.test;

import static org.junit.Assert.*;

import java.util.List;

import org.alfresco.events.types.Event;
import org.junit.Test;

/**
 * Just tests the creation of many of the events
 *
 * @author Gethin James
 */
public class TestEventCreation
{

    @Test
    public void test()
    {
        List<Event> events = EventFactory.createEvents("mysite", "my user");
        assertNotNull(events);
    }

}
