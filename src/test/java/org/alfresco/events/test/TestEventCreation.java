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
        
        events = EventFactory.createActivitiEvents("my user");
        assertNotNull(events);
    }

}
