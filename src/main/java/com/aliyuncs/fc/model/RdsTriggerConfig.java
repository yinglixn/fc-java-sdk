package com.aliyuncs.fc.model;

public class RdsTriggerConfig {

    private String tables;

    private Integer retry;

    private Integer concurrency;

    private String eventFormat;

    public RdsTriggerConfig(String tables, Integer retry, Integer concurrency, String eventFormat) {
        this.tables = tables;
        this.retry = retry;
        this.concurrency = concurrency;
        this.eventFormat = eventFormat;
    }

    public Integer getConcurrency() {
        return concurrency;
    }

    public Integer getRetry() {
        return retry;
    }

    public String getEventFormat() {
        return eventFormat;
    }

    public String getTables() {
        return tables;
    }

    public void setConcurrency(Integer concurrency) {
        this.concurrency = concurrency;
    }

    public void setEventFormat(String eventFormat) {
        this.eventFormat = eventFormat;
    }

    public void setRetry(Integer retry) {
        this.retry = retry;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }
}
