package com.xnotify.bdd.integrations.common_utils;

import java.util.HashMap;
import java.util.Map;

public class FilterCriteria {

    private final Map<Integer, String> filters = new HashMap<>();

    public FilterCriteria campaignName(String value) {
        filters.put(1, value);
        return this;
    }

    public FilterCriteria channel(String value) {
        filters.put(2, value);
        return this;
    }

    public FilterCriteria status(String value) {
        filters.put(3, value);
        return this;
    }

    public FilterCriteria createdBy(String value) {
        filters.put(4, value);
        return this;
    }

    public FilterCriteria createdAt(String value) {
        filters.put(5, value);
        return this;
    }

    // Customer Segmentation Filters
    public FilterCriteria segmentName(String value) {
        filters.put(1, value);
        return this;
    }

    public FilterCriteria segmentType(String value) {
        filters.put(2, value);
        return this;
    }

    public FilterCriteria membername(String value) {
        filters.put(1, value);
        return this;
    }

    public FilterCriteria memberRole(String value) {
        filters.put(2, value);
        return this;
    }

    public FilterCriteria memberStatus(String value) {
        filters.put(3, value);
        return this;
    }

    public Map<Integer, String> build() {
        return filters;
    }
}