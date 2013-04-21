/**
 * Copyright (C) 2011, 2012 Alejandro Ayuso
 *
 * This file is part of Jongo.
 * Jongo is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * Jongo is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Jongo.  If not, see <http://www.gnu.org/licenses/>.
 */
package jongo.config.impl;

import org.apache.commons.lang.StringUtils;

/**
 * MSSQL DatabaseConfiguration implementation. Needs to be implemented. Volunteers?
 */
@Deprecated
public class MSSQLConfiguration {
    
    public String getListOfTablesQuery() {
        return "select * from information_schema.tables where Table_Type = 'BASE TABLE'";
    }
    
    /**
     * MSSQL doesn't support the standard way as described in http://en.wikipedia.org/wiki/Select_(SQL)#FETCH_FIRST_clause
     * @param table
     * @return a MSSQL query that when executed should only return the first row of a table.
     */
    public String getFirstRowQuery(final String table) {
        if(StringUtils.isBlank(table))
            throw new IllegalArgumentException("Table name can't be blank, empty or null");
        return "SELECT TOP 1 * FROM " + table;
    }
    
}
