package com.example.graphsexample;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.graphsexample.models.DataEntry;
import com.example.graphsexample.models.DataItem;
import com.example.graphsexample.samples.SampleService;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineChartActivity extends AppCompatActivity {
    LineChart lineChart = null;
    LineData lineData;
    List<Entry> entryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line_chart);

        lineChart = findViewById(R.id.cart2);
        setSize();

        SampleService sampleService = new SampleService();
        DataItem item = sampleService.getSamples();
        List<String> xLabels = new ArrayList<String>();

        int x = 0;
        for (DataEntry entry: item.getDataset() ){
            System.out.println("ENTRYSET="+entry.getFormattedValue());

            entryList.add(new Entry(x, entry.getFormattedValue()));
            xLabels.add("14:"+x);
            x++;
        }

        LineDataSet lineDataSet = new LineDataSet(entryList, "teste");
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(lineDataSet);

        lineData = new LineData(dataSets);
        lineData.setDrawValues(false);


        lineChart.getLegend().setEnabled(false);
        lineChart.setScaleEnabled(false);
        lineChart.setDoubleTapToZoomEnabled(false);
        lineChart.setDescription(null);
        lineChart.getAxisRight().setDrawLabels(false);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.setDrawBorders(false);

        List<String> xAxisValues = new ArrayList<>(xLabels);
        lineChart.getXAxis().setValueFormatter(new com.github.mikephil.charting.formatter.IndexAxisValueFormatter(xAxisValues));
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setLabelRotationAngle(-90);
        xAxis.setLabelCount(xAxisValues.size());
        xAxis.setGranularityEnabled(true);

        lineChart.setData(lineData);
        lineChart.setVisibleXRangeMaximum(10);

        lineChart.invalidate();
    }

    private void setSize(){
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        LineChart lineChart = findViewById(R.id.cart2);

        ViewGroup.LayoutParams params = lineChart.getLayoutParams();

        if (getApplication().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            params.height = metrics.heightPixels - (metrics.heightPixels/6);
            params.width = metrics.widthPixels;
        }else{
            params.height = metrics.heightPixels/2;
            params.width = metrics.widthPixels;
        }

        lineChart.setLayoutParams(params);
    }
}
