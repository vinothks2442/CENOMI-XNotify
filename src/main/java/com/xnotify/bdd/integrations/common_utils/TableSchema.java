package com.xnotify.bdd.integrations.common_utils;

import java.util.Map;

public class TableSchema {

    private final String rowLocator;
    private final Map<String, String> columns;

    public TableSchema(String rowLocator, Map<String, String> columns) {
        this.rowLocator = rowLocator;
        this.columns = columns;
    }

    public String getRowLocator() {
        return rowLocator;
    }

    public Map<String, String> getColumns() {
        return columns;
    }

}
