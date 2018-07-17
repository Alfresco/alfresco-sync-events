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
package org.alfresco.sync.repo.events;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Basic utility class for use with the Jackson json library.
 *
 * @author Gethin James
 */
public class JsonUtil
{
    private static ObjectMapper mapper = new ObjectMapper();
    
    public static String writeData(Map<String, ?> data)
    {
        try
        {
            return mapper.writeValueAsString(data);
        }
        catch (JsonProcessingException error)
        {
            // do nothing
            return "{}";
        }
    }
    
    
    @SuppressWarnings("unchecked")
    public static Map<String, ?> readData(String data)
    {
        try
        {
            return mapper.readValue(data.getBytes(), Map.class);
        }
        catch (IOException error)
        {
            // do nothing
            return null;
        }
    }
}
