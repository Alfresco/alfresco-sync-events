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
package org.alfresco.events.types;



/**
 * 
 * @author sglover
 *
 */
public enum DataType
{
    Text()
    {
        public String toString()
        {
            return "d:text";
        }
    },
    Any()
    {
        public String toString()
        {
            return "d:any";
        }
    },
    Encrypted()
    {
        public String toString()
        {
            return "d:encryped";
        }
    },
    Content()
    {
        public String toString()
        {
            return "d:content";
        }
    },
    Mltext()
    {
        public String toString()
        {
            return "d:mltext";
        }
    },
    Int()
    {
        public String toString()
        {
            return "d:int";
        }
    },
    Long()
    {
        public String toString()
        {
            return "d:long";
        }
    },
    Float()
    {
        public String toString()
        {
            return "d:float";
        }
    },
    Double()
    {
        public String toString()
        {
            return "d:double";
        }
    },
    Date()
    {
        public String toString()
        {
            return "d:date";
        }
    },
    Datetime()
    {
        public String toString()
        {
            return "d:datetime";
        }
    },
    Boolean()
    {
        public String toString()
        {
            return "d:boolean";
        }
    },
    Qname()
    {
        public String toString()
        {
            return "d:text";
        }
    },
    Noderef()
    {
        public String toString()
        {
            return "d:noderef";
        }
    },
    Childassocref()
    {
        public String toString()
        {
            return "d:childassocref";
        }
    },
    Assocref()
    {
        public String toString()
        {
            return "d:assocref";
        }
    },
    Path()
    {
        public String toString()
        {
            return "d:path";
        }
    },
    Category()
    {
        public String toString()
        {
            return "d:category";
        }
    },
    Locale()
    {
        public String toString()
        {
            return "d:locale";
        }
    },
    Version()
    {
        public String toString()
        {
            return "d:version";
        }
    },
    Period()
    {
        public String toString()
        {
            return "d:period";
        }
    };
}
