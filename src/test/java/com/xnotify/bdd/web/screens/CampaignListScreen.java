package com.xnotify.bdd.web.screens;

import com.xnotify.bdd.integrations.common_utils.TableSchema;
import java.util.LinkedHashMap;
import java.util.Map;

public class CampaignListScreen {

    public static final String ROWS = "//tbody/tr";

    public TableSchema campaignTable() {

        Map<String, String> columns = new LinkedHashMap<>();

        columns.put(
                "Campaign Name",
                "td:nth-child(1)");

        columns.put(
                "Channel",
                "td:nth-child(2)");

        columns.put(
                "Status",
                "td:nth-child(3)");

        columns.put(
                "Created By",
                "td:nth-child(4)");

        columns.put(
                "Created At",
                "td:nth-child(5)");

        return new TableSchema(
                ROWS,
                columns);
    }
}