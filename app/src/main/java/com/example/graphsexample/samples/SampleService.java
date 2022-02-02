package com.example.graphsexample.samples;

import com.example.graphsexample.models.DataEntry;
import com.example.graphsexample.models.DataItem;

public class SampleService {

    public DataItem getSamples(){
        int x = 60;
        DataEntry[] dataSet = new DataEntry[x];

        for (int xx=0; xx < x; xx++){
            DataEntry dataEntry = new DataEntry("14:" + xx, xx*2);
            dataSet[xx] = dataEntry;
        }

        DataItem item = new DataItem("ItemA", "#FFFFFF", dataSet);

        return item;
    }

}
