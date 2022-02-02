package com.example.graphsexample.models;

public class DataItem {
    public String item_label;
    public String item_color;
    public DataEntry[] dataset;

    public DataItem(String item_label, String item_color, DataEntry[] dataset) {
        this.item_label = item_label;
        this.item_color = item_color;
        this.dataset = dataset;
    }

    public String getItem_label() {
        return item_label;
    }

    public String getItem_color() {
        return item_color;
    }

    public DataEntry[] getDataset() {
        return dataset;
    }
}
