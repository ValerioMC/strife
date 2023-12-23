package com.forge.strife.to;

public interface TaskRecordGroup {
    record TaskRequest(String requirement, String description, String component, Integer weight) {}
}
