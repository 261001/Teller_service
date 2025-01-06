package com.b2camp.teller_service.enums;

public enum TransactionType {
    CREDIT("Credit", "C"),
    DEBIT("Debit", "D");

    private final String type;
    private final String description;

    TransactionType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return type + ": " + description;
    }
}
