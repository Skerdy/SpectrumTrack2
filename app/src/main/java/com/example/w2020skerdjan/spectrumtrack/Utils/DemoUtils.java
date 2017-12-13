package com.example.w2020skerdjan.spectrumtrack.Utils;
import com.example.w2020skerdjan.spectrumtrack.Models.DemoItem;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by W2020 Android on 12/13/2017.
 */



public class DemoUtils {
    int currentOffset;

    public DemoUtils() {
    }

    public List<DemoItem> moarItems(int qty) {
        List<DemoItem> items = new ArrayList<>();

        for (int i = 0; i < qty; i++) {
            int colSpan = Math.random() < 0.2f ? 2 : 1;
            // Swap the next 2 lines to have items with variable
            // column/row span.
            // int rowSpan = Math.random() < 0.2f ? 2 : 1;
            int rowSpan = colSpan;
            DemoItem item = new DemoItem(colSpan, rowSpan, currentOffset + i);
            items.add(item);
        }

        currentOffset += qty;

        return items;
    }
}
