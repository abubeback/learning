package com.abu.jdk.temp;

public enum QualityProcessStatus {
    OPEN("OPEN"),
    COMPLETED("COMPLETE"),
    SUBMITTED("IN_PROGRESS");

    private String name;

    QualityProcessStatus(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static QualityProcessStatus getByName(String name) {
        for (QualityProcessStatus qualityProcessStatus : values()) {
            if (qualityProcessStatus.name().equalsIgnoreCase(name)) {
                return qualityProcessStatus;
            }
        }
        return null;
    }
}