package com.example.graphsexample.models;

public class DataEntry {
    private String formattedDate;
    private float formattedValue;

    public DataEntry(String formattedDate, float formattedValue ) {
        this.formattedDate = formattedDate;
        this.formattedValue = formattedValue;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public float getFormattedValue() {
        return formattedValue;
    }
}
